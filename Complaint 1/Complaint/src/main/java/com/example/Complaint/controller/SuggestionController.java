package com.example.Complaint.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Complaint.dto.SuggestionDto;
import com.example.Complaint.entities.Suggestion;
import com.example.Complaint.service.SuggestionService;

import jakarta.validation.Valid;


/*
 * 
 * http://localhost:9200/swagger-ui/index.html
 * 
 */


@RestController
@RequestMapping("/api/suggestions")
public class SuggestionController {
    
	@Autowired
	private SuggestionService suggestionService;
	
	
	/* Handles HTTP POST requests to post the Suggestions
	 * http://localhost:9200/api/suggestions
	 *
	 */
	@PostMapping
	public ResponseEntity<Suggestion> save(@Valid @RequestBody SuggestionDto suggestion) {
		Suggestion newSuggestion = suggestionService.save(suggestion);
		return new ResponseEntity<Suggestion>(newSuggestion, HttpStatus.CREATED);
	}
	
	
	/* Handles HTTP GET requests to find suggestion by suggestionid
	 * http://localhost:9200/api/suggestions/{suggestionid}
	 *
	 */
	@GetMapping("/{suggestionid}")
    public ResponseEntity<Suggestion> getSuggestionById(@PathVariable("suggestionid") Long suggestionId) {
        Suggestion suggestion = suggestionService.findById(suggestionId);
        return new ResponseEntity<Suggestion>(suggestion,HttpStatus.OK);
    }
	
	
	/* Handles HTTP GET requests to find all suggestion
	 * http://localhost:9200/api/suggestions/allsuggestions
	 *
	 */
	@GetMapping("/allsuggestions")
    public ResponseEntity<List<Suggestion>> getAllSuggestions() {
        List<Suggestion> suggestions = suggestionService.findAllSuggestions();
        return new ResponseEntity<List<Suggestion>>(suggestions,HttpStatus.OK);
    }
	
	/*Handles HTTP DELETE requests to delete suggestion by suggestionid
	 *http://localhost:9200/api/suggestions/{suggestionid}
	 */
	@DeleteMapping("/{suggestionid}")
    public ResponseEntity<Void> deleteSuggestion(@PathVariable("suggestionid") Long suggestionid) {
        suggestionService.deleteSuggestion(suggestionid);
        return ResponseEntity.noContent().build();
    }
}
