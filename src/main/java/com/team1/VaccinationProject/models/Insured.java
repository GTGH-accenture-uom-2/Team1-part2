/* Class: for Insured citizen or Doctor */
package com.team1.VaccinationProject.models;
import java.time.LocalDate;

public class Insured {

    private String afm;
    private String amka;
    private String name;
    private String surname;
    private LocalDate birthday;
    private String email;
    private int updateCounter = 0;
    //private Boolean hasReservation;  //boolean variable to show if a citizen has a reservation for vaccination

    //Constructor no. 1
    public Insured(String afm, String amka, String name, String surname, LocalDate birthday, String email) {
        this.afm = afm;
        this.amka = amka;
        this.name = name;
        this.surname = surname;
        this.birthday = birthday;
        this.email = email;
    }

    //Getters and Setters
    public String getAfm() {
        return afm;
    }

    public void setAfm(String afm) {
        this.afm = afm;
    }

    public String getAmka() {
        return amka;
    }

    public void setAmka(String amka) {
        this.amka = amka;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getUpdateCounter() {
        return updateCounter;
    }

    public void setUpdateCounter(int updateCounter) {
        this.updateCounter = updateCounter;
    }
}
