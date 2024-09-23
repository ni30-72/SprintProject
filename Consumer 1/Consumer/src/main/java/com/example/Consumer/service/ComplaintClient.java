package com.example.Consumer.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.Consumer.entities.ComplaintDto;

@FeignClient(name="Complaint" , url = "http://localhost:9200/complaints")
public interface ComplaintClient {
	
	@PostMapping
	ComplaintDto saveComplClient ( @RequestBody ComplaintDto dto);

}
