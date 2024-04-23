package com.team1.VaccinationProject.services;

import com.team1.VaccinationProject.models.Doctor;
import com.team1.VaccinationProject.models.Timeslot;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class TimeslotService {

    List<Timeslot> timeslotList = new ArrayList<>();


    //------------- C.R.U.D. Timeslot Services -------------

    public List<Timeslot> createTimeslot(Timeslot timeslot) {
        timeslotList.add(timeslot);
        return timeslotList;
    }

    public Timeslot getTimeslotByDate(LocalDate date) {
        for (Timeslot timeslot: timeslotList){
           /*MODIFY WITH LOCAL DATE TYPE VARIABLE
                getDate should return localdate in class timeslot

            if (timeslot.getDate == date){
                return timeslot;
            }
             */
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Reservation does not exist");
    }


    public Timeslot getTimeslotByDoctor(Doctor doctor) {
        for (Timeslot timeslot: timeslotList){
            if (timeslot.getDoctor().equals(doctor))
                return timeslot;
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Reservation does not exist");
    }

    public List<Timeslot> getAllTimeslots() {
        return timeslotList;
    }

    public Timeslot updateTimeslot(LocalDate date, int hour, int minutes, int startMinute, int endMinute, Doctor doctor) {
        Timeslot timeslot = getTimeslotByDate(date);
        if (hour != 0) timeslot.setHour(hour);
        if (minutes != 0) timeslot.setMinutes(minutes);
        if (startMinute != 0) timeslot.setStartMinute(startMinute);
        if (endMinute != 0) timeslot.setEndMinute(endMinute);
        if (doctor != null) timeslot.setDoctor(doctor);
        return timeslot;
    }


    public List<Timeslot> deleteTimeslot(LocalDate date) {
        Timeslot timeslot = getTimeslotByDate(date);
        timeslotList.remove(timeslot);
        return timeslotList;
    }
}



