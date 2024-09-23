package com.example.Consumer.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="consumers")
public class Consumer {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long consumerid;
	
	@NotBlank(message = "Consumer name cannot be empty")
    @Size(max = 100, message = "Consumer name must not exceed 100 characters")
	private String consumername ;
	
	@NotBlank(message = "Email cannot be empty")
    @Email(message = "Email should be valid")
	private String email;
	
	public long getConsumerid() {
		return consumerid;
	}
	public void setConsumerid(long consumerid) {
		this.consumerid = consumerid;
	}
	public String getConsumerName() {
		return consumername;
	}
	public void setConsumerName(String name) {
		this.consumername = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Consumer(long consumerid, String consumername, String email) {
		super();
		this.consumerid = consumerid;
		this.consumername = consumername;
		this.email = email;
	}
	
	public Consumer() {
		
	}
	

}
