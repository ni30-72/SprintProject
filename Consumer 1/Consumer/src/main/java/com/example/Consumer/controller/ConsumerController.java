package com.example.Consumer.controller;

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

import com.example.Consumer.entities.ComplaintDto;
import com.example.Consumer.entities.Consumer;
import com.example.Consumer.service.ConsumerService;

import jakarta.validation.Valid;


/*
 * 
 * http://localhost:9400/swagger-ui/index.html
 * 
 */

@RestController
@RequestMapping("/consumers")
public class ConsumerController {
	
	@Autowired
	ConsumerService consumerService;
	
	/* Handles HTTP POST requests to post complaint details through consumerid
	 *http://localhost:9400/consumers/{consumrid}/complaint
	 */
	@PostMapping("/{consumerid}/complaint")
	public ResponseEntity<ComplaintDto> postComplaint( @PathVariable("consumerid") Long consumerid,@Valid @RequestBody ComplaintDto complaint)
	{
		ComplaintDto newComplaint=consumerService.saveComplaint(consumerid,complaint);
		return new ResponseEntity<ComplaintDto>(newComplaint,HttpStatus.CREATED);
	}
	
	/*
	 * Handles HTTP POST requests to create a new consumer
	 * http://localhost:9400/consumers/post
	 *
	 */
	@PostMapping("/post")
	public ResponseEntity<Consumer> save(@Valid @RequestBody Consumer consumer)
	{
		Consumer newConsumer=consumerService.save(consumer);
		return new ResponseEntity<Consumer>(newConsumer,HttpStatus.CREATED);
	}
	
	/* Handles HTTP GET requests to Get consumer details by consumer id
	 * http://localhost:9400/consumers/{consumerid}
	 */
	@GetMapping("/{consumerid}")
	public ResponseEntity<Consumer> findById(@PathVariable("consumerid") Long consumerid)
	{
		return new ResponseEntity<Consumer>(consumerService.findById(consumerid),HttpStatus.OK);
	}
	
	/*
	 * Handles HTTP DELETE requests to delete consumer details by consumer id
	 * http://localhost:9400/consumers/delete/{consumerid}
	 */
	@DeleteMapping("/delete/{consumerid}")
	public ResponseEntity<HttpStatus> delete(@PathVariable Long consumerid)
	{
		consumerService.deleteById(consumerid);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
		
	}
	
	/*	Handles HTTP GET request to find all consumer details
	 * http://localhost:9400/consumers/consumers
	 */
	@GetMapping("/consumers")
	public ResponseEntity<List<Consumer>> findAll()
	{
		return new ResponseEntity<List<Consumer>> ( consumerService.findAll() , HttpStatus.OK);
	}
	
	/*
	 * Handles HTTP PUT request to update the consumer details by consumerid
	 * http://localhost:9400/consumers/{consumerid}
	 */
	@PutMapping("/{consumerid}")
	public ResponseEntity<Consumer> update ( @PathVariable("consumerid")Long consumerid ,@Valid @RequestBody Consumer newConsumer )
	{
		return new ResponseEntity<Consumer> ( consumerService.updateById(newConsumer, consumerid),HttpStatus.OK);
	}
}
