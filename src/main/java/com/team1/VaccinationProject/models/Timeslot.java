/* Class: Timeslot */

package com.team1.VaccinationProject.models;
import java.time.LocalDate;

public class Timeslot {
    private LocalDate date;
    private int hour;
    private int minutes;
    private int startMinute;
    private int endMinute;
    private Doctor doctor;
    private Boolean hasReservation = false;

    //Constructor No. 1
    public Timeslot(LocalDate date, int hour,
                    int minutes, int startMinute, int endMinute,
                    Doctor doctor){
        this.date = date;
        this.hour = hour;
        this.minutes = minutes;
        this.startMinute = startMinute;
        this.endMinute = endMinute;
        this.doctor = doctor;
    }

    //Constructor No. 2
    public Timeslot(){}

    //Constructor No. 3
    public Timeslot(LocalDate date, int hour, int minutes, int startMinute, int endMinute) {
        this.date = date;
        this.hour = hour;
        this.minutes = minutes;
        this.startMinute = startMinute;
        this.endMinute = endMinute;
    }

    //Method to assign a doctor to this timeslot
    public void assignDoctor(Doctor dr){
        this.doctor = dr;
    }

    // Getters and setters

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public int getStartMinute() {
        return startMinute;
    }

    public void setStartMinute(int startMinute) {
        this.startMinute = startMinute;
    }

    public int getEndMinute() {
        return endMinute;
    }

    public void setEndMinute(int endMinute) {
        this.endMinute = endMinute;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Boolean getHasReservation() {
        return hasReservation;
    }

    public void setHasReservation(Boolean hasReservation) {
        this.hasReservation = hasReservation;
    }

    public String toString() {
        return ("Date: " + date +
                ", Hour: " + hour + ", Minutes: " + minutes + ", " +
                "StartMinute: " + startMinute + ", EndMinute: " + endMinute + "\n");
    }


}