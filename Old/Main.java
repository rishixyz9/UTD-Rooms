import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

public class Main {
    public static void main(String args[]) throws IOException, ParseException {
        Ingest.startIngest();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter day"); // Monday/Tuesday/etc
        String day = scanner.nextLine();

        System.out.println("Enter building"); // ECSN, ECSW, etc
        String building = scanner.nextLine();

        System.out.println("Floor"); // NUM#
        int floor = Integer.parseInt(scanner.nextLine());

        System.out.println("Start Time"); // xx:xx
        String startTime = scanner.nextLine();

        System.out.println("End Time"); // xx:xx
        String endTime = scanner.nextLine();
        
        scanner.close();
        Search.search(day, building,floor,startTime,endTime);

        //ClassMaster.checkBuildings(); // Debug
    }
}