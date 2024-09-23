package com.example.KnowledgeBase.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.KnowledgeBase.entities.Knowledgebase;

public interface KnowledgebaseRepository extends JpaRepository<Knowledgebase, Long> {
	List<Knowledgebase> findBySector(String sector);
}
