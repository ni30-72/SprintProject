package com.example.Advisor.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;


/**
 * Entity class representing an Advisor.
 * This class maps to the "advisors" table in the database.
 */
@Entity
@Table(name="advisors")
public class Advisor {
	 @Id  //Marks this field as the primary key
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long advisorid;
	 
	 @NotBlank(message = "Advisor name cannot be empty")
	 @Size(max = 100, message = "Advisor name must not exceed 100 characters")
	 private String advisorname;
	 
	 @NotBlank(message = "Email cannot be empty")
	 @Email(message = "Email should be valid")
	 private String email;
	 
	 @NotBlank(message = "Expertise cannot be empty")
	 @Size(max = 255, message = "Expertise must not exceed 255 characters")
	 private String expertise;
	 
	public Advisor(Long advisorid, String advisorname, String email, String expertise) {
		super();
		this.advisorid = advisorid;
		this.advisorname = advisorname;
		this.email = email;
		this.expertise = expertise;
	}

	public String getExpertise() {
		return expertise;
	}

	public void setExpertise(String expertise) {
		this.expertise = expertise;
	}

	public Long getAdvisorid() {
		return advisorid;
	}

	public void setAdvisorid(Long advisorid) {
		this.advisorid = advisorid;
	}

	public String getAdvisorname() {
		return advisorname;
	}

	public void setAdvisorname(String advisorname) {
		this.advisorname = advisorname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Advisor() {
		
	}
}
