package dates;

import java.time.ZoneId;
import java.util.Set;


public class Dates {

    
    public static void main(String[] args) {
        Set<String> allZonesIds = ZoneId.getAvailableZoneIds(); 
        allZonesIds.forEach(System.out::println);
    }
    
}
