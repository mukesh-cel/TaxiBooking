package Repository;

import Models.CabDriver;
import Models.Location;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LocationRepository {
    private final HashMap<Character, Location> locationHashMap = new HashMap<>();
    public void savelocationinfo(Location location){
        Character name=location.getName();
        if(!locationHashMap.containsKey(name)){
            locationHashMap.put(name,location);
        }
    }
    public Location getlocationinfo(Character name){
        if(locationHashMap.containsKey(name)){
            return locationHashMap.get(name);
        }
        else {
            System.out.print("No location name exists");
            return null;
        }
    }
    public List<Location> getalllocationinfo(){
        List<Location> locations= new ArrayList<>(locationHashMap.values());
        return locations;
    }
}
