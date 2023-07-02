/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication8;

import java.util.ArrayList;
import java.util.List;

public class LocationList {
    private static LocationList instance = null;
    private List<Location> locations;

    private LocationList() {
        locations = new ArrayList<>();
    }

    public static LocationList getInstance() {
        if (instance == null) {
            instance = new LocationList();
        }
        return instance;
    }

    public void addLocation(Location location) {
        locations.add(location);
    }

    public List<Location> getLocations() {
        return locations;
    }
}