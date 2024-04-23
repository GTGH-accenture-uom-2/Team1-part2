package com.team1.VaccinationProject.services;

import com.team1.VaccinationProject.models.Doctor;
import com.team1.VaccinationProject.models.Insured;
import com.team1.VaccinationProject.models.Timeslot;
import com.team1.VaccinationProject.models.Vaccination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class VaccinationServices {
    @Autowired
    InsuredServices insuredServices;
    @Autowired
    TimeslotServices timeslotServices;
    List<Vaccination> vaccinationList = new ArrayList<>();

//    public List<Vaccination> createVaccination(Vaccination vaccination) {
//        vaccinationList.add(vaccination);
//        return vaccinationList;
//    }

    public Vaccination createVaccinationByDoctor(LocalDate date, String startMinute, String amka, LocalDate expirationDate) {

        Insured insured_person = insuredServices.getInsuredByAmka(amka);

        if (insured_person == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Insured does not exist");
        }

        Timeslot timeslot = timeslotServices.getTimeslotByDateHour(date, startMinute);
        if (timeslot == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Timeslot does not exist");
        }

        Vaccination vaccination = new Vaccination(insured_person, timeslot.getDoctor(),
                timeslot.getDate(), expirationDate); //LocalDate.now(): gives the date that you run
        vaccination.setDoctor(timeslot.getDoctor()); //assign Doctor with a timeslot
        vaccinationList.add(vaccination);
        return vaccination;
    }


    public Vaccination getVaccinationByDate(LocalDate date) {
        for (Vaccination vaccination : vaccinationList) {
            if (vaccination.getVaccinationDate().isEqual(date)) {
                return vaccination;
            }
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Vaccination does not exist");
    }

    public Vaccination getVaccinationByAmka(String amka) {
        for (Vaccination vaccination : vaccinationList) {
            if (vaccination.getInsured().getAmka().equals(amka)) {
                return vaccination;
            }
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Vaccination does not exist");
    }

    public List<Vaccination> getAllVaccinations() {
        return vaccinationList;
    }

    public Vaccination updateVaccination(LocalDate date, Insured insured, Doctor doctor, LocalDate expirationDate) {
        Vaccination vaccination = getVaccinationByDate(date);
        if (insured != null) vaccination.setInsured(insured);
        if (doctor != null) vaccination.setDoctor(doctor);
        if (expirationDate != null) vaccination.setExpirationDate(expirationDate);
        return vaccination;
    }

    public List<Vaccination> deleteVaccinationByInsuredAmka(String amka) {
        Vaccination vaccination = getVaccinationByAmka(amka);
        vaccinationList.remove(vaccination);
        return vaccinationList;
    }






}