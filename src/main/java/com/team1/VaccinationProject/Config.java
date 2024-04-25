package com.team1.VaccinationProject;

import com.team1.VaccinationProject.models.*;
import com.team1.VaccinationProject.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.time.LocalDate;

@Configuration
public class Config {

    /* When we run our application,  will be created automatically:
    * Insured people => http://localhost:8080/insured/all
    * Doctors => http://localhost:8080/doctor/all
    * Timeslots => http://localhost:8080/timeslot/all
    * Vaccinations => http://localhost:8080/vaccination/all
    * Reservations => */

    @Bean
    public CommandLineRunner commandLineRunner(DoctorService doctorService, InsuredService insuredService,
                                               ReservationService reservationService,
                                               TimeslotService timeslotService,
                                               VaccinationService vaccinationService
                                               ) {
        return args -> {


            //Add one insured with specific data for testing purposes
            //insuredService.createInsured(new Insured("AFM", "AMKA", "NAME", "SURNAME" , LocalDate.of(), "EMAIL"));

            //Add ten insured, AFM_0 to AFM_9, AMKA_0 to AMKA_9, name: NAME_0 to NAME_9, birthday 1-1-1900 to 1-1-1990
            for (int i = 0; i < 10; i++) {
                insuredService.createInsured(new Insured("AFM_"+i, "AMKA_"+i, "NAME_"+i, "SURNAME_"+i , LocalDate.of(1900 + 10*i,1, 1), "EMAIL_"+i));
            }


            //Add one timeslot with specific data for testing purposes
            //timeslotService.createTimeslot(new Timeslot(LocalDate.of(2020, 1, 1), "11:00"));

            //Add ten timeslots, dates 1-1-2020 to 7-1-2020, start minute 10:00
            for (int i = 0; i < 8; i++) {
                timeslotService.createTimeslot(new Timeslot(LocalDate.of(2020, 1, 1+i), "10:00"));
            }


            //Add Vaccination centers-----------------------------
            VaccinationCenter vaccinationCenter1 = new VaccinationCenter("1", "ADRESS_1");
            VaccinationCenter vaccinationCenter2 = new VaccinationCenter("2", "ADRESS_2");

            //Assign timeslots to Vaccination centers
            for (int i = 0; i < 4; i++) {
                vaccinationCenter1.addTimeslot(timeslotService.getAllTimeslotsDTO().get(i));
                vaccinationCenter2.addTimeslot(timeslotService.getAllTimeslotsDTO().get(i+4));
            }





            //Add one doctor with specific data for testing purposes
            //doctorService.createDoctor(new Doctor("D_AMKA", "D_NAME", "D_SURNAME"));
            //doctor.addTimeslot(timeslotService.getAllTimeslotsDTO().get(INDEX));

            //Add four doctors  AMKA_0 to AMKA_3, name: D_NAME_0 to D_NAME_3 amd assign timeslots
            for (int i = 0; i < 4; i++) {
                Doctor doctor = new Doctor("D_AMKA_"+i, "D_NAME_"+i, "D_SURNAME_"+i);
                doctorService.createDoctor(doctor);
                doctor.addTimeslot(timeslotService.getAllTimeslotsDTO().get(i));
                doctor.addTimeslot(timeslotService.getAllTimeslotsDTO().get(i+4));
            }


            //Create reservation for testing purposes
            //reservationService.createReservation("AMKA", Localdate.of(date), "startMinute", "doctorAmka");

            //Create five reservations for five insured
            for (int i = 0; i < 5; i++) {
                TimeslotDTO timeslot = timeslotService.getTimeslotByDateHour(LocalDate.of(2020,1, 1+i), "10:00");
                reservationService.createReservation("AMKA_"+i, timeslot.getDate(), timeslot.getStartMinute(), timeslot.getDoctorAmka());
            }


            //Create vaccination for testing purposes
            //vaccinationService.createVaccinationByDoctor(LocalDate.of(timeslotDate), "startMinute", "amka", LocalDate.of(expirationDate));

            //Create four vaccinations
            for (int i = 0; i < 4; i++) {
                Reservation reservation = reservationService.getReservationByAmka("AMKA_"+i);
                vaccinationService.createVaccinationByDoctor(reservation.getTimeslot().getDate(), reservation.getTimeslot().getStartMinute(),
                        reservation.getInsured().getAmka(), LocalDate.now().plusYears(2));

            }

        };

    }

}
