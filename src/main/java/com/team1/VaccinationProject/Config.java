package com.team1.VaccinationProject;
import com.team1.VaccinationProject.models.*;
import com.team1.VaccinationProject.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class Config {

    /* When we run our application,  will be created automatically:
    * Insured people => http://localhost:8080/insured/all
    * Doctors => http://localhost:8080/doctor/all
    * Timeslots => http://localhost:8080/timeslot/all
    * Vaccinations => http://localhost:8080/vaccination/all
    * Reservations => */

    @Bean
    public CommandLineRunner commandLineRunner(DoctorServices doctorServices, InsuredServices insuredServices,
                                               ReservationServices reservationServices,
                                               TimeslotServices timeslotServices,
                                               VaccinationServices vaccinationServices) {
        return args -> {
            //Add four insured
            insuredServices.createInsured(new Insured("AFM_1", "AMKA_1", "Giannis", "A",
                    LocalDate.of(1900,1, 1), "email1"));
            insuredServices.createInsured(new Insured("AFM_2", "AMKA_2", "Antonia", "P",
                    LocalDate.of(1920,1, 1), "email2"));
            insuredServices.createInsured(new Insured("AFM_3", "AMKA_3", "Eleni", "T",
                    LocalDate.of(1940,1, 1), "email3"));
            insuredServices.createInsured(new Insured("AFM_4", "AMKA_4", "Lina", "K",
                    LocalDate.of(1960,1, 1), "email4"));



            //Add two timeslots   //Timeslot - constructor: date, startMinute

            Timeslot t1 = new Timeslot(LocalDate.of(2010, 1, 1), "10:00");
            timeslotServices.createTimeslot(t1);
            Timeslot t2 = new Timeslot(LocalDate.of(2024, 4, 2), "11:00");
            timeslotServices.createTimeslot(t2);

            //Add two doctors
            doctorServices.createDoctor( //Doctor - constructor: AMKA, name, surname, timeslot
                    new Doctor("d_AMKA_1", "d_NAME_1", "d_SNAME_1", new ArrayList<>(List.of(t1)) ));
            doctorServices.createDoctor(
                    new Doctor("d_AMKA_2", "d_NAME_2", "d_SNAME_2", new ArrayList<>(List.of(t2)) ));


            reservationServices.createReservation("AMKA_1", LocalDate.of(2024, 4, 2),
                    "11:00", "d_AMKA_1");


            vaccinationServices.createVaccinationByDoctor(LocalDate.of(2024,4,2), "11:00",
                    "AMKA_1", LocalDate.of(2030, 5, 30));

        };

    }

}
