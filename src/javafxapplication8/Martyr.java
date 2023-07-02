/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication8;

import java.time.LocalDate;
import java.time.LocalDate;

public class Martyr {
    private String name;
    private int age;
    private String eventLocation;
    private String district;
    private LocalDate dateOfDeath;
    private Gender gender;

    public Martyr(String name, int age, String eventLocation, String district, LocalDate dateOfDeath, Gender gender) {
        this.name = name;
        this.age = age;
        this.eventLocation = eventLocation;
        this.district = district;
        this.dateOfDeath = dateOfDeath;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEventLocation() {
        return eventLocation;
    }

    public void setEventLocation(String eventLocation) {
        this.eventLocation = eventLocation;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public LocalDate getDateOfDeath() {
        return dateOfDeath;
    }

    public void setDateOfDeath(LocalDate dateOfDeath) {
        this.dateOfDeath = dateOfDeath;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Martyr{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", eventLocation='" + eventLocation + '\'' +
                ", district='" + district + '\'' +
                ", dateOfDeath=" + dateOfDeath +
                ", gender=" + gender +
                '}';
    }
}