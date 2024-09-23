package com.example.Advisor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Advisor.entities.Advisor;
import com.example.Advisor.entities.SuggestionDto;
import com.example.Advisor.service.AdvisorService;

import jakarta.validation.Valid;

/*
 * 
 * http://localhost:9500/swagger-ui/index.html
 * 
 */

@RestController
@RequestMapping("/advisors")
public class AdvisorController {
	@Autowired
	AdvisorService advisorService;

	/* Handles HTTP POST requests to post suggestions using advisor id
     * http://localhost:9500/advisors/{advisorid}/suggestion
     */
	@PostMapping("/{advisorid}/suggestion")
	public ResponseEntity<SuggestionDto> postSuggestion(@PathVariable("advisorid") Long advisorid,
			@Valid @RequestBody SuggestionDto suggestionDto) {
		// Saves the suggestion and returns the newly created suggestion
		SuggestionDto newSuggestion = advisorService.saveComplaint(advisorid, suggestionDto);
		return new ResponseEntity<SuggestionDto>(newSuggestion, HttpStatus.CREATED);
	}

	 /*
     * Handles HTTP POST requests to create a new advisor
     * http://localhost:9500/advisors/advisor
     */

	@PostMapping("/advisor")
	public ResponseEntity<Advisor> save(@Valid @RequestBody Advisor advisor) {
		Advisor newAdvisor = advisorService.save(advisor);
		return new ResponseEntity<Advisor>(newAdvisor, HttpStatus.CREATED);
	}
	
	/*
     * Handles HTTP GET requests to find advisor By AdvisorID
     * http://localhost:9500/advisors/findbyid/{advisorid}
     */
	@GetMapping("/findbyid/{advisorid}")
	public ResponseEntity<Advisor> findById(@PathVariable("advisorid") Long advisorid) {
		// Finds the advisor by ID and returns it
		return new ResponseEntity<Advisor>(advisorService.findById(advisorid), HttpStatus.OK);
	}

	/*
	 * Handles HTTP GET request to find all advisors
	 * http://localhost:9500/advisors/advisors
	 */
	@GetMapping("/advisors")
	public ResponseEntity<List<Advisor>> findAll() {
		// Retrieves all advisors and returns them
		return new ResponseEntity<List<Advisor>>(advisorService.findAll(), HttpStatus.OK);
	}
	
	/*
	 * Handles HTTP DELETE request to delete advisors by advisorid
	 * http://localhost:9500/advisors/{advisorid}
	 */
	@DeleteMapping("/{advisorid}") 
	public ResponseEntity<HttpStatus> deleteById(@PathVariable("advisorid") Long advisorid) {
		// Deletes the advisor by ID
		advisorService.deleteAdvisor(advisorid);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}

	/*
	 * Handles HTTP PUT request to update Advisor details by Advisorid
	 * http://localhost:9500/advisors/update/{advisorid}
	 */
	@PutMapping("/update/{advisorid}") 
	public ResponseEntity<Advisor> updateById(@PathVariable("advisorid") Long advisorid,
			@Valid @RequestBody Advisor newAdvisor) {
		// Updates the advisor and returns the updated advisor
		return new ResponseEntity<Advisor>(advisorService.updateAdvisor(advisorid, newAdvisor), HttpStatus.OK);
	}

}
