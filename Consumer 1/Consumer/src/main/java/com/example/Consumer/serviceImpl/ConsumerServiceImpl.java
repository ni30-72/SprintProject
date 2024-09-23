package com.example.Consumer.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.Consumer.dao.ConsumerRepo;
import com.example.Consumer.entities.ComplaintDto;
import com.example.Consumer.entities.Consumer;
import com.example.Consumer.exceptions.ResourceNotFoundException;
import com.example.Consumer.service.ComplaintClient;
import com.example.Consumer.service.ConsumerService;

@Service
public class ConsumerServiceImpl implements ConsumerService {
	
	@Autowired
	ConsumerRepo consumerRepo;
	
	@Autowired
	ComplaintClient client;
	
	@Override
	public Consumer save(Consumer consumer) {
		// TODO Auto-generated method stub
		return consumerRepo.save(consumer);
	}

	@Override
	public List<Consumer> findAll() {
		// TODO Auto-generated method stub
		return consumerRepo.findAll();
	}

	@Override
	public Consumer findById(Long consumerid) {
		// TODO Auto-generated method stub
		return consumerRepo.findById(consumerid).orElseThrow(()-> new ResourceNotFoundException("Id not found"));
	
	}

	@Override
	public Consumer updateById(Consumer newConsumer, Long consumerid) {
		// TODO Auto-generated method stub
		Consumer oldConsumer=findById(consumerid);
		oldConsumer.setConsumerName(newConsumer.getConsumerName());
		oldConsumer.setEmail(newConsumer.getEmail());
		return consumerRepo.save(oldConsumer);
	}

	@Override
	public void deleteById(Long consumerid) {
		// TODO Auto-generated method stub
		Consumer consumer = findById(consumerid);
		consumerRepo.delete(consumer);
		
	}

	@Override
	public ComplaintDto saveComplaint(Long consumerid, ComplaintDto complaint) {
		// TODO Auto-generated method stub
		complaint.setConsumerid(consumerid);
		return client.saveComplClient(complaint);
	}

}
