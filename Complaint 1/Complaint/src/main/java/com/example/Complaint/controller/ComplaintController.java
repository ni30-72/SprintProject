package com.example.Complaint.controller;

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

import com.example.Complaint.dto.ComplaintDto;
import com.example.Complaint.entities.Complaint;
import com.example.Complaint.service.ComplaintService;

import jakarta.validation.Valid;


/*
 * 
 * http://localhost:9200/swagger-ui/index.html
 * 
 */


@RestController
@RequestMapping("/complaints")
public class ComplaintController {

	@Autowired
	ComplaintService complaintService;
	
	
	//This method is used for saving the complaint details which are raised by consumer
	@PostMapping
	public ResponseEntity<ComplaintDto> save(@Valid @RequestBody ComplaintDto complaint) {
		ComplaintDto newComplaint = complaintService.save(complaint);
		return new ResponseEntity<ComplaintDto>(newComplaint, HttpStatus.CREATED);
	}

	
	/*
	 * Handles HTTP GET requests to find complaint by complaintid
	 * http://localhost:9200/complaints/{complaintid}
	 *
	 */
	@GetMapping("/{complaintid}")
	public ResponseEntity<Complaint> findById(@PathVariable("complaintid") Long complaintid) {
		return new ResponseEntity<Complaint>(complaintService.findById(complaintid), HttpStatus.OK);
	}
    
	/* Handles HTTP DELETE requests to delete complaint details by complaintid
	 * http://localhost:9200/complaints/delete/{complaintid}
	 */
	@DeleteMapping("/delete/{complaintid}") 
	public ResponseEntity<HttpStatus> delete(@PathVariable Long complaintid) {
		complaintService.deleteById(complaintid);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);

	}
	
	/* Handles HTTP GET requests to findAll complaints
	 * http://localhost:9200/complaints/complaints
	 */
	@GetMapping("/complaints")
	public ResponseEntity<List<Complaint>> findAll() {
		return new ResponseEntity<List<Complaint>>(complaintService.findAll(), HttpStatus.OK);
	}
	
	/* Handles HTTP PUT requests to update the complaint details
	 * http://localhost:9200/complaints/{complaintid}
	 */
	@PutMapping("/{complaintid}") 
	public ResponseEntity<Complaint> update(@PathVariable("complaintid") Long complaintid,
			@Valid @RequestBody Complaint newData) {
		return new ResponseEntity<Complaint>(complaintService.updateById(newData, complaintid), HttpStatus.OK);
	}
}
