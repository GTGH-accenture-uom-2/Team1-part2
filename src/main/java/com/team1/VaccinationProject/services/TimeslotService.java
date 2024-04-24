package com.team1.VaccinationProject.services;

import com.team1.VaccinationProject.models.Doctor;
import com.team1.VaccinationProject.models.Timeslot;
import com.team1.VaccinationProject.models.TimeslotDTO;
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
    List<TimeslotDTO> timeslotDTOList = new ArrayList<>();




    //------------- C.R.U.D. Timeslot Services -------------

    //Create new Timeslot service
    public List<TimeslotDTO> createTimeslot(Timeslot timeslot) {
        timeslotList.add(timeslot);
        timeslotDTOList.add(timeslot.toDto());
        return timeslotDTOList;
    }

    //Find Timeslots by date service
    public List<TimeslotDTO> findTimeslotByDate(LocalDate date) {

        //Create a list of Timeslots that will be found with the corresponding given date
        List<TimeslotDTO> foundTimeslots = new ArrayList<>();

        for (TimeslotDTO timeslot : timeslotDTOList) {
            //If the date is the one requested we add the timeslot to the list
            if (timeslot.getDate().equals(date)) {
                foundTimeslots.add(timeslot);
            }
        }
        if (foundTimeslots.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Timeslot with date: [" + date + "] not found");
        }
        return foundTimeslots;
    }

    //Get Timeslot with specific date and hour service
    public TimeslotDTO getTimeslotByDateHour(LocalDate date, String startMinute) {
        for (TimeslotDTO timeslot : timeslotDTOList) {
            if (timeslot.getDate().equals(date) && timeslot.getStartMinute().equals(startMinute)) {
                return timeslot;
            }
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                "Timeslot with date: [" + date + "]" +  "[" + startMinute + "] not found");
    }


    //Get Timeslot by Doctor
    public TimeslotDTO getTimeslotByDoctor(String dAmka) {

        Doctor doctor = doctorService.getDoctorByAmka(dAmka);
        if(dAmka == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "Doctor's AFM cannot be null.");
        }

        return timeslotDTOList.stream()
                .filter(x -> doctor.getAmka().equals(dAmka))
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "There is no timeslot by Doctor with AMKA: [" + "] " + dAmka));
    }


    //Get all timeslots service

    public List<Timeslot> getAllTimeslots() {
        return timeslotList;
    }

    //Get all timeslots dto service
    public List<TimeslotDTO> getAllTimeslotsDTO() {
        return timeslotDTOList;
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