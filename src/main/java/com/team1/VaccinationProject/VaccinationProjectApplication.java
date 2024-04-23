package com.team1.VaccinationProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;


@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class VaccinationProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(VaccinationProjectApplication.class, args);

	}


}
