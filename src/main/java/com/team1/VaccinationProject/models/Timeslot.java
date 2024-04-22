/* Class: Timeslot */
package com.team1.VaccinationProject.models;
import java.time.LocalDate;

public class Timeslot {
    private LocalDate date;
    private int hour;
    private int minutes;
    private String startMinute;
    private String endMinute;
    private Doctor doctor;
    private Boolean hasReservation = false;

    public Timeslot(){}

    public Timeslot(LocalDate date, /*int hour,*/
                   /* int minutes,*/ String startMinute, String endMinute, Doctor doctor, Boolean hasReservation){
        this.date = date;
//        this.hour = hour;
//        this.minutes = minutes;
        this.startMinute = startMinute;
        this.endMinute = endMinute;
        this.doctor = doctor;
        this.hasReservation = hasReservation;
    }


    //Method to assign a doctor to this timeslot
    public void assignDoctor(Doctor dr){this.doctor = dr;}


    // Getters and setters

    public LocalDate getDate() {
        /* check Date validation - not NULL */
        if (date == null) {
            throw new IllegalStateException("The date cannot be null");
        }
        return date;
    }

    public void setDate(LocalDate date) {this.date = date;}


    public String getStartMinute() {return startMinute;}

    public void setStartMinute(String startMinute) {this.startMinute = startMinute;}

    public String getEndMinute() {return endMinute;}

    public void setEndMinute(String endMinute) {this.endMinute = endMinute;}

    public Doctor getDoctor() {return doctor;}

    public void setDoctor(Doctor doctor) {this.doctor = doctor;}

    public Boolean getHasReservation() {return hasReservation;}

    public void setHasReservation(Boolean hasReservation) {this.hasReservation = hasReservation;}

}