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
    public Reservation createReservation(String amka, LocalDate date, String startMinute, String dAmka) {

        // let's get the Insured from the Reservation class
        Insured insured = insuredServices.getInsuredByAmka(amka);
        // check if 'AMKA' is valid
        if (amka == null || amka.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"AMKA is required");
        }

        // let's define the timeslot // and check timeslots' availability
        Timeslot timeslot = (Timeslot) timeslotServices.findTimeslotByDate(date).get(0);
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
//        // FOR TESTING: Create a Reservation object with random values
//        Reservation randomReservation = new Reservation(
//                new Insured("1","1", "name", "surname",
//                        LocalDate.of(1999, 1, 1), "@gmail.com"),
//                new Timeslot(LocalDate.of(2024, 4, 24), "10:00"),
//                new Doctor("1", "name", "surname")
//        );


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


    // the method searches a reservation based on date of a timeslot
    public Reservation getReservationByDate(LocalDate date) {
        for (Reservation reservation: reservationList) {

            if (reservation.getTimeslot().getDate().equals(date)){
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