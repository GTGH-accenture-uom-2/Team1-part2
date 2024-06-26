package com.team1.VaccinationProject.services;

import com.team1.VaccinationProject.models.Doctor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class DoctorService {

    List<Doctor> doctorList = new ArrayList<>();


    //------------- C.R.U.D. Doctor Services -------------


    //Create Doctor service
    public List<Doctor> createDoctor(Doctor doctor) {
        doctorList.add(doctor);
        return doctorList;
    }

    //Get doctor by amka service
    public Doctor getDoctorByAmka(String amka) {
        for (Doctor doctor : doctorList) {
            if (doctor.getAmka().equals(amka)) {
                return doctor;
            }
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Doctor does not exist");
    }

    //Get all doctors service
    public List<Doctor> getAllDoctors() {
        return doctorList;
    }


    //Update doctor
    public Doctor updateDoctor(String amka, String name, String surname) {
        Doctor doctor = getDoctorByAmka(amka);
        if (name != null) doctor.setName(name);
        if (surname != null) doctor.setSurname(surname);
        return doctor;

    }

    //Delete doctor
    public List<Doctor> deleteDoctor(String amka) {
        Doctor doctor = getDoctorByAmka(amka);
        doctorList.remove(doctor);
        return doctorList;
    }
}
