package com.team1.VaccinationProject.services;
import com.team1.VaccinationProject.models.Doctor;
import com.team1.VaccinationProject.models.Insured;
import com.team1.VaccinationProject.models.Reservation;
import com.team1.VaccinationProject.models.Timeslot;
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
import java.util.UUID;

@Service
public class ReservationServices {

    List<Reservation> reservationList = new ArrayList<>();
    List<Timeslot> timeslotList = new ArrayList<>();

    //------------- C.R.U.D. Reservation Services -------------

    //1. create the following method - connected with method inside 'ReservationController'


    // the method searches a reservation based on date of a timeslot
    public Reservation getReservationByDate(LocalDate date) {
        for (Reservation reservation: reservationList) {

            if (reservation.getTimeslot().getDate().equals(date)){
                return reservation;
            }
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Reservation does not exist");
    }


    // the method returns the reservation for a specific Insured Citizen (based on his 'AMKA' number)
    public Reservation getReservationByAmka(String amka) {
        for (Reservation reservation: reservationList) {
            if (reservation.getInsured().getAmka().equals(amka)){
                return reservation;
            }
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Reservation does not exist");
    }

    //the method will return all created Reservations
    public List<Reservation> getAllReservations() {
        return reservationList;
    }

}
//----------------------------------------------------------------------------------------------------------------------

//        insured.stream()
//                .filter(d -> insured.getAmka().equals(insured.getAmka()))
//                .findFirst()
//                .orElseThrow(() -> new RuntimeException("Δεν βρέθηκε ο γιατρός"));
//
//        doctors.stream()
//                .filter(d -> d.getName().equals(doctor.getName()))
//                .findFirst()
//                .orElseThrow(() -> new RuntimeException("Δεν βρέθηκε ο γιατρός"));
//
//          timeslots.stream()
//                .filter(t -> t.getDate().equals(timeslot.getDate()))
//                .findFirst()
//                .orElseThrow(() -> new RuntimeException("Δεν βρέθηκε το timeslot"));
//
//          reservation = new Reservation(UUID.randomUUID().toString(), insured.getAmka(), doctor, timeslot);
//        appointments.add(appointment);
//        return appointment;




//
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