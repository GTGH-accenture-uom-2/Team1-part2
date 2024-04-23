package com.team1.VaccinationProject;

import com.team1.VaccinationProject.models.*;
import com.team1.VaccinationProject.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Configuration
public class Config {

    @Bean
    public CommandLineRunner commandLineRunner(DoctorService doctorService, InsuredService insuredService, ReservationService reservationService,
                                               TimeslotService timeslotService, VaccinationService vaccinationService) {
        return args -> {

            //Add four insured
            insuredService.createInsured(new Insured("afm1", "amka1", "Giannis", "A", LocalDate.of(1900,01, 01), "email1"));
            insuredService.createInsured(new Insured("afm2", "amka2", "Antonia", "P", LocalDate.of(1920,01, 01), "email2"));
            insuredService.createInsured(new Insured("afm3", "amka3", "Eleni", "T", LocalDate.of(1940,01, 01), "email3"));
            insuredService.createInsured(new Insured("afm4", "amka4", "Lina", "K", LocalDate.of(1960,01, 01), "email4"));

            //Add two doctors
            doctorService.createDoctor(new Doctor("afm5", "amka5", "Dr1", "A", LocalDate.of(1900,01, 01), "dremail1", new ArrayList<>()));
            doctorService.createDoctor(new Doctor("afm6", "amka6", "Dr2", "B", LocalDate.of(1900,01, 01), "dremail2", new ArrayList<>()));

            //Add two timeslots
            timeslotService.createTimeslot(new Timeslot(LocalDate.of(2024, 1, 1), 10,0, 10, 0));
            timeslotService.createTimeslot(new Timeslot(LocalDate.of(2010, 1, 2), 10,0, 10, 0));

            List<Timeslot> alltimeslots = new ArrayList<>(timeslotService.getAllTimeslots());
            for (Timeslot timeslot: alltimeslots){
                
            }


            //Make a reservation for insured 1 (Giannis, amka: amka1)
            //Giannis is insured at index 0
            //Update method to add insured by amka?
            reservationService.createReservation(new Reservation(insuredService.getAllInsured().get(0), timeslotService.getAllTimeslots().get(0)));

            //Make a vaccination for insured 1 (Giannis, amka: amka1) with dr1
            //Giannis is insured at index 0
            vaccinationService.createVaccination(new Vaccination(insuredService.getAllInsured().get(0), doctorService.getAllDoctors().get(0),
                    timeslotService.getAllTimeslots().get(0).getDate(), timeslotService.getAllTimeslots().get(0).getDate().plusYears(2)));









        };

    }

}
