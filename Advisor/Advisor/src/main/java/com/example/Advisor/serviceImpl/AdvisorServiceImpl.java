package com.example.Advisor.serviceImpl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.Advisor.dao.AdvisorRepository;
import com.example.Advisor.entities.Advisor;
import com.example.Advisor.entities.SuggestionDto;
import com.example.Advisor.exceptions.ResourceNotFoundException;
import com.example.Advisor.service.AdvisorClient;
import com.example.Advisor.service.AdvisorService;

/**
 * Implementation of the AdvisorService interface.
 * This class contains the business logic related to advisors and suggestions.
 */
@Service
public class AdvisorServiceImpl implements AdvisorService {
	
	@Autowired
	AdvisorRepository advisorRepo;
	
	@Override
	public Advisor save(Advisor advisor) {
		// Saves a new advisor and returns the saved entity
		return advisorRepo.save(advisor);
	}

	@Override
	public Advisor findById(long advisorid) {
		// Finds an advisor by ID and throws ResourceNotFoundException if not found
		return advisorRepo.findById(advisorid).orElseThrow(()-> new ResourceNotFoundException("Id not found"));
	}

	@Override
	public Advisor updateAdvisor(Long advisorid, Advisor newAdvisor) {
		 // Updates an existing advisor's details
		Advisor oldAdvisor=findById(advisorid);
		oldAdvisor.setAdvisorname(newAdvisor.getAdvisorname());
		return advisorRepo.save(oldAdvisor);
	}

	@Override
	public List<Advisor> findAll() {
		// Retrieves all advisors from the repository
		return advisorRepo.findAll();
	}

	@Override
	public void deleteAdvisor(Long advisorid) {
		// Deletes an advisor by ID
		Advisor advisors=findById(advisorid);
		advisorRepo.delete(advisors);
	}

	@Autowired
	AdvisorClient advisorClient;
	@Override
	public SuggestionDto saveComplaint(Long advisorid, SuggestionDto suggestionDto) {
		// Associates the advisor ID with the suggestion and saves it through the AdvisorClient
		
		suggestionDto.setAdvisorid(advisorid);	
		// Sends the suggestion to the external service
		return advisorClient.saveComplaint(suggestionDto);
	}




}
