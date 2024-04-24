package com.team1.VaccinationProject.models;

import java.io.IOException;
import java.time.LocalDate;

import java.util.Map;
import java.io.File;

import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.BarcodeFormat;


public class VaccinationStatusDTO {
    private Boolean isVaccinated = false;
    private LocalDate expirationDate;


    public VaccinationStatusDTO(Boolean isVaccinated, LocalDate expirationDate){
        this.isVaccinated = isVaccinated;
        this.expirationDate = expirationDate;
    }


    //Method to create QR code
    public static void createQR(String data, String path, String charset, Map hashMap) throws WriterException, IOException {

        BitMatrix matrix = new MultiFormatWriter().encode(
                new String(data.getBytes(charset), charset),
                BarcodeFormat.QR_CODE, 200, 200);

        MatrixToImageWriter.writeToFile(matrix,
                path.substring(path.lastIndexOf('.') + 1),
                new File(path));

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
