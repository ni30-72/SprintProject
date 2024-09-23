package com.example.Consumer.exceptions;

import java.time.LocalDate;

public class ErrorDetails {
	
	private String message;
	private LocalDate date;
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
