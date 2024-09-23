package com.example.Complaint.service;

import java.util.List;

import com.example.Complaint.dto.SuggestionDto;
import com.example.Complaint.entities.Suggestion;

public interface SuggestionService {

	Suggestion save(SuggestionDto suggestion);

	Suggestion findById(long suggestionid);

	List<Suggestion> findAllSuggestions();

	void deleteSuggestion(Long suggestionId);
}
