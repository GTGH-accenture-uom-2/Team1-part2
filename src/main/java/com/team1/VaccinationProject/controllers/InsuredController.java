package com.team1.VaccinationProject.controllers;


import com.team1.VaccinationProject.models.Insured;
import com.team1.VaccinationProject.services.InsuredServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/insured")
public class InsuredController {

    @Autowired
    InsuredServices insuredServices;


    //------------- C.R.U.D. Insured Controller -------------

    @PostMapping
    public List<Insured> createInsured(@RequestBody Insured insured) {
        return insuredServices.createInsured(insured);
    }

    @GetMapping("/amka")
    public Insured getInsuredByAmka(@RequestParam String amka) {
        return insuredServices.getInsuredByAmka(amka);
    }

    @GetMapping("/afm")
    public Insured getInsuredByAfm(@RequestParam String afm) {
        return insuredServices.getInsuredByAfm(afm);
    }

    @GetMapping("/all")
    public List<Insured> getAllInsured() {
        return insuredServices.getAllInsured();
    }

    @PutMapping
    public Insured updateInsured(@RequestParam String amka,
                                 @RequestParam(required = false) String name,
                                 @RequestParam(required = false) String surname,
                                 @RequestParam(required = false) LocalDate birthday,
                                 @RequestParam(required = false) String email){

        return insuredServices.updateInsured(amka, name, surname, birthday, email);
    }

    @DeleteMapping
    public List<Insured> deleteInsured(@RequestParam String amka){
        return insuredServices.deleteInsured(amka);
    }

}