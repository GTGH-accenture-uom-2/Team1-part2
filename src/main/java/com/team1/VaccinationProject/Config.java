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

    /* When we run our application,  will be created automatically:
    * Insured people => http://localhost:8080/insured/all
    * Doctors => http://localhost:8080/doctor/all
    * Timeslots => http://localhost:8080/timeslot/all
    * Vaccinations => http://localhost:8080/vaccination/all
    * */

    @Bean
    public CommandLineRunner commandLineRunner(DoctorServices doctorServices, InsuredServices insuredServices,
                                               ReservationServices reservationServices,
                                               TimeslotServices timeslotServices,
                                               VaccinationServices vaccinationServices) {
        return args -> {
            //Add four insured
            insuredServices.createInsured(new Insured("afm1", "amka1", "Giannis", "A", LocalDate.of(1900,01, 01), "email1"));
            insuredServices.createInsured(new Insured("afm2", "amka2", "Antonia", "P", LocalDate.of(1920,01, 01), "email2"));
            insuredServices.createInsured(new Insured("afm3", "amka3", "Eleni", "T", LocalDate.of(1940,01, 01), "email3"));
            insuredServices.createInsured(new Insured("afm4", "amka4", "Lina", "K", LocalDate.of(1960,01, 01), "email4"));

            //Add two doctors
            doctorServices.createDoctor( //Doctor - constructor: AMKA, name, surname, timeslot
                    new Doctor("amka5", "Dr1", "A",  new ArrayList<>()));
            doctorServices.createDoctor(
                    new Doctor("amka6", "Dr2", "B", new ArrayList<>()));

            //Add two timeslots   //Timeslot - constructor: date, startMinute
            timeslotServices.createTimeslot(new Timeslot(LocalDate.of(2010, 1, 1), "10:00"));
            timeslotServices.createTimeslot(new Timeslot(LocalDate.of(2024, 4, 20), "10:00"));


            //Make a reservation for insured 1 (Giannis, amka: amka1)
            //Giannis is insured at index 0
            //Update method to add insured by amka?
//            reservationServices.createReservation(new Reservation(insuredServices.getInsuredByAmka("amka1"),
//                    timeslotServices.getAllTimeslots().get(0), doctorServices.getDoctorByAmka("amkaD") ) );

            //Make a vaccination for insured 1 (Giannis, amka: amka1) with dr1
            //Giannis is insured at index 0
            vaccinationServices.createVaccination(new Vaccination(insuredServices.getAllInsured().get(0), doctorServices.getAllDoctors().get(0),
                    timeslotServices.getAllTimeslots().get(0).getDate(), timeslotServices.getAllTimeslots().get(0).getDate().plusYears(2)));

        };

    }

}
