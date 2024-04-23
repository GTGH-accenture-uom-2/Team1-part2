package com.team1.VaccinationProject.controllers;
import com.team1.VaccinationProject.models.Doctor;
import com.team1.VaccinationProject.models.Insured;
import com.team1.VaccinationProject.models.Reservation;
import com.team1.VaccinationProject.models.Timeslot;
import com.team1.VaccinationProject.services.DoctorServices;
import com.team1.VaccinationProject.services.InsuredServices;
import com.team1.VaccinationProject.services.ReservationServices;
import com.team1.VaccinationProject.services.TimeslotServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Time;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/reservation")
public class ReservationController {

    @Autowired
    ReservationServices reservationServices;
    //also, need access to the following Services:
    @Autowired
    InsuredServices insuredServices;
    @Autowired
    TimeslotServices timeslotServices;
    @Autowired
    DoctorServices doctorServices;

    //------------- C.R.U.D. Reservation Controller -------------

    //1. firstly, let's create Reservations (empty items)
    @PostMapping
    public Reservation createReservation(@RequestParam(required = true) String amka,
                                         @RequestParam(required = true) LocalDate date,
                                         @RequestParam(required = true) String startMinute,
                                         @RequestParam(required = true) String dAmka) {

        return reservationServices.createReservation(amka, date, startMinute, dAmka);
    }

    //by Insured' AMKA
    @GetMapping("/amka")
    public Reservation getReservationByAmka(@RequestParam String amka) {
        return reservationServices.getReservationByAmka(amka);
    }

    //by Timeslot' Date
    @GetMapping("/date")
    public Reservation getReservationByDate(@RequestParam LocalDate date){
        return reservationServices.getReservationByDate(date);
    }

    @GetMapping("/all")
    public List<Reservation> getAllReservations() {
        return reservationServices.getAllReservations();
    }

//    //method to update a reservation UP TO TWO TIMES
//    @PutMapping("/update")
//    public Reservation updateReservation(@RequestParam(required = true) String amka,
//                                         @RequestParam(required = true) LocalDate date,
//                                         @RequestParam(required = true) String startMinute){
//        return reservationServices.updateReservation(amka, date, startMinute);
//    }

//    public Reservation addReservation(@RequestBody Reservation reservation) {
//
//    }


//    @DeleteMapping
//    public List<Reservation> deleteReservation(@RequestParam String amka){
//        return reservationServices.deleteReservation(amka);
//    }

}