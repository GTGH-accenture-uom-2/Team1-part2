package com.team1.VaccinationProject.services;

import com.team1.VaccinationProject.models.Doctor;
import com.team1.VaccinationProject.models.Insured;
import com.team1.VaccinationProject.models.Vaccination;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class VaccinationServices {

    List<Vaccination> vaccinationList = new ArrayList<>();

    public List<Vaccination> createVaccination(Vaccination vaccination) {
        vaccinationList.add(vaccination);
        return vaccinationList;
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