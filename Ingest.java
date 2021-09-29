import com.google.gson.*;

import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.util.ArrayList;
import java.io.IOException;

import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;

class rawClass {
    String course_prefix;
    String course_number;
    String section;

    String location;
    String days;
    String times;
}

public class Ingest {
    static Class createClass(rawClass oldClass) throws ParseException {
        Class newClass = new Class();
        newClass.prefix = oldClass.course_prefix;
        newClass.courseNumber = oldClass.course_number;
        newClass.section = oldClass.section.replaceAll("\\s", "");

        String location = oldClass.location;
        newClass.building = location.substring(0, location.indexOf(" "));
        newClass.room = location.substring(location.indexOf(" ")+1, location.length());
        newClass.floor = Integer.parseInt(newClass.room.substring(0,1));
        //System.out.println(building + "-" + floor + "-" + room);

        String days = oldClass.days;
        days = days.replaceAll("\\s", "");
        days = days.replaceAll("&", ",");
        newClass.days = days.split(",");

        String time = oldClass.times;
        time = time.replaceAll("\\s", "");
        String startTime = time.substring(0, time.indexOf("-"));
        String endTime = time.substring(time.indexOf("-")+1,time.length());
        
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm");
        try {
            newClass.startTime = sdf.parse(startTime);
            newClass.endTime = sdf.parse(endTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        System.out.println("Created new class (" + newClass.prefix + "." + newClass.courseNumber + "." + newClass.section + ")");

        return newClass;
    }

    public static void main(String args[]) throws IOException, ParseException {
        Gson gson = new Gson();

        FileReader reader = new FileReader("smallClasses.json");

        Type classListType = new TypeToken<ArrayList<rawClass>>(){}.getType();
        ArrayList<rawClass> classArray = gson.fromJson(reader, classListType);  
 
        for(rawClass ourClass : classArray) {
            Class newClass = createClass(ourClass);
            ClassMaster.addClass(newClass);
        }

        ClassMaster.checkBuildings();
    }
}