package com.team1.VaccinationProject.services;
import com.team1.VaccinationProject.models.Insured;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class InsuredServices {

    List<Insured> insuredList = new ArrayList<>();

    //------------- C.R.U.D. Insured Services -------------

    public List<Insured> createInsured(Insured insured) {

        insuredList.add(insured);
        return insuredList;
    }

    public Insured getInsuredByAmka(String amka) {

        return insuredList.stream()
                .filter(insured -> insured.getAmka().equals(amka))
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                                                         "Insured with AMKA: [" + amka + "] does not exist"));

                //alternative way:
                /*  for (Insured insured : insuredList) {
                    if (insured.getAmka().equals(amka)) {
                        return insured;
                    }
                }
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Insured does not exist");
                */
    }

    public Insured getInsuredByAfm(String afm) {

        return insuredList.stream()
                .filter(insured -> insured.getAfm().equals(afm))
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                                                                "Insured with AFM: [" + afm + "] does not exist"));
    }

    public List<Insured> getAllInsured() {
        return insuredList;
    }

}
