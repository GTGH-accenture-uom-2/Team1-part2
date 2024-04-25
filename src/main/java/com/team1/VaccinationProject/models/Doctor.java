package com.team1.VaccinationProject.models;

import java.util.ArrayList;
import java.util.List;

public class Doctor{
    private String amka;
    private String name;
    private String surname;
    private List<TimeslotDTO> timeslots;
    private List<Vaccination> vaccinations;

    public Doctor(String amka, String name, String surname, List<TimeslotDTO> timeslots, List<Vaccination> vaccinations) {
        this.amka = amka;
        this.name = name;
        this.surname = surname;
        this.timeslots = timeslots;
        this.vaccinations = vaccinations;
    }

    //Constructor without preset arrays
    public Doctor(String amka, String name, String surname) {
        this.amka = amka;
        this.name = name;
        this.surname = surname;
        this.timeslots = new ArrayList<TimeslotDTO>();
    }

    //Empty constructor
    public Doctor(){}


    //Method to add/assign new timeslots to a doctor
    public void addTimeslot(TimeslotDTO timeslotDTO){
        timeslotDTO.setDoctorAmka(this.amka);
        timeslots.add(timeslotDTO);
    }


    //Getter and Setter

    public String getAmka() {return amka;}

    public void setAmka(String amka) {this.amka = amka;}

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public String getSurname() {return surname;}

    public void setSurname(String surname) {this.surname = surname;}

    public List<TimeslotDTO> getTimeslots() {
        return timeslots;
    }

    public void setTimeslots(List<TimeslotDTO> timeslots) {
        this.timeslots = timeslots;
    }

}
