package Conotroller;

import Models.CabDriver;
import Models.Customer;
import Models.Location;
import Models.Taxi;
import Service.TaxiService;

import java.util.List;

public class TaxiController {

    TaxiService taxiService= new TaxiService();
    public Taxi IntializeTaxi(List<Location> locations, List<Customer> customers, List<CabDriver> cabDrivers){
        return taxiService.IntializeTaxi(locations,customers,cabDrivers);
    }
    public void cabdriverlogin(){
        taxiService.cabdriverlogin();
    }
    public Customer customerlogin(){
        return taxiService.customerlogin();
    }
    public void booktaxi(Customer customer){
        taxiService.booktaxi(customer);
    }
    public void RideSummary(){
        taxiService.RideSummary();
    }
    public void CustomerRidesummary(){
        taxiService.CustomerRidesummary();
    }
}
