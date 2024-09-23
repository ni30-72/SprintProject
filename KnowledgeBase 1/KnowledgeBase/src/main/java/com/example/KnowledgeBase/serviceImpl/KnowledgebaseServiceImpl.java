package com.example.KnowledgeBase.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.KnowledgeBase.dao.KnowledgebaseRepository;
import com.example.KnowledgeBase.entities.ComplaintDtokb;
import com.example.KnowledgeBase.entities.Knowledgebase;
import com.example.KnowledgeBase.exceptions.ResourceNotFoundException;
import com.example.KnowledgeBase.service.KnowledgebaseService;

@Service
public class KnowledgebaseServiceImpl implements KnowledgebaseService{
	
	@Autowired
	KnowledgebaseRepository knowledgebaseRepo;
	
	@Override
	public Knowledgebase save(Knowledgebase knowledgebase) {
		// TODO Auto-generated method stub
		return knowledgebaseRepo.save(knowledgebase);
	}

	@Override
	public List<Knowledgebase> findAll() {
		// TODO Auto-generated method stub
		return knowledgebaseRepo.findAll();
	}

	@Override
	public Knowledgebase findById(Long faqid) {
		// TODO Auto-generated method stub
		return knowledgebaseRepo.findById(faqid).orElseThrow(()-> new ResourceNotFoundException("Id not found"));
	}

	@Override
	public void deleteById(Long faqid) {
		// TODO Auto-generated method stub
		knowledgebaseRepo.deleteById(faqid);
		
	}

	@Override
	public Knowledgebase updateById(Knowledgebase newKnowledgebase, Long faqid) {
		// TODO Auto-generated method stub
		Knowledgebase oldKnowledgebase=findById(faqid);
		oldKnowledgebase.setQuestion(newKnowledgebase.getQuestion());
		oldKnowledgebase.setAnswer(newKnowledgebase.getAnswer());
		oldKnowledgebase.setSector(newKnowledgebase.getSector());
		return knowledgebaseRepo.save(oldKnowledgebase);
	}

	@Override
	public List<ComplaintDtokb> findBySector(String sector) {
		// TODO Auto-generated method stub
		
		List<Knowledgebase> faqs=knowledgebaseRepo.findBySector(sector);
		List<ComplaintDtokb> list=new ArrayList<>();
		for(Knowledgebase e:faqs)
		{
		ComplaintDtokb dtokb=new ComplaintDtokb();
		dtokb.setSector(e.getSector());
		dtokb.setQuestion(e.getQuestion());
		dtokb.setAnswer(e.getAnswer());
		list.add(dtokb);
		}
		return list;
	}

	@Override
	public List<ComplaintDtokb> saveFAQs(String sector, ComplaintDtokb complaintDto) {
		// TODO Auto-generated method stub
	    return null; 
		
	}
    
}
