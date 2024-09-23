package com.example.Complaint.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Complaint.entities.Suggestion;

public interface SuggestionRepository extends JpaRepository<Suggestion, Long>{


}
