package com.example.Consumer.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Consumer.entities.Consumer;

public interface ConsumerRepo extends JpaRepository<Consumer, Long>{

}
