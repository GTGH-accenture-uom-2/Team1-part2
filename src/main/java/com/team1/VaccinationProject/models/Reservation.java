/* Class: Reservation */
package com.team1.VaccinationProject.models;

public class Reservation {
    private Insured insured;
    private TimeslotDTO timeslot;
    private Doctor doctor;
    private String vaccinationCenterCode;


    public Reservation(Insured insured, TimeslotDTO timeslot, Doctor doctor, String vaccinationCenterCode){
        this.insured = insured;
        this.timeslot = timeslot;
        this.doctor = doctor;
        this.vaccinationCenterCode = vaccinationCenterCode;
    }

    //Empty constructor
    public Reservation() {}


    //Getters and Setters
    public Insured getInsured() {
        return insured;
    }

    public void setInsured(Insured insured) {
        this.insured = insured;
    }

    public TimeslotDTO getTimeslot() {return timeslot;}

    public void setTimeslot(TimeslotDTO timeslot) {this.timeslot = timeslot;}

    public Doctor getDoctor() {return doctor;}

    public void setDoctor(Doctor doctor) {this.doctor = doctor;}

    public String getVaccinationCenterCode() {
        return vaccinationCenterCode;
    }

    public void setVaccinationCenterCode(String getVaccinationCenterCode) {
        this.vaccinationCenterCode = getVaccinationCenterCode;
    }
}

