package com.team1.VaccinationProject.controllers;

import com.team1.VaccinationProject.models.Insured;
import com.team1.VaccinationProject.models.Reservation;
import com.team1.VaccinationProject.models.Timeslot;
import com.team1.VaccinationProject.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/reservation")
public class ReservationController {

    @Autowired
    ReservationService reservationService;

    //------------- C.R.U.D. Reservation Controller -------------

    @PostMapping
    public List<Reservation> createReservation(@RequestBody Reservation reservation){
        return reservationService.createReservation(reservation);
    }

    @GetMapping("/date")
    public Reservation getReservationByDate(@RequestParam LocalDate date){
        return reservationService.getReservationByDate(date);
    }

    @GetMapping("/amka")
    public Reservation getReservationByAmka(@RequestParam String amka){
        return reservationService.getReservationByAmka(amka);
    }

    @GetMapping("/all")
    public List<Reservation> getAllReservations(){
        return reservationService.getAllReservations();
    }

    @PutMapping
    public Reservation updateReservation(@RequestParam LocalDate date,
                                         @RequestBody(required = false)Insured insured,
                                         @RequestBody(required = false)Timeslot timeslot){
        return reservationService.updateReservation(date, insured, timeslot);
    }

    @DeleteMapping
    public List<Reservation> deleteReservation(@RequestParam String amka){
        return reservationService.deleteReservation(amka);
    }

}
