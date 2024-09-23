package com.example.Complaint.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.Complaint.dto.ComplaintDtokb;

@FeignClient(name="Complaint" ,url="http://localhost:9300/faqs")
public interface KnowledgeBaseClient {
   
	@GetMapping("/sector/{sector}")
	List<ComplaintDtokb> findBySector(@PathVariable("sector") String sector);
}
