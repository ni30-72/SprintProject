package com.example.Complaint.service;

import java.util.List;

import com.example.Complaint.dto.ComplaintDto;
import com.example.Complaint.entities.Complaint;

public interface ComplaintService {

	ComplaintDto save(ComplaintDto complaint);

	Complaint findById(Long complaintid);

	List<Complaint> findAll();

	Complaint updateById(Complaint newComplaint, Long complaintid);

	void deleteById(Long complaintid);
}
