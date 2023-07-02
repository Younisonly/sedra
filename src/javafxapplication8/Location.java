package javafxapplication8;

import java.util.ArrayList;
import java.util.List;

import java.util.ArrayList;
import java.util.List;

import java.util.ArrayList;
import java.util.List;

public class Location {
    private String name;
    private double latitude;
    private double longitude;
    private List<Martyr> martyrs;

    public Location(String name) {
        this.name = name;
        this.martyrs = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public void addMartyr(Martyr martyr) {
        martyrs.add(martyr);
    }

    public void removeMartyr(Martyr martyr) {
        martyrs.remove(martyr);
    }

    public List<Martyr> getMartyrs() {
        return martyrs;
    }

    public void setMartyrs(List<Martyr> martyrs) {
        this.martyrs = martyrs;
    }

    @Override
    public String toString() {
        return "Location{" +
                "name='" + name + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", martyrs=" + martyrs +
                '}';
    }
}