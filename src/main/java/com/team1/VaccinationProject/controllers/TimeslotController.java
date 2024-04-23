package com.team1.VaccinationProject.controllers;
import com.team1.VaccinationProject.models.Doctor;
import com.team1.VaccinationProject.models.Timeslot;
import com.team1.VaccinationProject.services.TimeslotServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Time;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/timeslot") //let's create a REST endpoint to "/timeslot"
public class TimeslotController {

    @Autowired
    TimeslotServices timeslotServices;

    //------------- C.R.U.D. Timeslot Controller -------------

    //1. firstly, let's create a list of Timeslots (empty items)
    @PostMapping
    public List<Timeslot> createTimeslot(@RequestBody Timeslot timeslot) {
        return timeslotServices.createTimeslot(timeslot);
    }

    //2. let's get EMPTY timeslots' list based on 'Date'
    @GetMapping("/listbydate")
    public List<Timeslot> findTimeslotByDate(@RequestParam LocalDate date) {
        return timeslotServices.findTimeslotByDate(date);
    }

    //++++++++++++
    //create Timeslot method for returning a timeslot object - not a list of timeslots
    @GetMapping("/onebydate")
    public Timeslot getTimeslotByDateHour(@RequestParam LocalDate date,
                                      @RequestParam String startMinute) {
        return timeslotServices.getTimeslotByDateHour(date, startMinute);
    }

    @GetMapping("/doctor")
    public Timeslot getTimeslotByDoctor(@RequestParam String dAmka) {
        return timeslotServices.getTimeslotByDoctor(dAmka);
    }

    @GetMapping("/all")
    public List<Timeslot> getAllTimeslots() {
        return timeslotServices.getAllTimeslots();
    }



//    //Update timeslot date variable to localdate
//    @PutMapping
//    public Timeslot updateTimeslot(@RequestParam LocalDate date,
//                                   @RequestParam(required = false) int hour,
//                                   @RequestParam(required = false) int minutes,
//                                   @RequestParam(required = false) int startMinute,
//                                   @RequestParam(required = false) int endMinute,
//                                   @RequestParam(required = false) Doctor doctor) {
//
//        return timeslotServices.updateTimeslot(date, hour ,minutes, startMinute, endMinute, doctor);
//    }

//    @DeleteMapping
//    public List<Timeslot> deleteTimeslot( @RequestParam LocalDate date){
//        return timeslotServices.deleteTimeslot(date);
//    }

}