package com.team1.VaccinationProject.models;
import java.time.LocalDate;

public class TimeslotDTO {

    private LocalDate date;
    // POSSIBLE REMOVE private int hour;
    // POSSIBLE REMOVE private int minutes;
    private String startMinute;
    private String endMinute;
    private Boolean hasReservation = false;

    String doctorAmka;

    public TimeslotDTO(LocalDate date, String startMinute, String endMinute) {
        this.date = date;
        this.startMinute = startMinute;
        this.endMinute = endMinute;
    }


    public String getDoctorAmka() {
        return doctorAmka;
    }

    public void setDoctorAmka(String doctorAmka) {
        this.doctorAmka = doctorAmka;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getStartMinute() {
        return startMinute;
    }

    public void setStartMinute(String startMinute) {
        this.startMinute = startMinute;
    }

    public String getEndMinute() {
        return endMinute;
    }

    public void setEndMinute(String endMinute) {
        this.endMinute = endMinute;
    }

    public java.lang.Boolean getHasReservation() {
        return hasReservation;
    }

    public void setHasReservation(java.lang.Boolean hasReservation) {
        this.hasReservation = hasReservation;
    }
}
