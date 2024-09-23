package com.example.Complaint.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class SuggestionDto {
    
	@NotBlank(message = "Suggestion cannot be empty")
	private String suggestion;
	
	@NotNull(message = "Advisor ID cannot be null")
	 private Long advisorid;
	
	@NotNull(message = "Complaint ID cannot be null")
	 private Long complaintid;
	 
	public Long getComplaintid() {
		return complaintid;
	}
	public void setComplaintid(Long complaintid) {
		this.complaintid = complaintid;
	}
	public String getSuggestion() {
		return suggestion;
	}
	public void setSuggestion(String suggestion) {
		this.suggestion = suggestion;
	}
	public Long getAdvisorid() {
		return advisorid;
	}
	public void setAdvisorid(Long advisorid) {
		this.advisorid = advisorid;
	}
}
