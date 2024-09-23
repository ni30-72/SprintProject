package com.example.Complaint.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;

@Entity
@Table(name="suggestions")
public class Suggestion {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long suggestionid;
	
	@NotEmpty(message = "Suggestion cannot be empty")
    private String suggestion;
	
    private Long advisorid;
  

	public Long getSuggestionid() {
		return suggestionid;
	}

	public void setSuggestionid(Long suggestionid) {
		this.suggestionid = suggestionid;
	}

	public Long getAdvisorid() {
		return advisorid;
	}

	public void setAdvisorid(Long advisorid) {
		this.advisorid = advisorid;
	}

	@ManyToOne
    @JoinColumn
    @JsonBackReference
    private Complaint complaint;
    
    
	public Complaint getComplaint() {
		return complaint;
	}

	public void setComplaint(Complaint complaint) {
		this.complaint = complaint;
	}

	

	public String getSuggestion() {
		return suggestion;
	}

	public void setSuggestion(String suggestion) {
		this.suggestion = suggestion;
	}
	
	public Suggestion(Long suggestionid, String suggestion, Long advisorid, Complaint complaint) {
		super();
		this.suggestionid = suggestionid;
		this.suggestion = suggestion;
		this.advisorid = advisorid;
		this.complaint = complaint;
	}

	public Suggestion()
	{
		
	}

	
}
