package com.example.hospitalproject.dao;

import com.example.hospitalproject.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    // findAll() is inherited from JpaRepository
}
