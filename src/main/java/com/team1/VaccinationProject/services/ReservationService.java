package com.team1.VaccinationProject.services;

import com.team1.VaccinationProject.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import java.util.stream.Collectors;

@Service
public class ReservationService {

    @Autowired
    InsuredService insuredService;
    @Autowired
    TimeslotService timeslotService;
    @Autowired
    DoctorService doctorService;



    List<Reservation> reservationList = new ArrayList<>();


    //------------- C.R.U.D. Reservation Services -------------


    //1. create the following method - connected with method inside 'ReservationController'

    public Reservation createReservation(String amka, LocalDate date, String startMinute, String dAmka) {

        // let's get the Insured from the Reservation class
        Insured insured = insuredService.getInsuredByAmka(amka);
        // check if 'AMKA' is valid
        if (amka == null || amka.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "AMKA is required");
        }

        // let's define the timeslot // and check timeslots' availability
        TimeslotDTO timeslot = timeslotService.getTimeslotByDateHour(date, startMinute);
        if (timeslot == null || timeslot.getHasReservation()) { //==true
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid or already booked timeslot");
        }

        Doctor doctor = doctorService.getDoctorByAmka(dAmka); //ή με το ΑΦΜ
        //ισως χρειαστει και το ονομα του να κανουμε στο by name doctorServices.get
        if (doctor == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Doctor does not exist");
        }

        Reservation reservation = new Reservation(insured, timeslot, doctor);
        reservationList.add(reservation);
        timeslot.setHasReservation(true);   //to set the specific timeslot as booked
        return reservation;

    }

    // the method returns the reservation for a specific Insured Citizen (based on his 'AMKA' number)
    public Reservation getReservationByAmka(String amka) {
        for (Reservation reservation : reservationList) {
            if (reservation.getInsured().getAmka().equals(amka)) {
                return reservation;
            }
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "There is no Reservation by: [" + amka + "] ");
    }


    // the method searches a reservation based on date of a timeslot
    public Reservation getReservationByDate(LocalDate date) {
        for (Reservation reservation : reservationList) {

            if (reservation.getTimeslot().getDate().equals(date)) {
                return reservation;
            }
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "There is no Reservation found on: [" + date + "]");
    }

    //the method will return all created Reservations
    public List<Reservation> getAllReservations() {
        return reservationList;
    }


    public Reservation updateReservation(String amka, LocalDate newDate, String startMinute) {
        //Get insured
        Insured insured = insuredService.getInsuredByAmka(amka);
        //Get reservation
        Reservation reservation = getReservationByAmka(amka);
        //Get timeslot and check if it is empty
        TimeslotDTO timeslot = timeslotService.getTimeslotByDateHour(newDate, startMinute);
        if (timeslot.getHasReservation()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Timeslot has already been booked");
        }

        //Set old timeslot as free
        reservation.getTimeslot().setHasReservation(false);
        //Set new timeslot as reserved
        reservation.setTimeslot(timeslot);
        timeslot.setHasReservation(true);
        return reservation;
    }


    public List<Reservation> deleteReservation(String amka) {
        Reservation reservation = getReservationByAmka(amka);
        reservationList.remove(reservation);
        return reservationList;
    }


//--------------------------------------------------------------------------------------------------------------------
    //eleni


    //the method will return all created Reservations for a specific doctor
    public List<Reservation> getAllDoctorsReservations(String doctorAfm) {
        //Doctor doctor = doctorServices.getDoctorByAfm(doctorAfm);
        if (doctorAfm == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "Doctor's AFM not found. It cannot be null.");
        }
        return reservationList.stream()
                .filter((reservation -> reservation.getDoctor().getAmka().equals(doctorAfm)))
                .collect(Collectors.toList());
    }


    //the method will return all created Reservations for a specific doctor and a specfic day
    public List<Reservation> getAllDoctorsReservationsByDay(String doctorAmka, LocalDate date) {

        List<Reservation> foundReservations = new ArrayList<>();
        for (Reservation reservation : reservationList) {
            if (reservation.getDoctor().getAmka().equals(doctorAmka) && reservation.getTimeslot().getDate().equals(date)) {
                foundReservations.add(reservation);
            }
        }
        return foundReservations;
    }
}

