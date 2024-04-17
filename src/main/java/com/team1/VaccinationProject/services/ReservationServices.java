package com.team1.VaccinationProject.services;

import com.team1.VaccinationProject.models.Insured;
import com.team1.VaccinationProject.models.Reservation;
import com.team1.VaccinationProject.models.Timeslot;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class ReservationServices {

    List<Reservation> reservationList = new ArrayList<>();


    //------------- C.R.U.D. Reservation Services -------------

    public List<Reservation> createReservation(Reservation reservation) {
        reservationList.add(reservation);
        return reservationList;
    }

    public Reservation getReservationByDate(LocalDate date) {
        for (Reservation reservation: reservationList) {

            /*MODIFY WITH LOCAL DATE TYPE VARIABLE
                getDate should return localdate in class timeslot

            if (reservation.getTimeslot().getDate == date){
                return reservation;
            }
             */
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Reservation does not exist");
    }

    public Reservation getReservationByAmka(String amka) {
        for (Reservation reservation: reservationList) {
            if (reservation.getInsured().getAmka().equals(amka)){
                return reservation;
            }
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Reservation does not exist");
    }

    public List<Reservation> getAllReservations() {
        return reservationList;
    }

    public Reservation updateReservation(LocalDate date, Insured insured, Timeslot timeslot) {
        Reservation reservation = getReservationByDate(date);
        if (insured!= null) reservation.setInsured(insured);
        if (timeslot!= null) reservation.setTimeslot(timeslot);
        return reservation;
    }

    public List<Reservation> deleteReservation(String amka) {
        Reservation reservation = getReservationByAmka(amka);
        reservationList.remove(reservation);
        return reservationList;
    }


}
