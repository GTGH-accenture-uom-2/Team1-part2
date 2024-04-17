package com.team1.VaccinationProject.controllers;

import com.team1.VaccinationProject.models.Insured;
import com.team1.VaccinationProject.models.Reservation;
import com.team1.VaccinationProject.models.Timeslot;
import com.team1.VaccinationProject.services.ReservationServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/reservation")
public class ReservationController {

    @Autowired
    ReservationServices reservationServices;

    //------------- C.R.U.D. Reservation Controller -------------

    @PostMapping
    public List<Reservation> createReservation(@RequestBody Reservation reservation){
        return reservationServices.createReservation(reservation);
    }

    @GetMapping("/date")
    public Reservation getReservationByDate(@RequestParam LocalDate date){
        return reservationServices.getReservationByDate(date);
    }

    @GetMapping("/amka")
    public Reservation getReservationByAmka(@RequestParam String amka){
        return reservationServices.getReservationByAmka(amka);
    }

    @GetMapping("/all")
    public List<Reservation> getAllReservations(){
        return reservationServices.getAllReservations();
    }

    @PutMapping
    public Reservation updateReservation(@RequestParam LocalDate date,
                                         @RequestBody(required = false)Insured insured,
                                         @RequestBody(required = false)Timeslot timeslot){
        return reservationServices.updateReservation(date, insured, timeslot);
    }

    @DeleteMapping
    public List<Reservation> deleteReservation(@RequestParam String amka){
        return reservationServices.deleteReservation(amka);
    }

}
