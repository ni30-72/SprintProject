package com.example.KnowledgeBase.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.KnowledgeBase.entities.ComplaintDtokb;
import com.example.KnowledgeBase.entities.Knowledgebase;
import com.example.KnowledgeBase.service.KnowledgebaseService;

import jakarta.validation.Valid;

/*
 * 
 * http://localhost:9300/swagger-ui/index.html
 * 
 */

@RestController
@RequestMapping("/faqs")
public class KnowledgebaseController {
	@Autowired
	KnowledgebaseService knowledgebaseservice;
	
	/* Handles HTTP POST requests to Post new faqs
	 * http://localhost:9300/faqs/saving
	 */
	@PostMapping("/saving")
	public ResponseEntity<Knowledgebase> save(@Valid @RequestBody Knowledgebase knowledgebase) {
		Knowledgebase newKnowledgebase = knowledgebaseservice.save(knowledgebase);
		return new ResponseEntity<Knowledgebase>(newKnowledgebase, HttpStatus.CREATED);
	}
	
	@PostMapping("/{sector}/list-of-faqs-by-sector")
	public ResponseEntity<List<ComplaintDtokb>> saveFAQs(@PathVariable("sector") String sector,
			@RequestBody ComplaintDtokb complaintDto) {
		knowledgebaseservice.saveFAQs(sector, complaintDto);
		List<ComplaintDtokb> complaints = knowledgebaseservice.findBySector(sector);
		return new ResponseEntity<>(complaints, HttpStatus.CREATED);
	}
	
	/* Handles HTTP GET requests to get faqs by faqid
	 * http://localhost:9300/faqs/{faqid}
	 */
	@GetMapping("/{faqid}")
	public ResponseEntity<Knowledgebase> findById(@PathVariable Long faqid) {
		return new ResponseEntity<Knowledgebase>(knowledgebaseservice.findById(faqid), HttpStatus.OK);
	}
	
	/* Handles HTTP DELETE requests to delete faqs by faqid
	 * http://localhost:9300/faqs/delete/1
	 */
	@DeleteMapping("/delete/{faqid}")
	public ResponseEntity<HttpStatus> delete(@PathVariable Long faqid) {
		knowledgebaseservice.deleteById(faqid);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);

	}
	
	/* Handles HTTP GET requests to findAll faqs 
	 * http://localhost:9300/faqs/allfaqs
	 */
	@GetMapping("/allfaqs")
	public ResponseEntity<List<Knowledgebase>> findAll() {
		return new ResponseEntity<List<Knowledgebase>>(knowledgebaseservice.findAll(), HttpStatus.OK);
	}
	
	/* Handles HTTP PUT requests to update faqs by faqid 
	 * http://localhost:9300/faqs/2
	 */
	@PutMapping("/{faqid}")
	public ResponseEntity<Knowledgebase> update(@PathVariable("faqid") Long faqid,
			@Valid @RequestBody Knowledgebase newKnowledgebase) {
		return new ResponseEntity<Knowledgebase>(knowledgebaseservice.updateById(newKnowledgebase, faqid),
				HttpStatus.OK);
	}
	/* Handles HTTP GET requests to find faqs by sector wise
	 * http://localhost:9300/faqs/sector/Goods
	 */
	@GetMapping("/sector/{sector}")
	public ResponseEntity<List<ComplaintDtokb>> findBySector(@PathVariable("sector") String sector) {
		return new ResponseEntity<List<ComplaintDtokb>>(knowledgebaseservice.findBySector(sector), HttpStatus.OK);
	}
}
