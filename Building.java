import java.util.ArrayList;

public class Building {
    String name;
    ArrayList<Floor> floors = new ArrayList<Floor>();
    
    boolean seeIfFloorExists(int findFloor) {
        for (Floor floor : floors) {
            if (floor.floor == findFloor) {
                return true;
            }
        }
        return false;
    }

    Floor findFloor(int floorNumber) {
        for (Floor floor : floors) {
            if (floor.floor == floorNumber) {
                return floor;
            }
        }
        return null;
    }

    void checkChildren() {
        System.out.println("Showing results for building: " + name);
        for (Floor floor : floors) {
            floor.checkChildren();
        }
        System.out.println("---------");
    }

    void addClass(Class toAdd) {
        if (seeIfFloorExists(toAdd.floor) == false) {
            Floor newFloor = new Floor();
            newFloor.floor = toAdd.floor;
            floors.add(newFloor);

            newFloor.addClass(toAdd);
        } else {
            Floor ourFloor = findFloor(toAdd.floor);
            ourFloor.addClass(toAdd);
        }
    }
}