package com.team1.VaccinationProject.controllers;
import com.team1.VaccinationProject.models.Doctor;

import com.team1.VaccinationProject.models.Reservation;
import com.team1.VaccinationProject.services.DoctorService;
import com.team1.VaccinationProject.services.ReservationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    DoctorService doctorService;

    @Autowired
    ReservationService reservationService;

    //------------- C.R.U.D. Doctor Controller -------------

    //Create a new Doctor
    @PostMapping
    public List<Doctor> createDoctor(@RequestBody Doctor doctor) {
        return doctorService.createDoctor(doctor);
    }

    //Get Doctor by amka
    @GetMapping("/amka")
    public Doctor getDoctorByAmka(@RequestParam String amka) {
        return doctorService.getDoctorByAmka(amka);
    }

    //Get all Doctors
    @GetMapping("/all")
    public List<Doctor> getAllDoctors() {
        return doctorService.getAllDoctors();
    }

    //POSSIBLE REMOVE-----------
    //Update doctor
    @PutMapping
    public Doctor updateDoctor(@RequestParam String amka,
                               @RequestParam(required = false) String name,
                               @RequestParam(required = false) String surname){
        return doctorService.updateDoctor(amka, name, surname);
    }

    //POSSIBLE REMOVE-----------
    //Delete doctor
    @DeleteMapping
    public List<Doctor> deleteDoctor(@RequestParam String amka){
        return doctorService.deleteDoctor(amka);
    }



}
