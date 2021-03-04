package TTPP;

import java.util.*;

public class TravelPlan {
    City city;
    /**
     * A list describing the order of preferences for the
     */
    Integer[] preferences;

    public TravelPlan(City city) {
        this.city = city;
        preferences = new Integer[city.locations.size()];
    }

    public void addPreference(Location location, Integer preference) {
        for (Integer i : preferences) {
            if (this.city.getLocationAtIndex(i) == location) {
                this.preferences[i] = preference;
            }
        }
    }

    public Integer getShortestPathBetween(Location l1, Location l2) {
        boolean exists1 = false, exists2 = false;
        for (Location temp : city.locations) {
            if (l1 == temp) exists1 = true;
            if (l2 == temp) exists2 = true;
        }
        if (!exists1 || !exists2) return -1;

        Integer[][] distanceMatrix = new Integer[city.locations.size()][city.locations.size()];

    }
}
