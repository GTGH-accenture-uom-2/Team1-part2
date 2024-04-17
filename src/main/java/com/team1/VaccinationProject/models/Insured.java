package com.team1.VaccinationProject.models;

/* Κλάση: για τον ασφαλισμένο πολίτη ή γιατρό */
/* Διατηρεί ορισμένα κοινά πεδία με την κλάση 'Doctor', γι'αυτό και ορίζουμε την παρούσα κλάση ως Γονική/Υπερ-κλάση
* και ως υποκλάση την 'Doctor', η οποία θα κληρονομεί τα κοινά στοιχεία απο την Υπερκλάση. */
import java.time.LocalDate;

public class Insured {

    private String afm;
    private String amka; //or Long?
    private String name;
    private String surname;
    private LocalDate birthday;
    private String email;

    //Constructor no. 1
    public Insured(String afm, String amka, String name, String surname, LocalDate birthday, String email) {
        this.afm = afm;
        this.amka = amka;
        this.name = name;
        this.surname = surname;
        this.birthday = birthday;
        this.email = email;
    }

    //2. Constructor no. 2(overload - use for testing in main class)
    public Insured(String name, LocalDate birthday){
        this.name = name;
        this.birthday = birthday;
    }

    //Setter and Getter
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
}
