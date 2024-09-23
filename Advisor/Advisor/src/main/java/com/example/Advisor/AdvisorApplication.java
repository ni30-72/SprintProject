package com.example.Advisor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


/**
 * Main class for the Advisor application.
 * This class serves as the entry point for the Spring Boot application.
 */
@SpringBootApplication
@EnableFeignClients

public class AdvisorApplication {

	public static void main(String[] args) {
		
		/**
	     * The main method that starts the Spring Boot application.
	     *
	     * @param args command-line arguments
	     */
		SpringApplication.run(AdvisorApplication.class, args);
	}

}
