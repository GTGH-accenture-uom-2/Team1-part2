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

    @PostMapping
    public List<Doctor> createDoctor(@RequestBody Doctor doctor) {
        return doctorService.createDoctor(doctor);
    }

    @GetMapping("/amka")
    public Doctor getDoctorByAmka(@RequestParam String amka) {
        return doctorService.getDoctorByAmka(amka);
    }


    @GetMapping("/all")
    public List<Doctor> getAllDoctors() {
        return doctorService.getAllDoctors();
    }


    @DeleteMapping
    public List<Doctor> deleteDoctor(@RequestParam String amka) {
        return doctorService.deleteDoctor(amka);
    }

    @GetMapping("/allreservations")
    public List<Reservation> getDoctorReservations(@RequestParam(required = true) String amka) {
        return reservationService.getAllDoctorsReservations(amka);
    }

    @GetMapping("/dayreservations")
    public List<Reservation> getAllDoctorsReservationsByDay(@RequestParam String amka, @RequestParam LocalDate date) {
        return reservationService.getAllDoctorsReservationsByDay(amka, date);
    }

    @GetMapping("/pagination")
    public List<Reservation> getAllDoctorsReservationsByDay(
            @RequestParam String amka,
            @RequestParam LocalDate date,
            @RequestParam(defaultValue = "0") int pageNumber,
            @RequestParam(defaultValue = "10") int pageSize) {

        return reservationService.getAllDoctorsReservationsPagination(amka, date, pageNumber, pageSize);
    }



//    @PutMapping
//    public Doctor updateDoctor(@RequestParam String amka,
//                               @RequestParam(required = false) String name,
//                               @RequestParam(required = false) String surname,
//                               @RequestParam(required = false) LocalDate birthday,
//                               @RequestParam(required = false) String email){
//
//        return doctorServices.updateDoctor(amka, name, surname, birthday, email);
//    }

//    @DeleteMapping
//    public List<Doctor> deleteDoctor(@RequestParam String amka){
//        return doctorServices.deleteDoctor(amka);
//    }
}
