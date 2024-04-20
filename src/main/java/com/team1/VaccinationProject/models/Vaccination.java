package com.team1.VaccinationProject.models;


/* Class: Vaccination */

import java.time.LocalDate;

public class Vaccination {

    private Insured insured;
    private Doctor doctor;
    private LocalDate vaccinationDate;
    private LocalDate expirationDate;

    //Constructor
    public Vaccination(Insured insured, Doctor doctor, LocalDate vaccinationDate, LocalDate expirationDate){
        this.insured = insured;
        this.doctor = doctor;
        this.vaccinationDate = vaccinationDate;
        this.expirationDate = expirationDate;
    }

    //Method to assign a doctor to this vaccination
    public void assignDoctor(Doctor dr){
        this.doctor = dr;
    }

    //Getters and setters
    public Insured getInsured() {return insured;}

    public void setInsured(Insured insured) {this.insured = insured;}

    public Doctor getDoctor() {return doctor;}

    public void setDoctor(Doctor doctor) {this.doctor = doctor;}

    public LocalDate getVaccinationDate() {return vaccinationDate;}

    public void setVaccinationDate(LocalDate vaccinationDate) {this.vaccinationDate = vaccinationDate;}

    public LocalDate getExpirationDate() {return expirationDate;}

    public void setExpirationDate(LocalDate expirationDate) {this.expirationDate = expirationDate;}

    @Override
    public String toString() {
        return "Vaccination{" +
                "vaccinationDate=" + vaccinationDate +
                ", insured=" + insured.getName() +
                '}';
    }
}
