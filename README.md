# Vaccination Recording System - PART 2
Extend the implementation of previous part by creating the Back-end infrastructure of the system. 
The functional requirements of the monitors that following are presented from the end user's perspective. So, in this part of the project  the back-end part of the application (REST Controllers) will be created so that the front-end is functional. 

Screens in brief:

|Reservation Page|
+ Search timeslot for Vaccination
  + by filling in the form with field: Date (day, month, year)
+ Timeslot commitment for vaccination
  + by filling in the form with fields: Insured' AMKA, Timeslot, Doctor
+ Update Reservation: up to two times
    > Nice to have: The search can be done for a whole month
  
|Vaccination status Page|
+ Viewing vaccination status and expiry date of vaccination coverage 
  + by filling in the form with field: Insured' AMKA
  > Nice to have: QR code for the vaccination status

|Search page for upcoming vaccinations Page|
+ View all upcoming vaccination appointments
+ View the appointments for the specific day
    > Nice to have: in case of multiple appointments not to be refunded all together but to be applied
pagination
    
    > Nice to have: Create a PDF for the doctor's day appointments

|Vaccination declaration Page|
+ Vaccination declaration
  + by filling in the form with field: Timeslot, Insured' AMKA, Duration of cover (expiry date)

> This is about the 2nd part of the Project, which includes the _Back-end implementation_ in JAVA Framework, Spring Boot.


### Getting Started

+ Development environment: 

IntelliJ, Maven


+ Tech Stack
  
JAVA

Spring Framework

Spring Boot

Swagger


+ API Root Endpoint
  
https://localhost:8080/

http://localhost:8080/swagger-ui/


+ Accounts:

GitHub, Postman


### Authors

@Anagnostou-Ioannis

@elenitasoka

@antoniapr

@linakouk
