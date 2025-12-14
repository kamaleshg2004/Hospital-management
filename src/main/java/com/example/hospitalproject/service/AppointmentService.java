package com.example.hospitalproject.service;

import com.example.hospitalproject.dao.AppointmentRepository;
import com.example.hospitalproject.model.Appointment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    
    // Create or Update
    public Appointment saveAppointment(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    // Read All
    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    // Read by ID
    public Optional<Appointment> getAppointmentById(Long id) {
        return appointmentRepository.findById(id);
    }

    // Delete
    public void deleteAppointment(Long id) {
        appointmentRepository.deleteById(id);
    }
}

