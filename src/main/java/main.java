import Conotroller.TaxiController;
import Models.CabDriver;
import Models.Customer;
import Models.Location;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        TaxiController taxiController= new TaxiController();
        List<CabDriver> cabDrivers= new ArrayList<>();
        cabDrivers.add(new CabDriver(1,"aaa","111",25,'D',6,0));
        cabDrivers.add(new CabDriver(2,"bbb","222",29,'G',6,0));
        cabDrivers.add(new CabDriver(3,"ccc","222",27,'H',6,0));
        cabDrivers.add(new CabDriver(4,"ddd","222",24,'A',6,0));

        List<Customer> customers= new ArrayList<>();
        customers.add(new Customer(1,"WW","55",25));
        customers.add(new Customer(2,"XX","66",26));
        customers.add(new Customer(3,"YY","77",27));
        customers.add(new Customer(4,"ZZ","88",28));

        List<Location> locations= new ArrayList<>();
        locations.add(new Location(1,'A',0));
        locations.add(new Location(2,'B',15));
        locations.add(new Location(3,'C',4));
        locations.add(new Location(4,'D',7));
        locations.add(new Location(5,'R',23));
        locations.add(new Location(6,'F',9));
        locations.add(new Location(7,'G',18));
        locations.add(new Location(8,'H',20));

        taxiController.IntializeTaxi(locations,customers,cabDrivers);

        Scanner scn = new Scanner(System.in);
        /*System.out.println("Welcome to Zula!!");
        System.out.println("1.Cab driver login");
        System.out.println("2.Customer login.");
        System.out.println("4.quit");
        int n= scn.nextInt();*/
        while(true){
            System.out.println("Welcome to Zula!!");
            System.out.println("1.Cab driver login");
            System.out.println("2.Customer login.");
            System.out.println("6.quit");
            int n= scn.nextInt();
            if(n==1){
                taxiController.cabdriverlogin();
            }
            if(n==2){
                Customer customer=taxiController.customerlogin();
                while(true) {
                    if (customer != null) {
                        System.out.println("3.Book Taxi.");
                        System.out.println("4.Ride Summary.");
                        System.out.println("5.Customer Ride Summary ");
                        System.out.println("6.exit to main menu");
                        int nm = scn.nextInt();
                        if (nm == 3) {
                            taxiController.booktaxi(customer);
                        }
                        if (nm == 4) {
                            taxiController.RideSummary();
                        }
                        if (nm == 5) {
                            taxiController.CustomerRidesummary();
                        }
                        if(nm==6){
                            break;
                        }
                    }
                }
            }
            if(n==4){
                break;
            }
        }
    }
}
