package Models;

import java.util.ArrayList;
import java.util.List;

public class CabDriver {
    private int Id;
    private String name;
    private String password;
    private int age;
    private char location;
    private int availabletime;
    private int totaltrips;
    private TripStatus tripStatus;
    private double Zulacommsion;
    private int totalearning;
    private List<TripDetails> tripDetails;
    public CabDriver(int id, String name, String password, int age, char location,int availabletime,int totaltrips) {
        Id = id;
        this.name = name;
        this.password = password;
        this.age = age;
        this.location = location;
        this.availabletime=availabletime;
        this.totaltrips=totaltrips;
        this.tripStatus=TripStatus.Available;
        this.Zulacommsion=0;
        this.totalearning=0;
        this.tripDetails=new ArrayList<>();
    }

    public List<TripDetails> getTripDetails() {
        return tripDetails;
    }

    public void setTripDetails(List<TripDetails> tripDetails) {
        this.tripDetails = tripDetails;
    }

    public int getTotalearning() {
        return totalearning;
    }

    public void setTotalearning(int totalearning) {
        this.totalearning = totalearning;
    }

    public double getZulacommsion() {
        return Zulacommsion;
    }

    public void setZulacommsion(double zulacommsion) {
        Zulacommsion = zulacommsion;
    }

    public TripStatus getTripStatus() {
        return tripStatus;
    }

    public void setTripStatus(TripStatus tripStatus) {
        this.tripStatus = tripStatus;
    }

    public int getTotaltrips() {
        return totaltrips;
    }

    public void setTotaltrips(int totaltrips) {
        this.totaltrips = totaltrips;
    }

    public int getId() {
        return Id;
    }

    public int getAvailabletime() {
        return availabletime;
    }

    public void setAvailabletime(int availabletime) {
        this.availabletime = availabletime;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public char getLocation() {
        return location;
    }

    public void setLocation(char location) {
        this.location = location;
    }
}
