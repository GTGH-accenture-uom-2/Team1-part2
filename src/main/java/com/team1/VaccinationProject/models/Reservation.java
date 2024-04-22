/* Class: Reservation */
package com.team1.VaccinationProject.models;

public class Reservation {
    private Insured insured;
    private Timeslot timeslot;
//maybe, we need to add:
    private Doctor doctor;


    public Reservation() {}

    public Reservation(Insured insured, Timeslot timeslot, Doctor doctor){
        this.insured = insured;
        this.timeslot = timeslot;
        this.doctor = doctor;
    }

    //Getters and Setters
    public Insured getInsured() {
        return insured;
    }

    public void setInsured(Insured insured) {
        this.insured = insured;
    }

    public Timeslot getTimeslot() {return timeslot;}

    public void setTimeslot(Timeslot timeslot) {this.timeslot = timeslot;}

    public Doctor getDoctor() {return doctor;}

    public void setDoctor(Doctor doctor) {this.doctor = doctor;}

}

