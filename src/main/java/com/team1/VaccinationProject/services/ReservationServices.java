package com.team1.VaccinationProject.services;
import com.team1.VaccinationProject.models.Doctor;
import com.team1.VaccinationProject.models.Insured;
import com.team1.VaccinationProject.models.Reservation;
import com.team1.VaccinationProject.models.Timeslot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.sql.In;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ReservationServices {

    @Autowired
    InsuredServices insuredServices;
    @Autowired
    TimeslotServices timeslotServices;
    @Autowired
    DoctorServices doctorServices;

    List<Reservation> reservationList = new ArrayList<>();

    //------------- C.R.U.D. Reservation Services -------------

    //1. create the following method - connected with method inside 'ReservationController'
//    public Reservation createReservation(String amka, LocalDate date, String startMinute, String dAmka) {
//
//        // let's get the Insured from the Reservation class
//        Insured insured = insuredServices.getInsuredByAmka(amka);
//        // check if 'AMKA' is valid
//        if (amka == null || amka.isEmpty()) {
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "AMKA is required");
//        }
//
//        // let's define the timeslot // and check timeslots' availability
//        Timeslot timeslot = (Timeslot) timeslotServices.findTimeslotByDate(date).get(0);
//        if (timeslot == null || timeslot.getHasReservation()) { //==true
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid or already booked timeslot");
//        }
//
//        Doctor doctor = doctorServices.getDoctorByAmka(dAmka); //ή με το ΑΦΜ
//        //ισως χρειαστει και το ονομα του να κανουμε στο by name doctorServices.get
//        if (doctor == null) {
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Doctor does not exist");
//        }
//
//        Reservation reservation = new Reservation(insured, timeslot, doctor);
//        reservationList.add(reservation);
//        return reservation;
//
//    }

    public Reservation createReservation(String amka, LocalDate date, String startMinute, String dAmka) {

        // let's get the Insured from the Reservation class
        Insured insured = insuredServices.getInsuredByAmka(amka);
        // check if 'AMKA' is valid
        if (amka == null || amka.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "AMKA is required");
        }

        // let's define the timeslot // and check timeslots' availability
        Timeslot timeslot = timeslotServices.getTimeslotByDate(date);
        if (timeslot == null || timeslot.getHasReservation()) { //==true
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid or already booked timeslot");
        }

        Doctor doctor = doctorServices.getDoctorByAmka(dAmka); //ή με το ΑΦΜ
        //ισως χρειαστει και το ονομα του να κανουμε στο by name doctorServices.get
        if (doctor == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Doctor does not exist");
        }

        Reservation reservation = new Reservation(insured, timeslot, doctor);
        reservationList.add(reservation);
        return reservation;

    }


    // the method returns the reservation for a specific Insured Citizen (based on his 'AMKA' number)
    public Reservation getReservationByAmka(String amka) {
        for (Reservation reservation : reservationList) {
            if (reservation.getInsured().getAmka().equals(amka)) {
                return reservation;
            }
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Reservation does not exist");
    }


    // the method searches a reservation based on date of a timeslot
    public Reservation getReservationByDate(LocalDate date) {
        for (Reservation reservation : reservationList) {

            if (reservation.getTimeslot().getDate().equals(date)) {
                return reservation;
            }
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Reservation does not exist");
    }
//--------------------------------------------------------------------------------------------------------------------
    //eleni

    //the method will return all created Reservations
    public List<Reservation> getAllReservations() {
        return reservationList;
    }


    //the method will return all created Reservations for a specific doctor
    public List<Reservation> getAllDoctorsReservations(String doctorAmka) {
        //Doctor doctor = doctorServices.getDoctorByAfm(doctorAfm);
        if (doctorAmka == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "Doctor's AFM not found. It cannot be null.");
        }
        return reservationList.stream()
                .filter((reservation -> reservation.getDoctor().getAmka().equals(doctorAmka)))
                .collect(Collectors.toList());
    }


    //the method will return all created Reservations for a specific doctor and a specfic day
    public List<Reservation> getAllDoctorsReservationsByDay(String doctorAmka, LocalDate date) {
        if (doctorAmka == null || date == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "Doctor's AFM and date cannot be null.");
        }
        return reservationList.stream()
                .filter(reservation -> reservation.getDoctor().getAmka().equals(doctorAmka)
                        && reservation.getTimeslot().getDate().equals(date))
                .collect(Collectors.toList());
    }


//    public Reservation updateReservation(LocalDate date, Insured insured, Timeslot timeslot) {
//        Reservation reservation = getReservationByDate(date);
//        if (insured!= null) reservation.setInsured(insured);
//        if (timeslot!= null) reservation.setTimeslot(timeslot);
//        return reservation;
//    }
//
//    public List<Reservation> deleteReservation(String amka) {
//        Reservation reservation = getReservationByAmka(amka);
//        reservationList.remove(reservation);
//        return reservationList;
//    }

}