package com.example.Consumer.entities;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ComplaintDto {
	
	@NotBlank(message = "Complaint type cannot be empty")
	private String complaintType;
	
	@NotBlank(message = "Description cannot be empty")
	private String description;
	
	private String status;
	
	@NotNull(message = "Consumer ID cannot be null")
	private Long consumerid;
	
	public String getComplaintType() {
		return complaintType;
	}
	public void setComplaintType(String complaintType) {
		this.complaintType = complaintType;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Long getConsumerid() {
		return consumerid;
	}
	public void setConsumerid(Long consumerid) {
		this.consumerid = consumerid;
	}
	
	
}
