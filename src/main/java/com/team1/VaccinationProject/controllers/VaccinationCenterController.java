package com.team1.VaccinationProject.controllers;

import com.team1.VaccinationProject.models.VaccinationCenter;
import com.team1.VaccinationProject.services.VaccinationCenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vaccinationCenter")
public class VaccinationCenterController {

    @Autowired
    VaccinationCenterService vaccinationCenterService;

    @PostMapping
    public VaccinationCenter createVaccinationCenter(@RequestBody VaccinationCenter vaccinationCenter){
        return vaccinationCenterService.createVaccinationCenter(vaccinationCenter);
    }

    @GetMapping("/byCode")
    public VaccinationCenter getVaccinationCenterByCode(@RequestParam String code){
        return vaccinationCenterService.getVaccinationCenterByCode(code);
    }

}
