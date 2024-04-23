package com.team1.VaccinationProject.controllers;

import com.team1.VaccinationProject.models.Doctor;
import com.team1.VaccinationProject.models.Timeslot;
import com.team1.VaccinationProject.services.TimeslotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/timeslot")
public class TimeslotController {


    @Autowired
    TimeslotService timeslotService;

    //------------- C.R.U.D. Timeslot Controller -------------

    @PostMapping
    public List<Timeslot> createTimeslot(@RequestBody Timeslot timeslot){
        return timeslotService.createTimeslot(timeslot);
    }

    @GetMapping("/date")
    public Timeslot getTimeslotByDate(@RequestParam LocalDate date){
        return timeslotService.getTimeslotByDate(date);
    }

    @GetMapping("/doctor")
    public Timeslot getTimeslotByDoctor(@RequestParam Doctor doctor){
        return timeslotService.getTimeslotByDoctor(doctor);
    }

    @GetMapping("/all")
    public List<Timeslot> getAllTimeslots(){
        return timeslotService.getAllTimeslots();
    }

    //Update timeslot date variable to localdate
    @PutMapping
    public Timeslot updateTimeslot(@RequestParam LocalDate date,
                                   @RequestParam(required = false) int hour,
                                   @RequestParam(required = false) int minutes,
                                   @RequestParam(required = false) int startMinute,
                                   @RequestParam(required = false) int endMinute,
                                   @RequestParam(required = false) Doctor doctor) {

        return timeslotService.updateTimeslot(date, hour ,minutes, startMinute, endMinute, doctor);
    }

    @DeleteMapping
    public List<Timeslot> deleteTimeslot( @RequestParam LocalDate date){
        return timeslotService.deleteTimeslot(date);
    }
}
