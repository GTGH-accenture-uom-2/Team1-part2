package com.team1.VaccinationProject.controllers;
import com.team1.VaccinationProject.models.Insured;
import com.team1.VaccinationProject.models.Reservation;

import com.team1.VaccinationProject.models.Timeslot;
import com.team1.VaccinationProject.services.DoctorService;
import com.team1.VaccinationProject.services.InsuredService;
import com.team1.VaccinationProject.services.ReservationService;
import com.team1.VaccinationProject.services.TimeslotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/reservation")
public class ReservationController {


    //also, need access to the following Services:
    @Autowired
    ReservationService reservationService;


    @Autowired
    InsuredService insuredService;
    @Autowired
    TimeslotService timeslotService;
    @Autowired
    DoctorService doctorService;


    //------------- C.R.U.D. Reservation Controller -------------

    //1. firstly, let's create Reservations (empty items)
    @PostMapping
    public Reservation createReservation(@RequestParam String amka,
                                         @RequestParam LocalDate date,
                                         @RequestParam String startMinute,
                                         @RequestParam String dAmka) {

        return reservationService.createReservation(amka, date, startMinute, dAmka);
    }

    //by Insured AMKA
    @GetMapping("/amka")
    public Reservation getReservationByAmka(@RequestParam String amka) {
        return reservationService.getReservationByAmka(amka);
    }

    //by Timeslot Date
    @GetMapping("/date")
    public Reservation getReservationByDate(@RequestParam LocalDate date){
        return reservationService.getReservationByDate(date);
    }

    @GetMapping("/all")
    public List<Reservation> getAllReservations(){
        return reservationService.getAllReservations();
    }

    //method to update a reservation UP TO TWO TIMES
    @PutMapping("/update")
    public Reservation updateReservation(@RequestParam(required = true) String amka,
                                         @RequestParam(required = true) LocalDate newdate,
                                         @RequestParam(required = true) String startMinute){
        return reservationService.updateReservation(amka, newdate, startMinute);
    }


    @DeleteMapping
    public List<Reservation> deleteReservation(@RequestParam String amka){
        return reservationService.deleteReservation(amka);
    }
}