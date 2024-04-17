package com.team1.VaccinationProject.models;

public class Reservation {
    private Insured insured;
    private Timeslot timeslot;


    public Reservation(Insured insured, Timeslot timeslot){
        this.insured = insured;
        this.timeslot = timeslot;
    }

    //Getters and Setters
    public Insured getInsured() {
        return insured;
    }

    public void setInsured(Insured insured) {
        this.insured = insured;
    }

    public Timeslot getTimeslot() {
        return timeslot;
    }

    public void setTimeslot(Timeslot timeslot) {
        this.timeslot = timeslot;
    }


    //Override toString
    public String toString(){
        return "Insured: " + getInsured().getName() + " Timeslot: " + getTimeslot().toString();
    }
}

