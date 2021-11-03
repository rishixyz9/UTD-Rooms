import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

public class Main {
    public static void main(String args[]) throws IOException, ParseException {
        Ingest.startIngest();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter day");
        String day = scanner.nextLine();

        System.out.println("Enter building");
        String building = scanner.nextLine();

        System.out.println("Floor");
        int floor = Integer.parseInt(scanner.nextLine());

        System.out.println("Start Time");
        String startTime = scanner.nextLine();

        System.out.println("End Time");
        String endTime = scanner.nextLine();
        
        scanner.close();
        Search.search(day, building,floor,startTime,endTime);

        //ClassMaster.checkBuildings(); // Debug
    }
}