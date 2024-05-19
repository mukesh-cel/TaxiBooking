package Repository;

import Models.CabDriver;
import Models.Customer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CustomerRepository {
    private final HashMap<String, Customer> customerHashMap= new HashMap<>();

    public void savecustomerinfo(Customer customer){
        String name=customer.getName();
        if(!customerHashMap.containsKey(name)){
            customerHashMap.put(name,customer);
        }
    }
    public Customer getcustomerinfo(String name){
        if(customerHashMap.containsKey(name)){
            return customerHashMap.get(name);
        }
        else {
            System.out.print("No user name exists, create new user");
            return null;
        }
    }

    public List<Customer> getallcustomer(){
        List<Customer> customerList= new ArrayList<>(customerHashMap.values());
        return customerList;
    }
}
