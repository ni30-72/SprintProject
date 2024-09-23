package com.example.Advisor.exceptions;


/**
 * Custom exception class to represent resource not found scenarios.
 * This exception is thrown when a requested resource cannot be found.
 */
public class ResourceNotFoundException extends RuntimeException{
	public ResourceNotFoundException(String message) {
		// TODO Auto-generated constructor stub
		super(message);
	}

}
