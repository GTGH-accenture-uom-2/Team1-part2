package com.team1.VaccinationProject.controllers;


import com.team1.VaccinationProject.models.Doctor;
import com.team1.VaccinationProject.models.Reservation;
import com.team1.VaccinationProject.services.DoctorServices;
import com.team1.VaccinationProject.services.ReservationServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.SecureRandom;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    DoctorServices doctorServices;

    @Autowired
    ReservationServices reservationServices;

    //------------- C.R.U.D. Doctor Controller -------------

    @PostMapping
    public List<Doctor> createDoctor(@RequestBody Doctor doctor) {
        return doctorServices.createDoctor(doctor);
    }

    @GetMapping("/amka")
    public Doctor getDoctorByAmka(@RequestParam String amka) {
        return doctorServices.getDoctorByAmka(amka);
    }

    @GetMapping("/afm")
    public Doctor getDoctorByAfm(@RequestParam String afm) {
        return doctorServices.getDoctorByAfm(afm);
    }

    @GetMapping("/all")
    public List<Doctor> getAllDoctors() {
        return doctorServices.getAllDoctors();
    }

    @PutMapping
    public Doctor updateDoctor(@RequestParam String amka,
                               @RequestParam(required = false) String name,
                               @RequestParam(required = false) String surname,
                               @RequestParam(required = false) LocalDate birthday,
                               @RequestParam(required = false) String email){

        return doctorServices.updateDoctor(amka, name, surname, birthday, email);
    }

    @DeleteMapping
    public List<Doctor> deleteDoctor(@RequestParam String amka){
        return doctorServices.deleteDoctor(amka);
    }

//    @GetMapping("/reservations")
//    public Doctor getDoctorReservations(@RequestParam Long id, @RequestParam Reservation reservationList){
//        return doctorServices.getDoctorReservations(id, reservationList);
//    }

    @GetMapping("/allreservations")
    public List<Reservation> getDoctorReservations(@RequestParam (required = true) String amka){
        return reservationServices.getAllDoctorsReservations(amka);
    }

    @GetMapping("/dayreservations")
    public List<Reservation> getAllDoctorsReservationsByDay(@RequestParam String amka, @RequestParam LocalDate date){
        return reservationServices.getAllDoctorsReservationsByDay(amka, date);
    }


}