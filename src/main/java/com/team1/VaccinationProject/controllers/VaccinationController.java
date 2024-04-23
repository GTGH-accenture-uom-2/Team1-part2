package com.team1.VaccinationProject.controllers;


import com.team1.VaccinationProject.models.Doctor;
import com.team1.VaccinationProject.models.Insured;
import com.team1.VaccinationProject.models.Vaccination;
import com.team1.VaccinationProject.services.VaccinationServices;
import io.swagger.v3.oas.models.info.License;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.print.Doc;
import java.time.LocalDate;
import java.util.List;


@RestController
@RequestMapping("/vaccination")
public class VaccinationController {

    @Autowired
    VaccinationServices vaccinationServices;


    //------------- C.R.U.D. Vaccination Controller -------------
    @PostMapping
    public List<Vaccination> createVaccination(@RequestBody Vaccination vaccination) {
        return vaccinationServices.createVaccination(vaccination);
    }


    @GetMapping("/date")
    public Vaccination getVaccinationByDate(@RequestParam LocalDate date) {
        return vaccinationServices.getVaccinationByDate(date);
    }

    @GetMapping("/amka")
    public Vaccination getVaccinationByAmka(@RequestParam String amka) {
        return vaccinationServices.getVaccinationByAmka(amka);
    }

    @GetMapping("/all")
    public List<Vaccination> getAllVaccinations() {
        return vaccinationServices.getAllVaccinations();
    }

//    @PutMapping
//    public Vaccination updateVaccination(@RequestParam LocalDate date,
//                                         @RequestParam(required = false) Insured insured,
//                                         @RequestParam(required = false) Doctor doctor,
//                                         @RequestParam(required = false) LocalDate expirationDate){
//        return vaccinationServices.updateVaccination(date, insured, doctor, expirationDate);
//    }
//
//
//    @DeleteMapping
//    public List<Vaccination> deleteVaccinationByInsuredAmka(@RequestParam String amka){
//        return vaccinationServices.deleteVaccinationByInsuredAmka(amka);
//    }


}