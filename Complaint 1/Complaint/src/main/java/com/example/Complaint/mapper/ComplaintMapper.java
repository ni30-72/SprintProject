package com.example.Complaint.mapper;

import com.example.Complaint.dto.ComplaintDto;
import com.example.Complaint.entities.Complaint;

public class ComplaintMapper {

	public static Complaint toComplaint ( ComplaintDto dto)
	{
		Complaint complaint = new Complaint();
		complaint.setComplaintType(dto.getComplaintType());
		complaint.setConsumerid(dto.getConsumerid());
		complaint.setDescription(dto.getDescription());
		complaint.setStatus(dto.getStatus());
		return complaint;
	}
}
