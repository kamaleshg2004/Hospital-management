
package com.example.hospitalproject.dao;



import com.example.hospitalproject.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    // JpaRepository already provides findAll()
}
