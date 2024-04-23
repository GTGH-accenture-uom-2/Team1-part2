package com.team1.VaccinationProject.controllers;


import com.team1.VaccinationProject.models.Doctor;
import com.team1.VaccinationProject.services.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    DoctorService doctorService;


    //------------- C.R.U.D. Doctor Controller -------------

    @PostMapping
    public List<Doctor> createDoctor(@RequestBody Doctor doctor) {
        return doctorService.createDoctor(doctor);
    }

    @GetMapping("/amka")
    public Doctor getDoctorByAmka(@RequestParam String amka) {
        return doctorService.getDoctorByAmka(amka);
    }

    @GetMapping("/afm")
    public Doctor getDoctorByAfm(@RequestParam String afm) {
        return doctorService.getDoctorByAfm(afm);
    }

    @GetMapping("/all")
    public List<Doctor> getAllDoctors() {
        return doctorService.getAllDoctors();
    }

    @PutMapping
    public Doctor updateDoctor(@RequestParam String amka,
                               @RequestParam(required = false) String name,
                               @RequestParam(required = false) String surname,
                               @RequestParam(required = false) LocalDate birthday,
                               @RequestParam(required = false) String email){

        return doctorService.updateDoctor(amka, name, surname, birthday, email);
    }

    @DeleteMapping
    public List<Doctor> deleteDoctor(@RequestParam String amka){
        return doctorService.deleteDoctor(amka);
    }
}
