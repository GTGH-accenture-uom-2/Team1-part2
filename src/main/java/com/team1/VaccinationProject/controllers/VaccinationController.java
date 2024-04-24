package com.team1.VaccinationProject.controllers;

import com.team1.VaccinationProject.models.Doctor;
import com.team1.VaccinationProject.models.Insured;
import com.team1.VaccinationProject.models.Vaccination;

import com.team1.VaccinationProject.models.VaccinationStatusDTO;
import com.team1.VaccinationProject.services.VaccinationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.team1.VaccinationProject.services.InsuredService;
import com.team1.VaccinationProject.services.TimeslotService;

import java.time.LocalDate;
import java.util.List;


@RestController
@RequestMapping("/vaccination")
public class VaccinationController {

    @Autowired
    VaccinationService vaccinationService;

    @Autowired
    InsuredService insuredService;

    @Autowired
    TimeslotService timeslotService;


    //------------- C.R.U.D. Vaccination Controller -------------
//    @PostMapping
//    public List<Vaccination> createVaccination(@RequestBody Vaccination vaccination) {
//        return vaccinationServices.createVaccination(vaccination);
//    }

    @PostMapping
    public Vaccination createVaccination(@RequestParam(required = true) LocalDate date,
                                         @RequestParam(required = true) String startMinute,
                                         @RequestParam(required = true) String amka,
                                         @RequestParam(required = true) LocalDate expirationDate){

        return vaccinationService.createVaccinationByDoctor(date, startMinute, amka, expirationDate);
    }

    @GetMapping("/date")
    public Vaccination getVaccinationByDate(@RequestParam LocalDate date) {
        return vaccinationService.getVaccinationByDate(date);
    }

    @GetMapping("/amka")
    public Vaccination getVaccinationByAmka(@RequestParam String amka) {
        return vaccinationService.getVaccinationByAmka(amka);
    }

    @GetMapping("/all")
    public List<Vaccination> getAllVaccinations() {
        return vaccinationService.getAllVaccinations();
    }

    @PutMapping
    public Vaccination updateVaccination(@RequestParam LocalDate date,
                                         @RequestParam(required = false) Insured insured,
                                         @RequestParam(required = false) Doctor doctor,
                                         @RequestParam(required = false) LocalDate expirationDate){
        return vaccinationService.updateVaccination(date, insured, doctor, expirationDate);
    }

    @DeleteMapping
    public List<Vaccination> deleteVaccinationByInsuredAmka(@RequestParam String amka){
        return vaccinationService.deleteVaccinationByInsuredAmka(amka);
    }



    @GetMapping("/status")
    public VaccinationStatusDTO checkVaccinationStatusByAmka(@RequestParam String amka){
        return vaccinationService.checkVaccinationStatusByAmka(amka);
    }

}

