package com.team1.VaccinationProject.services;

import com.team1.VaccinationProject.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class VaccinationService {

    @Autowired
    InsuredService insuredService;
    @Autowired
    TimeslotService timeslotService;
    @Autowired
    ReservationService reservationService;
    List<Vaccination> vaccinationList = new ArrayList<>();

//    public List<Vaccination> createVaccination(Vaccination vaccination) {
//        vaccinationList.add(vaccination);
//        return vaccinationList;
//    }

    public Vaccination createVaccinationByDoctor(LocalDate date, String startMinute, String amka, LocalDate expirationDate) {
        // Check if there is an insured person with the given amka
        Insured insured_person = insuredService.getInsuredByAmka(amka);
        if (insured_person == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Insured with" +amka+ "does not exist");
        }

        // Check if there is a reservation for the insured person
        Reservation reservation = reservationService.getReservationByAmka(amka);
        if (reservation == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Reservation does not exist for this amka");
        }

        // Check if the given date matches the Timeslot associated with the reservation
        Timeslot timeslot = reservation.getTimeslot();
        if (timeslot == null || !timeslot.getDate().equals(date)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Date does not match reservation");
        }

        Vaccination vaccination = new Vaccination(insured_person, timeslot.getDoctor(),
                date, expirationDate);
        vaccinationList.add(vaccination);
        return vaccination;
    }


    public Vaccination getVaccinationByDate(LocalDate date) {
        for (Vaccination vaccination : vaccinationList) {
            if (vaccination.getVaccinationDate().isEqual(date)) {
                return vaccination;
            }
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Vaccination does not exist");
    }

    public Vaccination getVaccinationByAmka(String amka) {
        for (Vaccination vaccination : vaccinationList) {
            if (vaccination.getInsured().getAmka().equals(amka)) {
                return vaccination;
            }
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Vaccination does not exist");
    }

    public List<Vaccination> getAllVaccinations() {
        return vaccinationList;
    }

    public Vaccination updateVaccination(LocalDate date, Insured insured, Doctor doctor, LocalDate expirationDate) {
        Vaccination vaccination = getVaccinationByDate(date);
        if (insured != null) vaccination.setInsured(insured);
        if (doctor != null) vaccination.setDoctor(doctor);
        if (expirationDate != null) vaccination.setExpirationDate(expirationDate);
        return vaccination;
    }

    public List<Vaccination> deleteVaccinationByInsuredAmka(String amka) {
        Vaccination vaccination = getVaccinationByAmka(amka);
        vaccinationList.remove(vaccination);
        return vaccinationList;
    }

    public VaccinationStatusDTO checkVaccinationStatusByAmka(String amka) {
        Vaccination vaccination = getVaccinationByAmka(amka);
        if(vaccination.getExpirationDate().isAfter(LocalDate.now())){
            return new VaccinationStatusDTO(true, vaccination.getExpirationDate());
        }
        else if (vaccination.getExpirationDate().isBefore(LocalDate.now())) {
            return new VaccinationStatusDTO(false, vaccination.getExpirationDate());
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }
}
