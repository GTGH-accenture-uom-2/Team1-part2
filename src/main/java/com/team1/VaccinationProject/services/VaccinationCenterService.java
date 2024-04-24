package com.team1.VaccinationProject.services;

import com.team1.VaccinationProject.models.Reservation;
import com.team1.VaccinationProject.models.Vaccination;
import com.team1.VaccinationProject.models.VaccinationCenter;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;


@Service
public class VaccinationCenterService {

    List<VaccinationCenter> vaccinationCenterList = new ArrayList<>();


    public VaccinationCenter createVaccinationCenter(VaccinationCenter vaccinationCenter) {
        return new VaccinationCenter(vaccinationCenter.getCode(), vaccinationCenter.getAddress(), vaccinationCenter.getTimeslots());
    }


    public VaccinationCenter getVaccinationCenterByCode(String code) {
        for (VaccinationCenter vaccinationCenter : vaccinationCenterList) {
            if (vaccinationCenter.getCode().equals(code)) {
                return vaccinationCenter;
            }
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "There is no Vaccination center by: [" + code + "] ");

    }
}
