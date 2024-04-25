package com.team1.VaccinationProject.controllers;
import com.itextpdf.text.DocumentException;
import com.team1.VaccinationProject.models.Insured;
import com.team1.VaccinationProject.models.Reservation;

import com.team1.VaccinationProject.models.Timeslot;
import com.team1.VaccinationProject.services.DoctorService;
import com.team1.VaccinationProject.services.InsuredService;
import com.team1.VaccinationProject.services.ReservationService;
import com.team1.VaccinationProject.services.TimeslotService;
import jakarta.xml.ws.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.parser.Entity;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

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

    //Get all reservations by doctor amka
    @GetMapping("/alldoctorreservations")
    public List<Reservation> getDoctorReservations(@RequestParam String amka) {
        return reservationService.getAllDoctorsReservations(amka);
    }

    //Get all reservations of specific date by doctor amka
    @GetMapping("/dayreservationsbyamka")
    public List<Reservation> getAllDoctorsReservationsByDay(@RequestParam String amka, @RequestParam LocalDate date) {
        return reservationService.getAllDoctorsReservationsByDay(amka, date);
    }



    //Nice to have pagination
    @GetMapping("/pagination")
    public ResponseEntity<Map<String, Object>> getAllDoctorsReservationsByDay(
            @RequestParam String amka,
            @RequestParam LocalDate date,
            @RequestParam(defaultValue = "1") int pageNumber,
            @RequestParam(defaultValue = "10") int pageSize) {

        return reservationService.getAllDoctorsReservationsPagination(amka, date, pageNumber, pageSize);
    }

    //Nice to have
    @GetMapping("/pdf")
    public String createReservationPdf(@RequestParam String amka,
                                     @RequestParam LocalDate date)
            throws DocumentException, IOException {
        return  reservationService.createReservationPdf(amka,date);
    }



}