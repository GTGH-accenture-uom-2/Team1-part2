/* Class: Doctor */
package com.team1.VaccinationProject.models;
import java.time.LocalDate;
import java.util.ArrayList;

public class Doctor{
    private String amka;
    private String name;
    private String surname;
    private ArrayList<Timeslot> timeslots;
    private ArrayList<Vaccination> vaccinations=new ArrayList<>();

    public Doctor(String amka, String name, String surname, ArrayList<Timeslot> timeslots) {
        this.amka = amka;
        this.name = name;
        this.surname = surname;
        this.timeslots = timeslots;
    }

    //add this:
    public Doctor(String amka, String name, String surname) {
        this.amka = amka;
        this.name = name;
        this.surname = surname;
    }

    public Doctor() {}




    //Method to add/assign new timeslots to a doctor
    public void addTimeslot(Timeslot timeslot){
        timeslots.add(timeslot);
        timeslot.assignDoctor(this);
    }

    //Method to add/assign new vaccinations to a doctor
    public void addVaccination(Vaccination vaccination){
        vaccinations.add(vaccination);
    }

    //Getter and Setter

    public String getAmka() {return amka;}

    public void setAmka(String amka) {this.amka = amka;}

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public String getSurname() {return surname;}

    public void setSurname(String surname) {this.surname = surname;}

    public ArrayList<Timeslot> getTimeslots() {
        return timeslots;
    }

    public ArrayList<Vaccination> getVaccinations() {
        return vaccinations;
    }

    public void setVaccinations(ArrayList<Vaccination> vaccinations) {
        this.vaccinations = vaccinations;
    }

    public void setTimeslots(ArrayList<Timeslot> timeslots) {
        this.timeslots = timeslots;
    }
}
