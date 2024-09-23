package com.example.Advisor.service;

import java.util.List;
import com.example.Advisor.entities.Advisor;
import com.example.Advisor.entities.SuggestionDto;

/**
 * Service interface for managing Advisor-related operations. This interface
 * defines the methods for handling business logic related to advisors and
 * suggestions.
 */
public interface AdvisorService {

	Advisor save(Advisor advisor);

	Advisor findById(long advisorid);

	Advisor updateAdvisor(Long advisorid, Advisor newAdvisor);

	List<Advisor> findAll();

	void deleteAdvisor(Long advisorid);

	SuggestionDto saveComplaint(Long advisorid, SuggestionDto suggestionDto);
}
