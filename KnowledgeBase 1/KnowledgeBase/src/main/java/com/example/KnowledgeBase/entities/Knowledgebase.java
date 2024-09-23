package com.example.KnowledgeBase.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="knowledgebase")
public class Knowledgebase {
      
	  @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private Long faqid;
	  
	  @NotBlank(message = "Sector cannot be empty")
	  @Size(max = 100, message = "Sector must not exceed 100 characters")
	  private String sector;
	  
	  @NotBlank(message = "Question cannot be empty")
	  @Size(max = 255, message = "Question must not exceed 255 characters")
	  private String question;
	  
	  @NotBlank(message = "Answer cannot be empty")
	  private String answer;
	  
	public Long getFaqid() {
		return faqid;
	}
	public void setFaqid(Long faqid) {
		this.faqid = faqid;
	}
	public String getSector() {
		return sector;
	}
	public void setSector(String sector) {
		this.sector = sector;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	  
	  
	  
}
