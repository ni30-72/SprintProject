package com.example.Complaint.mapper;

//import com.example.Complaint.dto.ComplaintDto;
import com.example.Complaint.dto.SuggestionDto;
//import com.example.Complaint.entities.Complaint;
import com.example.Complaint.entities.Suggestion;

public class SuggestionMapper {
	
	public static Suggestion toSuggestion ( SuggestionDto dto)
	{
		Suggestion suggestion = new Suggestion();
		suggestion.setAdvisorid(dto.getAdvisorid());
		suggestion.setSuggestion(dto.getSuggestion());
		//suggestion.setComplaintid(dto.getComplaintid());
		return suggestion;
	}

}
