package com.example.KnowledgeBase;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication

public class KnowledgeBaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(KnowledgeBaseApplication.class, args);
	}

}
