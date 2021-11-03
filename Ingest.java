import com.google.gson.*;

import com.google.gson.reflect.TypeToken;

import java.io.File;

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
    static int ingested = 0;

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
        
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        try {
            newClass.startTime = sdf.parse(startTime);
            newClass.endTime = sdf.parse(endTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        //System.out.println("Created new class (" + newClass.prefix + "." + newClass.courseNumber + "." + newClass.section + ")");

        return newClass;
    }
    static void ingestFile(File file) throws IOException, ParseException {
        System.out.println("Beginning ingest on " + file.getName());
        Gson gson = new Gson();
        FileReader reader = new FileReader(file);

        Type classListType = new TypeToken<ArrayList<rawClass>>(){}.getType();
        ArrayList<rawClass> classArray = gson.fromJson(reader, classListType);  
 
        for(rawClass ourClass : classArray) {
            Class newClass = createClass(ourClass);
            ClassMaster.addClass(newClass);
            ingested++;
        }
        System.out.println("Ingested " + classArray.size() + " classes from " + file.getName());
    }

    public static void startIngest() throws IOException, ParseException {
        //File[] files = new File("\\").listFiles();
        File[] files = new File("ClassData").listFiles();

        for (File file : files){
            if (file.isDirectory()){
                //System.out.println("Directory: " + filename.getName());
            } else {
                ingestFile(file);
                //System.out.println("File: " + filename.getName());
            }
        }

        System.out.println("Ingested " + ingested + " total classes.");
        ClassMaster.sortBuildings();
    }
}