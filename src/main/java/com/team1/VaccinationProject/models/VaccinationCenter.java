/* Class: Vaccination Center */
package com.team1.VaccinationProject.models;
import java.util.ArrayList;

public class VaccinationCenter {
    private String code;
    private String address;  // Corrected instance variable name
    private ArrayList<Timeslot> timeslots;

    // Constructor
    public VaccinationCenter(String code, String address, ArrayList<Timeslot> timeslots) {
        this.code = code;
        this.address = address;
        this.timeslots = timeslots;
    }

    // Getter methods
    public String getCode() {
        return code;
    }

    public String getAddress() {
        return address;
    }

    public ArrayList<Timeslot> getTimeslots() {
        return timeslots;
    }

    // Setter methods
    public void setCode(String code) {
        this.code = code;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setTimeslots(ArrayList<Timeslot> timeslots) {
        this.timeslots = timeslots;
    }


}
