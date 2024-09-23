package com.example.KnowledgeBase.service;

import java.util.List;

import com.example.KnowledgeBase.entities.ComplaintDtokb;
import com.example.KnowledgeBase.entities.Knowledgebase;

public interface KnowledgebaseService {
	Knowledgebase save(Knowledgebase knowledgebase);
	List<Knowledgebase> findAll();
	Knowledgebase findById(Long faqid);
	void deleteById(Long faqid);
	Knowledgebase updateById(Knowledgebase newKnowledgebase,Long faqid);
	List<ComplaintDtokb> findBySector(String sector);
	List<ComplaintDtokb> saveFAQs(String sector, ComplaintDtokb complaintDto);
}
