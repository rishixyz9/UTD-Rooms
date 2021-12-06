import java.util.Date;
import java.lang.Comparable;

public class Class implements Comparable<Class>{
    String prefix;
    String courseNumber;
    String section;
    
    String building;
    int floor;
    String room;

    String[] days;
    Date startTime;
    Date endTime;

    /*void setPrefix(String prefix) { this.prefix = prefix; };
    void setcourseNumber(int courseNumber) { this.courseNumber = courseNumber; };
    void setSection(int section) { this.section = section; };
    void setDays(String[] days) { this.days = days; };
    void setStartTime(Date startTime) { this.startTime = startTime; };
    void setEndTime(Date endTime) { this.endTime = endTime; };*/

    @Override
    public int compareTo(Class comparesTo) {
        if(((comparesTo.courseNumber).contains("v")) || ((this.courseNumber).contains("v"))) { // v classes -__-
            return -1;
        }

        double compareDouble = Double.parseDouble(comparesTo.courseNumber);
        double ourDouble = Double.parseDouble(this.courseNumber);

        int decided = 0;
        if (compareDouble > ourDouble) {
            decided = 1;
        }else{
            decided = -1;
        }
        
        return decided;
    }
}