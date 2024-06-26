package com.team1.VaccinationProject.controllers;

import com.team1.VaccinationProject.models.Timeslot;
import com.team1.VaccinationProject.models.TimeslotDTO;
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

    //Create new Timeslot
    @PostMapping
    public List<TimeslotDTO> createTimeslot(@RequestBody Timeslot timeslot) {
        return timeslotService.createTimeslot(timeslot);
    }

    //List Timeslots by date
    @GetMapping("/listByDate")
    public List<TimeslotDTO> findTimeslotByDate(@RequestParam LocalDate date) {
        return timeslotService.findTimeslotByDate(date);
    }

    //Get Timeslot with specific date and hour
    @GetMapping("/listByDateHour")
    public TimeslotDTO getTimeslotByDateHour(@RequestParam LocalDate date,
                                          @RequestParam String startMinute) {
        return timeslotService.getTimeslotByDateHour(date, startMinute);
    }

    //Get Timeslot by Doctor
    @GetMapping("/byDoctor")
    public List<TimeslotDTO> getTimeslotByDoctor(@RequestParam String dAmka) {
        return timeslotService.getTimeslotByDoctor(dAmka);
    }

    @GetMapping("/all")
    public List<Timeslot> getAllTimeslots() {
        return timeslotService.getAllTimeslots();
    }

    @GetMapping("/allDto")
    public List<TimeslotDTO> getAllTimeslotsDTO() {
        return timeslotService.getAllTimeslotsDTO();
    }


    //Nice to have: get timeslots for an entire month
    @GetMapping("/listByDateRange")
    public List<TimeslotDTO> findTimeslotByDateRange(@RequestParam LocalDate startDate,
                                                  @RequestParam LocalDate endDate) {
        return timeslotService.findTimeslotByDateRange(startDate, endDate);
    }

}