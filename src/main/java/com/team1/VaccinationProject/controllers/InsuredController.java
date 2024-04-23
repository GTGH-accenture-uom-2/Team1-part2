package com.team1.VaccinationProject.controllers;

import com.team1.VaccinationProject.models.Insured;
import com.team1.VaccinationProject.services.InsuredService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/insured")
public class InsuredController {

    @Autowired
    InsuredService insuredService;

    //------------- C.R.U.D. Insured Controller -------------

    @PostMapping
    public List<Insured> createInsured(@RequestBody Insured insured) {
        return insuredService.createInsured(insured);
    }

    @GetMapping("/amka")
    public Insured getInsuredByAmka(@RequestParam String amka) {
        return insuredService.getInsuredByAmka(amka);
    }

    @GetMapping("/afm")
    public Insured getInsuredByAfm(@RequestParam String afm) {
        return insuredService.getInsuredByAfm(afm);
    }

    @GetMapping("/all")
    public List<Insured> getAllInsured() {
        return insuredService.getAllInsured();
    }

    @PutMapping
    public Insured updateInsured(@RequestParam String amka,
                                 @RequestParam(required = false) String name,
                                 @RequestParam(required = false) String surname,
                                 @RequestParam(required = false) LocalDate birthday,
                                 @RequestParam(required = false) String email){

        return insuredService.updateInsured(amka, name, surname, birthday, email);
    }

    @DeleteMapping
    public List<Insured> deleteInsured(@RequestParam String amka){
        return insuredService.deleteInsured(amka);
    }

}