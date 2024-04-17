package com.team1.VaccinationProject.models;/* Κλάση: Για τη χρονική θυρίδα εμβολιασμού  */

import java.time.LocalDate;

public class Timeslot {
    private LocalDate day;
    private LocalDate month;
    private LocalDate year;
    private int hour;
    private int minutes;
    private int startMinute;
    private int endMinute;
    private Doctor doctor;

    //Constructor No. 1
    public Timeslot(LocalDate day, LocalDate month, LocalDate year, int hour,
                    int minutes, int startMinute, int endMinute,
                    Doctor doctor){
        this.day = day;
        this.month = month;
        this.year = year;
        this.hour = hour;
        this.minutes = minutes;
        this.startMinute = startMinute;
        this.endMinute = endMinute;
        this.doctor = doctor;
    }
    //Constructor No. 2
    public Timeslot(){}

    //Method to assign a doctor to this timeslot
    public void assignDoctor(Doctor dr){
        this.doctor = dr;
    }

    // Getters and setters
    public LocalDate getDay() {
        return day;
    }

    public void setDay(LocalDate day) {
        this.day = day;
    }

    public LocalDate getMonth() {
        return month;
    }
    public void setMonth(LocalDate month) {
        this.month = month;
    }
    public LocalDate getYear() {
        return year;
    }
    public void setYear(LocalDate year) {
        this.year = year;
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

    public String toString() {
        return ("Day: " + day + ", Month: " + month + ", Year: " + year + ", " +
                "Hour: " + hour + ", Minutes: " + minutes + ", " +
                "StartMinute: " + startMinute + ", EndMinute: " + endMinute + "\n");
    }


}

