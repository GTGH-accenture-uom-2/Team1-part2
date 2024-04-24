package com.team1.VaccinationProject.services;

import com.team1.VaccinationProject.models.Insured;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class InsuredService {

    List<Insured> insuredList = new ArrayList<>();

    //------------- C.R.U.D. Insured Services -------------

    //Create Insured and add to list of Insured
    public List<Insured> createInsured(Insured insured) {
        insuredList.add(insured);
        return insuredList;
    }

    //Return Insured by amka service
    public Insured getInsuredByAmka(String amka) {
        return insuredList.stream()
                .filter(insured -> insured.getAmka().equals(amka))
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Insured with AMKA: [" + amka + "] does not exist"));
    }

    //Return Insured by afm service
    public Insured getInsuredByAfm(String afm) {
        return insuredList.stream()
                .filter(insured -> insured.getAfm().equals(afm))
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Insured with AFM: [" + afm + "] does not exist"));
    }

    //Return all Insured service
    public List<Insured> getAllInsured() {
        return insuredList;
    }


    //POSSIBLE REMOVE-------------
    //Delete Insured
    public List<Insured> deleteInsured(String amka) {
        Insured insured = getInsuredByAmka(amka);
        insuredList.remove(insured);
        return insuredList;
    }

    //POSSIBLE REMOVE-------------
    //Update Insured
    public Insured updateInsured(String amka, String name, String surname, LocalDate birthday, String email) {
        Insured insured =  getInsuredByAmka(amka);
        if (name != null) insured.setName(name);
        if (surname != null) insured.setSurname(surname);
        if (birthday != null) insured.setBirthday(birthday);
        if (email != null) insured.setEmail(email);
        return insured;
    }



}
