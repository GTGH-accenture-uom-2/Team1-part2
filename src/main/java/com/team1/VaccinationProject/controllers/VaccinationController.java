package com.team1.VaccinationProject.controllers;
import com.team1.VaccinationProject.models.Doctor;
import com.team1.VaccinationProject.models.Insured;
import com.team1.VaccinationProject.models.Timeslot;
import com.team1.VaccinationProject.models.Vaccination;
import com.team1.VaccinationProject.services.InsuredServices;
import com.team1.VaccinationProject.services.TimeslotServices;
import com.team1.VaccinationProject.services.VaccinationServices;
import io.swagger.v3.oas.models.info.License;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.print.Doc;
import java.time.LocalDate;
import java.util.List;


@RestController
@RequestMapping("/vaccination")
public class VaccinationController {

    @Autowired
    VaccinationServices vaccinationServices;
    @Autowired
    InsuredServices insuredServices;

    @Autowired
    TimeslotServices timeslotServices;


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

        return vaccinationServices.createVaccinationByDoctor(date, startMinute, amka, expirationDate);
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

    @PutMapping
    public Vaccination updateVaccination(@RequestParam LocalDate date,
                                         @RequestParam(required = false) Insured insured,
                                         @RequestParam(required = false) Doctor doctor,
                                         @RequestParam(required = false) LocalDate expirationDate){
        return vaccinationServices.updateVaccination(date, insured, doctor, expirationDate);
    }

    @DeleteMapping
    public List<Vaccination> deleteVaccinationByInsuredAmka(@RequestParam String amka){
        return vaccinationServices.deleteVaccinationByInsuredAmka(amka);
    }


}