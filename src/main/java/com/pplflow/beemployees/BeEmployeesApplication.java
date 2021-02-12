package com.pplflow.beemployees;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

@EnableMongoAuditing
@SpringBootApplication
public class BeEmployeesApplication {

	public static void main(String[] args) {
		SpringApplication.run(BeEmployeesApplication.class, args);
	}

}
