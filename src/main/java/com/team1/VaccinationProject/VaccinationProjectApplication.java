package com.team1.VaccinationProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/*  Error - debug:
* Looks like the initial problem is with the auto-config.
* If you don't need the datasource, simply remove it from the auto-config process:
*/
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class VaccinationProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(VaccinationProjectApplication.class, args);





	}






}
