/* Class: Vaccination Center */
package com.team1.VaccinationProject.models;
import java.util.ArrayList;

public class VaccinationCenter {
    private String code;
    private String address;  // Corrected instance variable name
    private ArrayList<TimeslotDTO> timeslots;

    // Constructor
    public VaccinationCenter(String code, String address, ArrayList<TimeslotDTO> timeslots) {
        this.code = code;
        this.address = address;
        this.timeslots = timeslots;
    }

    // Constructor without timeslots
    public VaccinationCenter(String code, String address) {
        this.code = code;
        this.address = address;
        this.timeslots = new ArrayList<>();
    }

    //Empty constructor
    public VaccinationCenter(){}

    //Add/assign timeslots
    public void addTimeslot(TimeslotDTO timeslotDTO){
        timeslotDTO.setVaccinationCenterCode(this.code);
        timeslots.add(timeslotDTO);
    }

    // Getter methods
    public String getCode() {
        return code;
    }

    public String getAddress() {
        return address;
    }

    public ArrayList<TimeslotDTO> getTimeslots() {
        return timeslots;
    }

    // Setter methods
    public void setCode(String code) {
        this.code = code;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setTimeslots(ArrayList<TimeslotDTO> timeslots) {
        this.timeslots = timeslots;
    }


}
