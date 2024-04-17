package com.team1.VaccinationProject.services;

import com.team1.VaccinationProject.models.Insured;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class InsuredServices {

    List<Insured> insuredList = new ArrayList<>();


    //------------- C.R.U.D. Insured Services -------------

    public List<Insured> createInsured(Insured insured) {
        insuredList.add(insured);
        return insuredList;
    }

    public Insured getInsuredByAmka(String amka) {
        for (Insured insured : insuredList) {
            if (insured.getAmka().equals(amka)) {
                return insured;
            }
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Insured does not exist");
    }

    public Insured getInsuredByAfm(String afm) {
        for (Insured insured : insuredList) {
            if (insured.getAmka().equals(afm)) {
                return insured;
            }
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Insured does not exist");
    }

    public List<Insured> getAllInsured() {
        return insuredList;
    }

    public Insured updateInsured(String amka, String name, String surname, LocalDate birthday, String email) {
        Insured insured =  getInsuredByAmka(amka);
        if (name != null) insured.setName(name);
        if (surname != null) insured.setSurname(surname);
        if (birthday != null) insured.setBirthday(birthday);
        if (email != null) insured.setEmail(email);
        return insured;
    }

    public List<Insured> deleteInsured(String amka) {
        Insured insured = getInsuredByAmka(amka);
        insuredList.remove(insured);
        return insuredList;
    }
}
