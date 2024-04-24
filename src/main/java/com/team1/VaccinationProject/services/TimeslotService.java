package com.team1.VaccinationProject.services;

import com.team1.VaccinationProject.models.Doctor;
import com.team1.VaccinationProject.models.Timeslot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class TimeslotService {

    @Autowired
    DoctorService doctorService;

    List<Timeslot> timeslotList = new ArrayList<>();

    //------------- C.R.U.D. Timeslot Services -------------

    //1. create the following method - connected with method inside 'TimeslotController'
    public List<Timeslot> createTimeslot(Timeslot timeslot) {
        timeslotList.add(timeslot);
        return timeslotList;
    }

    //2. create the following method - connected with method inside 'TimeslotController'
    public List<Timeslot> findTimeslotByDate(LocalDate date) {

        //create a list of Timeslots that will be found with the corresponding given date
        List<Timeslot> foundTimeslots = new ArrayList<>();
        for (Timeslot timeslot : timeslotList) {
            /* if timeslot found with the given date, then should return this timeslot*/
            if (timeslot.getDate().equals(date)) { //use ".equals" instead of "=="
                foundTimeslots.add(timeslot);
                timeslot.setHasReservation(true);  //to set the specific timeslot as booked
                return foundTimeslots;
            }
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Timeslot with date: [" + date + "] not found");
    }

    public Timeslot getTimeslotByDateHour(LocalDate date, String startMinute) {
        for (Timeslot timeslot : timeslotList) {
            if (timeslot.getDate().equals(date) && timeslot.getStartMinute().equals(startMinute)) {
                return timeslot;
            }
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                "Timeslot with date: [" + date + "]" +  "[" + startMinute + "] not found");
    }


    //by DOCTOR
    public Timeslot getTimeslotByDoctor(String dAmka) {

        Doctor doctor = doctorService.getDoctorByAmka(dAmka);
        if(dAmka == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "Doctor's AFM cannot be null.");
        }

        return timeslotList.stream()
                .filter(x -> doctor.getAmka().equals(dAmka))
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "There is no timeslot by Doctor with AMKA: [" + "] " + dAmka));
    }


    public List<Timeslot> getAllTimeslots() {
        return timeslotList;
    }

}


//    public Timeslot updateTimeslot(LocalDate date, int hour, int minutes, int startMinute, int endMinute, Doctor doctor) {
//        Timeslot timeslot = getTimeslotByDate(date);
//        if (hour != 0) timeslot.setHour(hour);
//        if (minutes != 0) timeslot.setMinutes(minutes);
//        if (startMinute != 0) timeslot.setStartMinute(startMinute);
//        if (endMinute != 0) timeslot.setEndMinute(endMinute);
//        if (doctor != null) timeslot.setDoctor(doctor);
//        return timeslot;
//    }
//
//    public List<Timeslot> deleteTimeslot(LocalDate date) {
//        Timeslot timeslot = getTimeslotByDate(date);
//        timeslotList.remove(timeslot);
//        return timeslotList;
//    }}