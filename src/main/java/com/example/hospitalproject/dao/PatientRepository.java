package com.example.hospitalproject.dao;

import com.example.hospitalproject.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
    // No need to add anything here unless you want custom queries
}

