package com.example.hospitalproject.service;

import com.example.hospitalproject.model.Patient;
import java.util.List;
import java.util.Optional;

public interface PatientService {

    List<Patient> getAllPatients();
    Optional<Patient> getPatientById(Long id);
    
    void savePatient(Patient patient); // ✅ Add this line

    void deletePatient(Long id);
}
