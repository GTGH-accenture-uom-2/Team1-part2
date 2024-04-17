package com.team1.VaccinationProject.models;

/* Κλάση: Για το εμβολιαστικό κέντρο  */

import java.util.ArrayList;

public class VaccinationCenter {
    private String code;
    private String address;
    private ArrayList<Timeslot> timeslots;

    public VaccinationCenter(String code, String address, ArrayList<Timeslot> timeslots) {
        this.code = code;
        this.address = address;
        this.timeslots = timeslots;
    }

    //Setters and Getters
    public String getCode() {
        return code;
    }

    public String getAddress() {
        return address;
    }

    public ArrayList<Timeslot> getTimeslots() {
        return timeslots;
    }

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
