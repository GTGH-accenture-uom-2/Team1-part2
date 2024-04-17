package com.team1.VaccinationProject.models;

/* Κλάση: για τον Γιατρό  */
/* την διαχειριζόμαστε ως Υπο-κλάση της Υπερ-κλάσης 'Insured' */

import java.time.LocalDate;
import java.util.ArrayList;

public class Doctor extends Insured {
    /* δηλώνω ΜΟΝΟ τα πεδία που ΔΕΝ κληρονομώ */
    private ArrayList<Timeslot> timeslots;

    public Doctor(String afm, String amka, String name, String surname, LocalDate birthday, String email, ArrayList<Timeslot> timeslots) {
        //πρέπει να καλέσουμε τον κατασκευαστή της ΥΠΕΡΚΛΑΣΗΣ ως 1η εντολή:
        super(afm, amka, name, surname, birthday, email);
        this.timeslots = timeslots;
    }
    //Method to add/assign new timeslots to a doctor
    public void addTimeslot(Timeslot timeslot){
        timeslots.add(timeslot);
        timeslot.assignDoctor(this);
    }

    //Setter and Getter

    public ArrayList<Timeslot> getTimeslots() {
        return timeslots;
    }

    public void setTimeslots(ArrayList<Timeslot> timeslots) {
        this.timeslots = timeslots;
    }
}
