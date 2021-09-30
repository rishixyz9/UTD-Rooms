import java.util.ArrayList;

public class ClassMaster {
    static ArrayList<Building> buildings = new ArrayList<Building>();
    
    static boolean seeIfBuildingExists(String buildName) {
        for (Building ourBuild : buildings) {
            //System.out.println(ourBuild.name + " / " + buildName);
            if (ourBuild.name.equals(buildName)) {
                return true;
            }
        }
        return false;
    }

    static Building findBuild(String buildName) {
        for (Building ourBuild : buildings) {
            if (ourBuild.name.equals(buildName)) {
                return ourBuild;
            }
        }
        return null;
    }

    static void checkBuildings() {
        System.out.println("Checking child tree [CLASS MASTER]");
        System.out.println("---------");
        for (Building building : buildings) {
            building.checkChildren();
        }
        System.out.println("---------");
    }

    static void addClass(Class toAdd) {
        if (seeIfBuildingExists(toAdd.building) == false) {
            Building newBuilding = new Building();
            newBuilding.name = toAdd.building;
            buildings.add(newBuilding);
            
            newBuilding.addClass(toAdd);
        } else {
            Building ourBuilding = findBuild(toAdd.building);
            ourBuilding.addClass(toAdd);
        }
    }

    static void sortBuildings() {
        for (Building ourBuild : buildings) {
            ourBuild.sortChildren();
        }
    }
}