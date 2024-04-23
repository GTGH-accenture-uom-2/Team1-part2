package com.team1.VaccinationProject;

import com.team1.VaccinationProject.models.*;
import com.team1.VaccinationProject.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.ArrayList;

@Configuration
public class Config {

    @Bean
    public CommandLineRunner commandLineRunner(DoctorServices doctorServices, InsuredServices insuredServices, ReservationServices reservationServices,
                                               TimeslotServices timeslotServices, VaccinationServices vaccinationServices) {
        return args -> {

            //Add four insured
            insuredServices.createInsured(new Insured("afm1", "amka1", "Giannis", "A", LocalDate.of(1900, 01, 01), "email1"));
            insuredServices.createInsured(new Insured("afm2", "amka2", "Antonia", "P", LocalDate.of(1920, 01, 01), "email2"));
            insuredServices.createInsured(new Insured("afm3", "amka3", "Eleni", "T", LocalDate.of(1940, 01, 01), "email3"));
            insuredServices.createInsured(new Insured("afm4", "amka4", "Lina", "K", LocalDate.of(1960, 01, 01), "email4"));

            //Add two doctors
            doctorServices.createDoctor(new Doctor("afm5", "amka5", "Dr1", "A", LocalDate.of(1900, 01, 01), "dremail1", new ArrayList<>()));
            doctorServices.createDoctor(new Doctor("afm6", "amka6", "Dr2", "B", LocalDate.of(1900, 01, 01), "dremail2", new ArrayList<>()));

            //Add two timeslots
            timeslotServices.createTimeslot(new Timeslot(LocalDate.of(2010, 1, 1), 10, 0, 10, 0));
            timeslotServices.createTimeslot(new Timeslot(LocalDate.of(2010, 1, 2), 10, 0, 10, 0));

           // reservationServices.createReservation(new Reservation(insuredServices.getAllInsured().get(0), timeslotServices.getAllTimeslots().get(0)));

        };
    }
}

            //Make a reservation for insured 1 (Giannis, amka: amka1)
            //Giannis is insured at index 0
            //Update method to add insured by amka?

            //Make a vaccination for insured 1 (Giannis, amka: amka1) with dr1
            //Giannis is insured at index 0
            // vaccinationServices.createVaccination(new Vaccination(insuredServices.getAllInsured().get(0), doctorServices.getAllDoctors().get(0),
            //         timeslotServices.getAllTimeslots().get(0).getDate(), timeslotServices.getAllTimeslots().get(0).getDate().plusYears(2)));