package com.example.Advisor.exceptions;

import java.time.LocalDate;


/**
 * Class to represent the details of an error response.
 * This class encapsulates information about an error that occurs in the application.
 */
public class ErrorDetails {
	
	// The error message
	private String message;
	// The date when the error occurred
	private LocalDate date;
	// The request path that resulted in the error
	private String path;
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}

}
