package com.example.Complaint.mapper;

import com.example.Complaint.dto.ComplaintDtokb;
import com.example.Complaint.entities.Complaint;

public class ComplaintkbMapper {
   
	public static Complaint toComplaint(ComplaintDtokb dto)
	{
		Complaint complaint=new Complaint();
		complaint.setSector(dto.getSector());
		complaint.setQuestion(dto.getQuestion());
		complaint.setAnswer(dto.getAnswer());
		return complaint;
		
	}
}
