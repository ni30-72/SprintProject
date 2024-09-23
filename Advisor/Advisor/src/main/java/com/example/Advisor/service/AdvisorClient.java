package com.example.Advisor.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.Advisor.entities.SuggestionDto;

/**
 * Feign client interface for communicating with the Complaint service. This
 * interface defines the methods for making HTTP requests to the Complaint
 * service API.
 */
@FeignClient(name = "Complaint", url = "http://localhost:9200/api/suggestions")
public interface AdvisorClient {

	/**
	 * Sends a suggestion to the Complaint service.
	 */
	@PostMapping
	SuggestionDto saveComplaint(SuggestionDto suggestionDto);

}
