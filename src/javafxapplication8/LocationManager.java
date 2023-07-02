/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication8;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class LocationManager {
    private List<Location> locations;

    public LocationManager() {
        this.locations = new ArrayList<>();
    }

    public void loadLocationsFromCsv(File csvFile) {
        // Load locations and martyrs from csv file
        // ...

        // Create location objects and add martyrs to them
        // ...
    }

    public void addLocation(Location location) {
        locations.add(location);
    }

    public void updateLocation(Location location, String newName) {
        // Update an existing location in the list
        location.setName(newName);
    }

    public Location searchLocation(String name) {
        // Search for a location by name
        for (Location location : locations) {
            if (location.getName().equalsIgnoreCase(name)) {
                return location;
            }
        }
        return null;
    }

    public List<Location> getLocations() {
        return locations;
    }

    public void setLocations(List<Location> locations) {
        this.locations = locations;
    }

    @Override
    public String toString() {
        return "LocationManager{" +
                "locations=" + locations +
                '}';
    }
}