package com.example.Consumer.service;

import java.util.List;

import com.example.Consumer.entities.ComplaintDto;
import com.example.Consumer.entities.Consumer;

public interface ConsumerService {
	Consumer save(Consumer consumer);
	List<Consumer> findAll();
	Consumer findById(Long consumerid);
	void deleteById(Long consumerid);
	Consumer updateById(Consumer newConsumer,Long consumerid);
	ComplaintDto saveComplaint(Long consumerid, ComplaintDto complaint);
}
