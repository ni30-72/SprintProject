package com.example.Advisor.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Advisor.entities.Advisor;


/**
 * Repository interface for accessing Advisor entities.
 * Extends JpaRepository to provide CRUD operations and custom queries.
 */
public interface AdvisorRepository extends JpaRepository<Advisor, Long> {

}
