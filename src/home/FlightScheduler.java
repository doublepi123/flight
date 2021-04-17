package home;

import jdk.internal.org.objectweb.asm.tree.LocalVariableAnnotationNode;

import java.util.*;

public class FlightScheduler {
    private Map<String, Integer> weekdayList;
    private Map<String, Location> locations;
    ArrayList<String> locationArrayList;
    ArrayList<Flight> flights;
    private static FlightScheduler instance;

    public static void main(String[] args) {
        instance = new FlightScheduler(args);
        instance.run();
    }

    public static FlightScheduler getInstance() {
        return instance;
    }

    private String getLocations(){
        String ans = "";
        locationArrayList.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        for(String location: locationArrayList) {
            ans += location + " ";
        }
        return ans;
    }

    public FlightScheduler(String[] args) {
    }

    public void run() {
        Scanner in = new Scanner(System.in);
        // Do not use System.exit() anywhere in your code,
        // otherwise it will also exit the auto test suite.
        // Also, do not use static attributes otherwise
        // they will maintain the same values between testcases.
        String input;
        locations = new HashMap<>();
        weekdayList = new HashMap<>();
        locationArrayList = new ArrayList<>();
        weekdayList.put("Monday", 1);
        weekdayList.put("Tuesday", 2);
        weekdayList.put("Wednesday", 3);
        weekdayList.put("Thursday", 4);
        weekdayList.put("Friday", 5);
        weekdayList.put("Saturday", 6);
        weekdayList.put("Sunday", 7);


        while (true) {
            input = in.nextLine();
            String[] s = input.split(" ");
            s[0] = s[0].toLowerCase(Locale.ROOT);
            try {
                s[1] = s[1].toLowerCase(Locale.ROOT);
            }catch (Exception e){
                ;
            }
            if (s[0].compareTo("exit") == 0) break;
            if (s[0].compareTo("flight") == 0) {
                if (s[1].compareTo("add") == 0) {
                    if (s.length < 7) {
                        System.out.println(" Usage: FLIGHT ADD <departure time>" +
                                "<from> <to> <capacity>\nExample: FLIGHT" +
                                "ADD Monday 18:00 Sydney Melbourne 120 ");
                        continue;
                    }
                    Location arrival = locations.get(s[5]), departure = locations.get(s[4]);
                    if (departure == null) {
                        System.out.println("Invalid starting location.");
                        continue;
                    }
                    if (arrival == null) {
                        System.out.println("Invalid ending location.");
                    }
                    String[] ts = s[3].split(":");
                    String hour = ts[0], minute = ts[1];
                    Flight flight = new Flight(arrival, departure, s[2], Integer.valueOf(hour), Integer.valueOf(minute),weekdayList.get(weekdayList));
                }
            }
            if(s[0].compareTo("location") == 0){
                if(s[1].compareTo("add") == 0){
                    locationArrayList.add(s[2]);
                }
            }
            if(s[0].compareTo("locations") == 0){
                System.out.println(getLocations()+"\n");
            }
        }

        // START YOUR CODE HERE
    }
}
