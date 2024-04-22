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
//    public Reservation createReservation(@RequestBody Reservation reservation) {
//
//         return reservationServices.createReservation(reservation);
//    }

    @GetMapping("/amka")
    public Reservation getReservationByAmka(@RequestParam String amka) {
        return reservationServices.getReservationByAmka(amka);
    }

    @GetMapping("/all")
    public List<Reservation> getAllReservations(){
        return reservationServices.getAllReservations();
    }

}
//----------------------------------------------------------------------------------------------------------------------

//
//    @GetMapping("/date")
//    public Reservation getReservationByDate(@RequestParam LocalDate date){
//        return reservationServices.getReservationByDate(date);
//    }


//    @PutMapping
//    public Reservation updateReservation(@RequestParam LocalDate date,
//                                         @RequestBody(required = false)Insured insured,
//                                         @RequestBody(required = false)Timeslot timeslot){
//        return reservationServices.updateReservation(date, insured, timeslot);
//    }
//
//    @DeleteMapping
//    public List<Reservation> deleteReservation(@RequestParam String amka){
//        return reservationServices.deleteReservation(amka);
//    }