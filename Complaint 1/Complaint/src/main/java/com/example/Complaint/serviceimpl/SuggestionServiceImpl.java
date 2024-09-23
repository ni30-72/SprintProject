package com.example.Complaint.serviceimpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Complaint.dao.SuggestionRepository;
import com.example.Complaint.dto.SuggestionDto;
import com.example.Complaint.entities.Complaint;
import com.example.Complaint.entities.Suggestion;
import com.example.Complaint.exceptions.ResourceNotFoundException;
import com.example.Complaint.mapper.SuggestionMapper;
import com.example.Complaint.service.ComplaintService;
import com.example.Complaint.service.SuggestionService;

@Service
public class SuggestionServiceImpl implements SuggestionService {
	
	@Autowired
	SuggestionRepository suggestionRepo;
	
	@Autowired
	ComplaintService complaintService;
	
	@Override
	public Suggestion save(SuggestionDto suggestion) {
		// TODO Auto-generated method stub
		Suggestion s = SuggestionMapper.toSuggestion(suggestion);
		Complaint complaint=complaintService.findById(suggestion.getComplaintid());
		complaint.addSuggestion(s);
		s.setComplaint(complaint);
         return suggestionRepo.save(s);
          
	}
	
	@Override
	public void deleteSuggestion(Long suggestionId) {
		// TODO Auto-generated method stub
		Suggestion suggestions=findById(suggestionId);
		suggestionRepo.delete(suggestions);
	}

	@Override
	public List<Suggestion> findAllSuggestions() {
		// TODO Auto-generated method stub
		return suggestionRepo.findAll();
	}

	

	@Override
	public Suggestion findById(long suggestionid) {
		// TODO Auto-generated method stub
		return suggestionRepo.findById(suggestionid).orElseThrow(()-> new ResourceNotFoundException("Id not found"));
	}

}
