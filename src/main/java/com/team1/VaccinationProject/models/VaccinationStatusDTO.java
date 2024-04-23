package com.team1.VaccinationProject.models;

import java.time.LocalDate;
import java.util.ArrayList;

public class VaccinationStatusDTO {
    private Boolean isVaccinated;
    private LocalDate expirationDate;


    public VaccinationStatusDTO(Boolean isVaccinated, LocalDate expirationDate){
        this.isVaccinated = isVaccinated;
        this.expirationDate = expirationDate;
    }


    public Boolean getVaccinated() {
        return isVaccinated;
    }

    public void setVaccinated(Boolean vaccinated) {
        isVaccinated = vaccinated;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }
}
