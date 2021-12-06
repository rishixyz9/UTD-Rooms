import java.util.ArrayList;
import java.lang.Comparable;

public class Floor implements Comparable<Floor>{
    int floor;
    ArrayList<Class> classes = new ArrayList<Class>();

    void checkChildren() {
        System.out.println("Showing classes on floor " + floor);
        for (Class ourClass : classes) {
            System.out.println("Class " + ourClass.prefix + "." + ourClass.courseNumber + "." + ourClass.section 
            + " (" + ourClass.building + " " + ourClass.room + ")");
        }
        System.out.println("---------");
    }

    void addClass(Class toAdd) {
        classes.add(toAdd);
        //System.out.println("Added class " + toAdd.prefix + "." + toAdd.courseNumber + "." + toAdd.section + " @ " + toAdd.building + " " + toAdd.room);
    }

    @Override
    public int compareTo(Floor comparesTo) {
        int compareNum=((Floor)comparesTo).floor;
        /* For Ascending order*/
        return this.floor-compareNum;
    }
}