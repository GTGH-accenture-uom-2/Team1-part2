//package com.team1.VaccinationProject.models;
//import java.io.*;
//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.stream.Collectors;
//
//public class Main {
//    public static void main(String[] args) throws IOException {
//
//        /*  Create objects on Main  */
//        /*  (a.) 15 insured citizens: age {10-90} => in a List  */
//        /* Create an ArrayList that contains Objects type 'Insured' */
//        ArrayList<Insured> insured = new ArrayList<>();
//        //keep citizens' name in a 'String' table
//        String[] insured_name = {"Γιάννης", "Ελένη", "Αντωνία", "Λίνα", "Θανάσης", "Μαρία", "Αρσένης", "Παυλίνα",
//                "Όλγα", "Στέλιος", "Δήμητρα", "Παντελής", "Μιχάλης", "Κατερίνα", "Ανθή"};
//        //keep citizens' birthday (1934-2014) using 'LocalDate' table
//        // (LocalDate: modern method - offers improved functionality)
//        LocalDate[] dates = new LocalDate[15];
//        for (int i = 0; i < 15; i++) {
//            dates[i] = LocalDate.of(1935 + (i * 5), 1, i + 1);
//            Insured insured_people = new Insured(insured_name[i], dates[i]);
//            insured.add(insured_people);
//        }
//        //print to check that's ok
////        for (Insured insured_people : insured) {
////            System.out.println("Insured name: " + insured_people.getName() + "\n" +
////                    "Birthday: " + insured_people.getBirthday());
////        }
//
//        /*  (b.) 2 vaccination center with 10 timeslots for each center */
//        /* Create an ArrayList to store Timeslot objects */
//        ArrayList<Timeslot> timeslot1 = new ArrayList<>();
//        ArrayList<Timeslot> timeslot2 = new ArrayList<>();
//
//        //Add timeslots to Vaccination center no. 1,2
//        for (int i = 0; i < 10; i++) {
//            Timeslot t1 = new Timeslot(LocalDate.of(2024, 4, i + 1), i, i, i, i);
//            Timeslot t2 = new Timeslot(LocalDate.of(2024, 4, i + 1), i, i, i, i);
//            timeslot1.add(t1);  //pass each timeslot to the Timeslots List for the 1st center
//            timeslot2.add(t2); //respectively, for the 2nd center
//        }
//
//        //Create Objects type 'VaccinationCenter'
//        VaccinationCenter center1 = new VaccinationCenter("VC001", "Farsalwn 1, Farsala", timeslot1);
//        VaccinationCenter center2 = new VaccinationCenter("VC002", "Newn Malgarwn 3, Malgara", timeslot2);
//
//        //Create 4 doctors
//        Doctor dr1 = new Doctor("1", "1", "A", "A", LocalDate.of(1999, 3, 21), "mail1", new ArrayList<Timeslot>());
//        Doctor dr2 = new Doctor("2", "2", "B", "B", LocalDate.of(1998, 3, 21), "mail2", new ArrayList<Timeslot>());
//        Doctor dr3 = new Doctor("3", "3", "C", "c", LocalDate.of(1993, 3, 21), "mail3", new ArrayList<Timeslot>());
//        Doctor dr4 = new Doctor("4", "4", "D", "D", LocalDate.of(1992, 3, 21), "mail4", new ArrayList<Timeslot>());
//
//        //Assign 5 timeslots to each doctor
//        //dr1 and dr2 get the first 10 from the first vaccination center
//        //dr3 and dr4 get the second 10 from the second vaccination center
//        for (int i = 0; i < 5; i++) {
//            dr1.addTimeslot(center1.getTimeslots().get(i));
//            dr2.addTimeslot(center1.getTimeslots().get(i + 5));
//            dr3.addTimeslot(center2.getTimeslots().get(i));
//            dr4.addTimeslot(center2.getTimeslots().get(i + 5));
//        }
//
//        //Print to check
////        System.out.println("Doctor: " + dr1.getName() + " " + dr1.getTimeslots().toString());
////        System.out.println("Doctor: " + dr2.getName() + " " + dr1.getTimeslots().toString());
////        System.out.println("Doctor: " + dr3.getName() + " " + dr1.getTimeslots().toString());
////        System.out.println("Doctor: " + dr4.getName() + " " + dr1.getTimeslots().toString());
//
//        //Create reservations for 8 insured people
//        ArrayList<Reservation> reservations = new ArrayList<>();
//        for (int i = 0; i < 5; i++) {
//            reservations.add(new Reservation(insured.get(i), center1.getTimeslots().get(i)));
//            //fortify (=κατοχυρώνει) the reservation in the specific timeslot of the corresponding center:
//            center1.getTimeslots().get(i).setHasReservation(true);
//        }
//        for (int i = 5; i < 8; i++) {
//            reservations.add(new Reservation(insured.get(i), center2.getTimeslots().get(i)));
//            center2.getTimeslots().get(i).setHasReservation(true);
//        }
//        for (int i = 0; i < 6; i++) {
//            Insured currentInsured = reservations.get(i).getInsured();
//            //Select the Doctor that will get the vaccination done
//            Doctor currentDoctor = reservations.get(i).getTimeslot().getDoctor();
//
//            //Use method of LocalDate to set a specific Vaccination Date
//            LocalDate currentVaccinationDate = LocalDate.of(2024, 4, 26);
//            LocalDate currentExpirationDate = LocalDate.of(2024, 4, 26);
//            Vaccination currentVaccination = new Vaccination(currentInsured, currentDoctor,
//                    currentVaccinationDate, currentExpirationDate);
//            currentDoctor.addVaccination(currentVaccination);
//        }
//
//        /*  : Write to file  */
//        //define the name of file in which prints will be written
//        String fileName = "vaccination-results.txt";
//        try {
//            //create an object 'FileWriter' with append mode
//            FileWriter fileWriter = new FileWriter(fileName, true);
//            PrintStream printStream = new PrintStream(fileName);
//            System.setOut(printStream);
//            System.out.println("Απο εδώ και πέρα όλα γράφονται εντος του αρχείου \n");
//
//            //PRINT 1 - for the Vaccination center 1
//            System.out.println("Τα επικείμενα ραντεβού για το 1ο Εμβολιαστικό Κέντρο είναι: \n");
//            for (int i = 0; i < center1.getTimeslots().size(); i++) {
//                if (center1.getTimeslots().get(i).getHasReservation().equals(true)) {
//                    System.out.println(center1.getTimeslots().get(i));
//                }
//            }
//            System.out.println("--------------------------");
//            //PRINT 1 - for the Vaccination center 2
//            System.out.println("Τα επικείμενα ραντεβού για το 2ο Εμβολιαστικό Κέντρο είναι: \n");
//            for (int i = 0; i < center2.getTimeslots().size(); i++) {
//                if (center2.getTimeslots().get(i).getHasReservation().equals(true)) {
//                    System.out.println(center2.getTimeslots().get(i));
//                }
//            }
//            System.out.println("--------------------------");
//            //PRINT 2 - for the Vaccination center 1
//            System.out.println("Οι ελέυθερες χρονικές για το 1ο Εμβολιαστικό Κέντρο είναι: \n");
//            for (int i = 0; i < center1.getTimeslots().size(); i++) {
//                if (center1.getTimeslots().get(i).getHasReservation().equals(false)) {
//                    System.out.println(center1.getTimeslots().get(i));
//                }
//            }
//            System.out.println("--------------------------");
//            //PRINT 2 - for the Vaccination center 2
//            System.out.println("Οι ελέυθερες χρονικές για το 2ο Εμβολιαστικό Κέντρο είναι: \n");
//            for (int i = 0; i < center2.getTimeslots().size(); i++) {
//                if (center2.getTimeslots().get(i).getHasReservation().equals(false)) {
//                    System.out.println(center2.getTimeslots().get(i));
//                }
//            }
//            System.out.println("--------------------------");
//
//            //PRINT 3
//            Doctor[] doctors = {dr1, dr2, dr3, dr4};
//            for (Doctor doctor : doctors) {
//                if (doctor.getVaccinations().isEmpty()) {
//                    System.out.println("Ο γιατρός " + doctor.getName() + " δεν έχει πραγματοποιήσει εμβολιασμούς.");
//                } else {
//                    System.out.println("Ο γιατρός " + doctor.getName() + " έχει πραγματοποιήσει τους ακόλουθους εμβολιασμούς: \n");
//                    for (Vaccination vaccination : doctor.getVaccinations()) {
//                        System.out.println("- Ασφαλισμένος: " + vaccination.getInsured().getName() +
//                                ", Ημερομηνία εμβολιασμού: " + vaccination.getVaccinationDate());
//                    }
//                }
//                System.out.println("--------------------------");
//            }
//
//            //PRINT 4
//            //All insured citizens > age of 60 are inside 'overSixty' list
//            List<Insured> overSixty = insured.stream()
//                    .filter(χ -> χ.getBirthday().plusYears(60).isBefore(LocalDate.now()))
//                    .collect(Collectors.toList());
//
//            boolean hasAppointment = false;
//            for (Insured overSixtyInsured : overSixty) {
//                for (int i = 0; i < reservations.size(); i++) {
//                    if (reservations.get(i).getInsured().equals(overSixtyInsured)) {
//                        hasAppointment = true;
//                        break;
//                    }
//                }
//                if (!hasAppointment) {
//                    System.out.println("Οι ασφαλισμένοι που ΔΕΝ έχουν κλείσει κανένα ραντεβού " +
//                            "και είναι άνω των 60 ετών είναι: " + overSixtyInsured.getName());
//                } else
//                    System.out.println("Όλοι οι ασφαλισμένοι άνω των 60 ετών έχουν ραντεβού.");
//                //Reset the value of hasAppointment for the next insured:
//                hasAppointment = false;
//            }
//
//            //close print to file
//            printStream.close();
//
//        } catch (IOException e) {
//            System.out.println("Σφάλμα κατά την εγγραφή στο αρχείο '" + fileName + "'.");
//            e.printStackTrace();
//        }
//
//    }
//    //the end of text file
//
//}