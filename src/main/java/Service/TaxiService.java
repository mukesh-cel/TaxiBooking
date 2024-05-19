package Service;

import Models.*;
import Repository.CabDriverRepository;
import Repository.CustomerRepository;
import Repository.LocationRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class TaxiService {
    LocationRepository locationRepository= new LocationRepository();
    CabDriverRepository cabDriverRepository= new CabDriverRepository();
    CustomerRepository customerRepository= new CustomerRepository();
    public Taxi IntializeTaxi(List<Location> locations, List<Customer> customers, List<CabDriver> cabDrivers){
        for(Customer c:customers){
            customerRepository.savecustomerinfo(c);
        }
        for(CabDriver c:cabDrivers){
            cabDriverRepository.savedriverinfo(c);
        }
        for(Location c:locations){
            locationRepository.savelocationinfo(c);
        }
        Taxi taxi= new Taxi(locations,customers,cabDrivers);
        return taxi;
    }

    public CabDriver cabdriverlogin(){
        Scanner scn = new Scanner(System.in);
        System.out.println("Eneter username");
        String name= scn.nextLine();
        System.out.println("Eneter password");
        String pswd=scn.nextLine();
        CabDriver cabDriver=cabDriverRepository.getdriverinfo(name);
        String savedpswd= cabDriver.getPassword();
        if(pswd.equals(savedpswd)){
            System.out.println("successful login");
            return cabDriver;
        }
        else {
            System.out.println("Incorrect pswd,try again");
        }
        return null;
    }
    public Customer customerlogin(){
        Scanner scn = new Scanner(System.in);
        System.out.println("Eneter username");
        String name= scn.nextLine();
        System.out.println("Eneter password");
        String pswd=scn.nextLine();
        Customer customer=customerRepository.getcustomerinfo(name);
        if(customer==null){
            System.out.println("\nEnter 1 to create new user");
            int n=scn.nextInt();
            if(n==1) {
                System.out.println("Enter username");
                String newname = scn.nextLine();
                System.out.println("Enter password");
                String newpswd = scn.nextLine();
                System.out.println("Enter age");
                int age = scn.nextInt();
                System.out.println("Enter id");
                int id = scn.nextInt();
                Customer newcustomer = new Customer(id, newname, newpswd, age);
                customerRepository.savecustomerinfo(newcustomer);
                return customerRepository.getcustomerinfo(newname);
            }
            else {
                System.out.println("Thankyou!!");
            }
        }
        if(pswd.equals(customer.getPassword())){
            System.out.println("successful login");
            return customer;
        }
        else {
            System.out.println("Incorrect pswd,try again");
        }
        return null;
    }

    public void booktaxi(Customer customer){
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter pickup point : A,B,C,D,R,F,F,G,H");
        char customerpickuppoint= scn.next().charAt(0);
        System.out.println("Enter drop point :  A,B,C,D,R,F,F,G,H");
        char customerdropoint=scn.next().charAt(0);
        List<CabDriver> cabDriverList=  cabDriverRepository.getallcabdriver();
        for(CabDriver c:cabDriverList){
            System.out.print("CabId:" + c.getId());
            System.out.println(" Cablocation:" + c.getLocation());
        }
        int min_distance=Integer.MAX_VALUE;
        CabDriver cabDriver = null;
        for(CabDriver c:cabDriverList){
            int distance=Math.abs(customerpickuppoint-c.getLocation());
            if((c.getTripStatus()==TripStatus.Available) && distance<=min_distance){
                min_distance=distance;
                cabDriver=c;
            }
            if(c.getTripStatus()==TripStatus.Not_Available){
                c.setTripStatus(TripStatus.Available);
            }
        }
        if(cabDriver!=null) {
            System.out.println("cab is available the below location with cab Id and fare for your ride: ");
            System.out.print("Cabname:" + cabDriver.getName());
            System.out.println(" cablocation:" + cabDriver.getLocation());
            Location location= locationRepository.getlocationinfo(customerdropoint);
            Location location1= locationRepository.getlocationinfo(customerpickuppoint);
            int totalfare=Math.abs((location1.getDistnace()  -location.getDistnace()))*10;
            System.out.println("Fare Rs:" + totalfare);
            System.out.println("Enter 1 to book");
            int n=scn.nextInt();

            if(n==1){
                cabDriver.setLocation(customerdropoint);
                cabDriver.setTotaltrips(cabDriver.getTotaltrips()+1);
                cabDriver.setTripStatus(TripStatus.Not_Available);
                cabDriver.setZulacommsion(cabDriver.getZulacommsion()+
                        (totalfare*0.3));
                cabDriver.setTotalearning(cabDriver.getTotalearning()+totalfare);

                List<TripDetails> tripDetailsList=cabDriver.getTripDetails();
                tripDetailsList.add(new TripDetails(customerpickuppoint,
                        customerdropoint,customer.getId(),(totalfare*0.3),totalfare,cabDriver.getId()));
                cabDriver.setTripDetails(tripDetailsList);

                List<TripDetails> tripDetailsList1=customer.getTripDetails();
                tripDetailsList1.add(new TripDetails(customerpickuppoint,
                        customerdropoint,customer.getId(),(totalfare*0.3),totalfare,cabDriver.getId()));
                customer.setTripDetails(tripDetailsList1);

                System.out.println("Booked successfully");
            }
        }
    }
    public void RideSummary(){
        List<CabDriver> cabDriverList=  cabDriverRepository.getallcabdriver();
        for(CabDriver c:cabDriverList){
            System.out.println("CabId: " + c.getId());
            System.out.println("Cabname: " + c.getName());
            List<TripDetails> tripDetailsList= c.getTripDetails();
            for(TripDetails t:tripDetailsList){
                System.out.print("Source: " + t.getSource());
                System.out.print(" destination: " + t.getDestinatoin());
                System.out.print(" Customer Detail: " + t.getCustomerId());
                System.out.print(" Zulacommision: " + t.getZulacommisionpertrip());
                System.out.println(" FareperRide: " + t.getFare());
            }
            System.out.println();
        }
    }

    public void CustomerRidesummary(){
        List<Customer> customers= customerRepository.getallcustomer();
        for(Customer c:customers){
            System.out.println("CustomerId: " + c.getId());
            System.out.println("Customername: " + c.getName());
            List<TripDetails> tripDetailsList= c.getTripDetails();
            for(TripDetails t:tripDetailsList){
                System.out.print("Source: " + t.getSource());
                System.out.print(" destination: " + t.getDestinatoin());
                System.out.print(" Cab Detail: " + t.getCabdriverId());

                System.out.println(" FareperRide: " + t.getFare());
            }
            System.out.println();
        }
    }
}
