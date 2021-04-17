package home;

public class Flight {
    private Location arrival;
    private Location departure;
    private int booked;
    private int capacity;
    private String weekday;

    public int getWeekNday() {
        return weekNday;
    }

    public void setWeekNday(int weekNday) {
        this.weekNday = weekNday;
    }

    private int weekNday;

    public String getWeekday() {
        return weekday;
    }

    public void setWeekday(String weekday) {
        this.weekday = weekday;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    private int hour;
    private int minute;


    public Flight(Location arrival, Location departure, String weekday, int hour, int minute,int weekNday) {
        this.arrival = arrival;
        this.departure = departure;
        this.weekday = weekday;
        this.hour = hour;
        this.minute = minute;
    }

    public Location getArrival() {
        return arrival;
    }

    public void setArrival(Location arrival) {
        this.arrival = arrival;
    }

    public Location getDeparture() {
        return departure;
    }

    public void setDeparture(Location departure) {
        this.departure = departure;
    }

    //get the number of minutes this flight takes (round to nearest whole number)
    public int getDuration() {
        return 0;
    }

    //implement the ticket price formula
    public double getTicketPrice() {
        double x = 1.0*booked/capacity;
        double y = 0;
        if(x <= 0.5) y = -0.4*x+1;
        else if (x <= 0.7) y = x+0.3;
        else y = 0.2/Math.PI*Math.atan(20*x-14)+1;
        return y*getDistance()/100*(30+4*(arrival.getDemand()- departure.getDemand()));
    }

    //book the given number of passengers onto this flight, returning the total cost
    public double book(int num) {
        double sum = 0;
        for(int i = 0 ; i < num; i++){
            sum += getTicketPrice();
            booked++;
        }
        return sum;
    }

    //return whether or not this flight is full
    public boolean isFull() {
		return booked == capacity;
	}

    //get the distance of this flight in km
    public double getDistance() {
		return arrival.distance(arrival, departure);
	}

    //get the layover time, in minutes, between two flights
    public static int layover(Flight x, Flight y) {
        return 0;
    }
}
