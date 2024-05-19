package Repository;

import Models.CabDriver;
import Models.Customer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CabDriverRepository {

    private final HashMap<String, CabDriver> cabDriverHashMap= new HashMap<>();

    public void savedriverinfo(CabDriver cabDriver){
        String name=cabDriver.getName();
        if(!cabDriverHashMap.containsKey(name)){
            cabDriverHashMap.put(name,cabDriver);
        }
    }
    public CabDriver getdriverinfo(String name){
        if(cabDriverHashMap.containsKey(name)){
            return cabDriverHashMap.get(name);
        }
        else {
            System.out.print("No driver name exists");
            return null;
        }
    }
    public  List<CabDriver> getallcabdriver(){
        List<CabDriver> cabDrivers= new ArrayList<>(cabDriverHashMap.values());
        return cabDrivers;
    }
}
