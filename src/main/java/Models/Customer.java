package Models;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private int Id;
    private String name;
    private String password;
    private int age;
    private List<TripDetails> tripDetails;

    public Customer(int id, String name, String password, int age) {
        Id = id;
        this.name = name;
        this.password = password;
        this.age = age;
        this.tripDetails=new ArrayList<>();
    }

    public List<TripDetails> getTripDetails() {
        return tripDetails;
    }

    public void setTripDetails(List<TripDetails> tripDetails) {
        this.tripDetails = tripDetails;
    }

    public int getId() {
        return Id;
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
}
