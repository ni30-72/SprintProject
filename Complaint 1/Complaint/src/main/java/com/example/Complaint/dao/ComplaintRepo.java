package com.example.Complaint.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Complaint.entities.Complaint;

public interface ComplaintRepo extends JpaRepository<Complaint, Long> {

}
