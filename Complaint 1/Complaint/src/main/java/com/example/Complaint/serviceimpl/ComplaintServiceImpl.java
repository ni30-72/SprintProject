package com.example.Complaint.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Complaint.dao.ComplaintRepo;
import com.example.Complaint.dto.ComplaintDto;
import com.example.Complaint.dto.ComplaintDtokb;
import com.example.Complaint.entities.Complaint;
import com.example.Complaint.exceptions.ResourceNotFoundException;
import com.example.Complaint.mapper.ComplaintMapper;
import com.example.Complaint.service.ComplaintService;
import com.example.Complaint.service.KnowledgeBaseClient;

@Service
public class ComplaintServiceImpl implements ComplaintService {

	@Autowired
	ComplaintRepo complaintRepo;
	
	@Autowired
	KnowledgeBaseClient knowledgeBaseClient;

	@Override
	public ComplaintDto save(ComplaintDto complaint) {
	
		System.out.println(complaint);
		complaintRepo.save(ComplaintMapper.toComplaint(complaint));
		return complaint;
	}

	@Override
	public List<Complaint> findAll() {
		// TODO Auto-generated method stub
		return complaintRepo.findAll();
	}

	@Override
	public Complaint updateById(Complaint newComplaint, Long complaintid) {
		// TODO Auto-generated method stub
		Complaint oldComplaint = findById(complaintid);
		// oldComplaint.setAdvisor(newComplaint.getAdvisor());
		oldComplaint.setComplaintid(newComplaint.getComplaintid());
		oldComplaint.setComplaintType(newComplaint.getComplaintType());
		oldComplaint.setDescription(newComplaint.getDescription());
		oldComplaint.setStatus(newComplaint.getStatus());
		// oldComplaint.setSuggestions(newComplaint.getSuggestions());
		return oldComplaint;
	}

	@Override
	public void deleteById(Long complaintid) {
		// TODO Auto-generated method stub
		Complaint complaint = findById(complaintid);
		complaintRepo.delete(complaint);

	}

	@Override
	public Complaint findById(Long complaintid) {
		// TODO Auto-generated method stub
		Complaint newComplaint= complaintRepo.findById(complaintid)
				.orElseThrow(() -> new ResourceNotFoundException("No complaint found under the given id"));
		List<ComplaintDtokb> dtokb=knowledgeBaseClient.findBySector(newComplaint.getComplaintType());
		String q="";
		String a="";
		
		for(ComplaintDtokb e:dtokb)
		{
			q=q+" "+e.getQuestion();
			a=a+" "+e.getAnswer();
		}
		newComplaint.setQuestion(q);
		newComplaint.setAnswer(a);
		return newComplaint;
	}

}
