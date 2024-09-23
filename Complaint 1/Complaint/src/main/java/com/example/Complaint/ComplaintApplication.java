package com.example.Complaint;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


/**
 * Main class for the Complaint application.
 * This class serves as the entry point for the Spring Boot application.
 */
@SpringBootApplication
@EnableFeignClients
public class ComplaintApplication {

	public static void main(String[] args) {
		SpringApplication.run(ComplaintApplication.class, args);
	}

}
