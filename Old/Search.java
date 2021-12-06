import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;
import java.util.Collections;

import java.text.ParseException;

public class Search {
    static String returnClassUse(Class ourClass) {
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm aa");
        String ourString = ourClass.building + " " + ourClass.room + " (In use between " + sdf.format(ourClass.startTime) + " and " + sdf.format(ourClass.endTime) + " ";
        
        String abbDays = "";
        for (String day : ourClass.days) {
            abbDays = abbDays + day.substring(0,1);
        }
        ourString = ourString + "on " + abbDays + ")";
        return ourString;
    }

    static boolean checkIfDay(String[] days, String findDay) {
        for(String day : days) {
            if (day.equals(findDay)) {
                return false;
            }
        }
        return true;
    }

    static boolean checkClassTime(String day, String stringStart, String stringEnd, Class ourClass) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        Date startTime = sdf.parse(stringStart);
        Date endTime = sdf.parse(stringEnd);

        if(checkIfDay(ourClass.days,day)) {
            return true;
        } else if(startTime.after(ourClass.endTime) || endTime.before(ourClass.startTime)) {
            return true;
        } else {
            return false;
        }
    }

    static Floor getFloor(String building, int floor) {
        if (building.toLowerCase().equals("any")) {
            return null;
        } else {
            Building foundBuilding = ClassMaster.findBuild(building);
            return foundBuilding.findFloor(floor);
        }
    }

    static void search(String day, String building, int floor, String startTime, String endTime) throws ParseException {
        Building foundBuilding = ClassMaster.findBuild(building);
        Floor foundFloor = getFloor(building, floor);

        if((foundBuilding == null && !building.toLowerCase().equals("any")) || (foundFloor == null && floor != 0 && !building.toLowerCase().equals("any"))) {
            System.out.println("Building or floor are null");
            return;
        }
        
        ArrayList<Class> resultClass = new ArrayList<Class>();
        ArrayList<Class> thrownClass = new ArrayList<Class>();

        if (building.toLowerCase().equals("any")) {
            for(Building ourBuilding : ClassMaster.buildings) {
                for(Floor ourFloor : ourBuilding.floors) {
                    for(Class foundClass : ourFloor.classes) {
                        if (checkClassTime(day, startTime, endTime, foundClass) == true) {
                            resultClass.add(foundClass);
                        } else {
                            thrownClass.add(foundClass);
                        }
                    }
                }
            }
        }else if (floor == 0) {
            for(Floor ourFloor : foundBuilding.floors) {
                for(Class foundClass : ourFloor.classes) {
                    if (checkClassTime(day, startTime, endTime, foundClass) == true) {
                        resultClass.add(foundClass);
                    } else {
                        thrownClass.add(foundClass);
                    }
                }
            }
        } else {
            for(Class foundClass : foundFloor.classes) {
                if (checkClassTime(day, startTime, endTime, foundClass) == true) {
                    resultClass.add(foundClass);
                } else {
                    thrownClass.add(foundClass);
                }
            }
        }

        Collections.sort(resultClass);
        Collections.sort(thrownClass);
        
        System.out.println("Found " + resultClass.size() + " classes:");
        for(Class ourClass : resultClass) {
            System.out.println(returnClassUse(ourClass));
        }
        System.out.println("------");

        System.out.println("Threw " + thrownClass.size() + " classes:");
        for(Class ourClass : thrownClass) {
            System.out.println(returnClassUse(ourClass));
        }
        System.out.println("------");
    }
}