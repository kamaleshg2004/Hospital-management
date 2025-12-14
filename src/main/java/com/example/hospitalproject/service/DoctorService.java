package com.example.hospitalproject.service;

import com.example.hospitalproject.dao.DoctorRepository;
import com.example.hospitalproject.model.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    
    // Create or Update
    public Doctor saveDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    // Read All
    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    // Read by ID
    public Optional<Doctor> getDoctorById(Long id) {
        return doctorRepository.findById(id);
    }

    // Delete
    public void deleteDoctor(Long id) {
        doctorRepository.deleteById(id);
    }
}
