package Models;

import java.util.List;

public class Taxi {
    private List<Location> locations;
    private List<Customer> customers;
    private List<CabDriver> cabDrivers;

    public Taxi(List<Location> locations, List<Customer> customers, List<CabDriver> cabDrivers) {
        this.locations = locations;
        this.customers = customers;
        this.cabDrivers = cabDrivers;
    }

    public List<Location> getLocations() {
        return locations;
    }

    public void setLocations(List<Location> locations) {
        this.locations = locations;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    public List<CabDriver> getCabDrivers() {
        return cabDrivers;
    }

    public void setCabDrivers(List<CabDriver> cabDrivers) {
        this.cabDrivers = cabDrivers;
    }
}
