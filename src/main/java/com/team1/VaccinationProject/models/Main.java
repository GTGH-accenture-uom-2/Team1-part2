package com.team1.VaccinationProject.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {

        /*  Δημιουργία αντικειμένων στη main (με ΤΥΧΑΙΕΣ τιμές στις ιδιότητές τους):  */

        /*  (α.) 15 ασφαλισμένους πολίτες: ηλικιών 10-90 ετών => σε ΛΙΣΤΑ  */
        /* Δημιουργία ενός ArrayList που περιέχει αντικείμενα τύπου 'Insured' */
        ArrayList<Insured> insured = new ArrayList<>();
        //βάσει ονόματος του κάθε ασφαλισμένου πολίτη:
        String[] insured_name = {"Γιάννης", "Ελένη", "Αντωνία", "Λίνα", "Θανάσης", "Μαρία", "Αρσένης", "Παυλίνα",
                "Όλγα", "Στέλιος", "Δήμητρα", "Παντελής", "Μιχάλης", "Κατερίνα", "Ανθή"};
        //καθώς και την ημερομηνία γέννησής του - να περιλαμβάνονται ηλικίες 10-90 ετών (γεννηθείς του 1934 έως 2014)
        //υλοποίηση με χρήση της 'LocalDate': πιο σύγχρονη μέθοδος και προσφέρει βελτιωμένη λειτουργικότητα
        LocalDate[] dates = new LocalDate[15];
        for (int i = 0; i < 15; i++) {
            dates[i] = LocalDate.of(1935 + (i * 5), 1, i + 1);
            Insured insured_people = new Insured(insured_name[i], dates[i]);
            insured.add(insured_people);
        }
        //print to check that's ok.
       /* for (Insured insured_people : insured) {
            System.out.println("Insured name: " + insured_people.getName() + "\n" +
                    "Birthday: " + insured_people.getBirthday());
        }*/

        /*  (β.) 2 εμβολιαστικά κέντρα με 10 χρονικές θυρίδες σε κάθε κέντρο  */
        /* Δημιουργία αντικειμένων τύπου 'VaccinationCenter' +
         * Δημιουργία Λίστας, η οποία περιέχει αντικέιμενα τύπου 'Timeslot' */

        // Create an ArrayList to store Timeslot objects
        ArrayList<Timeslot> timeslot1 = new ArrayList<>();
        ArrayList<Timeslot> timeslot2 = new ArrayList<>();

        //Προσθήκη χρονικών θυρίδων(timeslots) στο Vaccination center no. 1,2
        for (int i = 0; i < 10; i++) {
            Timeslot t1= new Timeslot();
            Timeslot t2= new Timeslot();
            timeslot1.add(t1);  //πέρασμα κάθε χρονικής θυρίδας στη Λίστα με τις χρονικές θυρίδες για το κέντρο 1
            timeslot2.add(t2); //αντίστοιχα και για το κέντρο 2
        }

        //2 emboliastika kentra
        VaccinationCenter center1 = new VaccinationCenter("VC001", "Farsalwn 1, Farsala", timeslot1);
        VaccinationCenter center2 = new VaccinationCenter("VC002", "Newn Malgarwn 3, Malgara", timeslot2);

        /*
        //Εκτύπωση των χρονικών θυρίδων(timeslots) στο Vaccination center no. 1,2
        System.out.println("Vaccination Center: " + center1.getAddress());
        int index=1;
        for (Timeslot t : center1.getTimeslots()) {
            System.out.println("Timeslot no. : " + index++ + t);
            System.out.println("---------");
        }
        System.out.println("Vaccination Center: " + center2.getAddress());
        for (Timeslot t : center2.getTimeslots()) {
            System.out.println("Timeslot no. : " + index++ + t);
            System.out.println("---------");
        }
        */


        //Create four doctors
        Doctor dr1 = new Doctor("1", "1", "A", "A", LocalDate.of(1999,3,21), "mail1", new ArrayList<Timeslot>());
        Doctor dr2 = new Doctor("2", "2", "B", "B", LocalDate.of(1998,3,21), "mail2", new ArrayList<Timeslot>());
        Doctor dr3 = new Doctor("3", "3", "C", "c", LocalDate.of(1993,3,21), "mail3", new ArrayList<Timeslot>());
        Doctor dr4 = new Doctor("4", "4", "D", "D", LocalDate.of(1992,3,21), "mail4", new ArrayList<Timeslot>());

        //Assign 5 timeslots to each doctor
        //dr1 and dr2 get the first 10 from the first vaccination center
        //dr3 and dr4 get the second 10 from the second vaccination center
        for(int i =0; i<5;i++){
            dr1.addTimeslot(center1.getTimeslots().get(i));
            dr2.addTimeslot(center1.getTimeslots().get(i+5));
            dr3.addTimeslot(center2.getTimeslots().get(i));
            dr4.addTimeslot(center2.getTimeslots().get(i+5));
        }

        //Print to check
        System.out.println("Doctor: " + dr1.getName() +" " + dr1.getTimeslots().toString());
        System.out.println("Doctor: " + dr2.getName() +" " + dr1.getTimeslots().toString());
        System.out.println("Doctor: " + dr3.getName() +" " + dr1.getTimeslots().toString());
        System.out.println("Doctor: " + dr4.getName() +" " + dr1.getTimeslots().toString());

        //Create reservations for 8 insured people
        ArrayList <Reservation> reservations = new ArrayList<>();
        for (int i = 0;i<8;i++){
            reservations.add(new Reservation(insured.get(i), timeslot1.get(i)));
        }

        //Print Reservations
        for (int i = 0;i<8;i++){
            System.out.println(reservations.get(i).toString());
        }




//        // Display details of center1
//        System.out.println("VACCINATION CENTER 1:");
//        System.out.println("Code: " + center1.getCode());
//        System.out.println("Address: " + center1.getAddress());
//        System.out.println("Timeslots: " + center1.getTimeslots());
//
//        // Display details of center2
//        System.out.println("\nVACCINATION CENTER 2:");
//        System.out.println("Code: " + center2.getCode());
//        System.out.println("Address: " + center2.getAddress());
//        System.out.println("Timeslots: " + center2.getTimeslots());

        //Create an object type Doctor
      //  Doctor doctor1 = new Doctor("166016416", "22112302167", "Γιώργος", "Παπαδόπουλος", LocalDate.of(1980, 1, 1), "gpapadopoulos@gmail.com");

// Create and add ten Timeslot objects to the ArrayList
//
//        timeslots.add(new Timeslot(14, 4, 2024, 10, 0, 30, 60, doctor1));
//        timeslots.add(new Timeslot(16, 4, 2024, 60, 11, 12, 10, doctor1));
//        timeslots.add(new Timeslot(17, 4, 2024, 60, 9, 10, 10, doctor1));
//        timeslots.add(new Timeslot(18, 4, 2024, 60, 8, 9, 10, doctor1));
//        timeslots.add(new Timeslot(19, 4, 2024, 60, 10, 11, 10, doctor1));
//        timeslots.add(new Timeslot(20, 4, 2024, 60, 12, 1, 10, doctor1));
//        timeslots.add(new Timeslot(21, 4, 2024, 60, 10, 11, 10, doctor1));
//        timeslots.add(new Timeslot(22, 4, 2024, 60, 11, 12, 10, doctor1));
//        timeslots.add(new Timeslot(23, 4, 2024, 60, 10, 11, 10, doctor1));
//        timeslots.add(new Timeslot(24, 4, 2024, 60, 10, 11, 10, doctor1));
//
////print objects timeslots
//        for (Timeslot timeslot : timeslots) {
//            System.out.println("Date: " + timeslot.getDay() + "/" + timeslot.getMonth() + "/" + timeslot.getYear());
//            System.out.println("Start Time: " + timeslot.getHour() + ":" + timeslot.getStartMinute());
//            System.out.println("End Time: " + timeslot.getHour() + ":" + timeslot.getEndMinute());
//      //      System.out.println("Doctor: " + timeslot.getDoctor().getName() + " " + timeslot.getDoctor().getSurname());
//            System.out.println();
//        }

    }
}
