package com.team1.VaccinationProject.services;

import com.team1.VaccinationProject.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ReservationService {

    @Autowired
    InsuredService insuredService;
    @Autowired
    TimeslotService timeslotService;
    @Autowired
    DoctorService doctorService;
    @Autowired
            VaccinationCenterService vaccinationCenterService;




    List<Reservation> reservationList = new ArrayList<>();


    //------------- C.R.U.D. Reservation Services -------------


    //1. create the following method - connected with method inside 'ReservationController'

    public Reservation createReservation(String amka, LocalDate date, String startMinute, String dAmka) {

        // let's get the Insured from the Reservation class
        Insured insured = insuredService.getInsuredByAmka(amka);

        for (Reservation reservation: reservationList){
            if (reservation.getInsured().getAmka().equals(amka)){
                throw new RuntimeException("Insured already has reservation");
            }
        }


        // let's define the timeslot // and check timeslots' availability
        TimeslotDTO timeslot = timeslotService.getTimeslotByDateHour(date, startMinute);


        Doctor doctor = doctorService.getDoctorByAmka(dAmka);



        Reservation reservation = new Reservation(insured, timeslot, doctor, timeslot.getVaccinationCenterCode());
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
        if (insured.getUpdateCounter() >= 2){
            throw  new RuntimeException("Reservation update limit reached");
        }

        //Set old timeslot as free
        reservation.getTimeslot().setHasReservation(false);
        //Increase update counter
        insured.setUpdateCounter(insured.getUpdateCounter()+ 1);
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

    //Nice to have pagination service
    public ResponseEntity<Map<String, Object>> getAllDoctorsReservationsPagination(String doctorAmka, LocalDate date, int pageNumber, int pageSize) {

        //sort the list of reservations before pagination
        List<Reservation> reservationListCopy = new ArrayList<>(reservationList);
        reservationListCopy.sort((r1, r2) -> {
            int dateComparison = r1.getTimeslot().getDate().compareTo(r2.getTimeslot().getDate());
            if (dateComparison == 0) {
                return r1.getDoctor().getAmka().compareTo(r2.getDoctor().getAmka());
            } else {
                return dateComparison;
            }
        });

        List<Reservation> foundReservations = new ArrayList<>();
        int startIndex = (pageNumber - 1) * pageSize; //pageNumber->number of the page. first page is the 1 not 0.
        // pageSize->maximum number of reservations in the page
        //startIndex->firstReservation of the page
        int endIndex = startIndex + pageSize;

        //pagination
        for (int i = 0; i < reservationListCopy.size(); i++) {
            Reservation reservation = reservationListCopy.get(i);
            if (reservation.getDoctor().getAmka().equals(doctorAmka) && reservation.getTimeslot().getDate().equals(date)) {
                if (i >= startIndex && i < endIndex) {
                    foundReservations.add(reservation);
                }
                if (foundReservations.size() == pageSize) {
                    break;
                }
            }
        }

        int totalReservations = reservationListCopy.size();
        int numberOfPages = (int) Math.ceil((double) totalReservations / pageSize); //calculate total number of pages.
        // math.ceil()->round a number up to its nearest integer


        Map<String, Object> response = new HashMap<>();
        response.put("reservations", foundReservations);
        response.put("numberOfPages", numberOfPages);
        response.put("pageNumber", pageNumber);
        response.put("totalReservations", totalReservations);


        return new ResponseEntity<>(response, HttpStatus.OK);
        //return foundReservations;
    }



}
