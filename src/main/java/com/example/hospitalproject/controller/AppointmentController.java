package com.example.hospitalproject.controller;

import com.example.hospitalproject.model.Appointment;
import com.example.hospitalproject.model.Doctor;
import com.example.hospitalproject.model.Patient;
import com.example.hospitalproject.service.AppointmentService;
import com.example.hospitalproject.service.DoctorService;
import com.example.hospitalproject.service.PatientService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.Optional;

@Controller
@RequestMapping("/appointments")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @Autowired
    private PatientService patientService;

    @Autowired
    private DoctorService doctorService;

    // ✅ Show all appointments
    @GetMapping
    public String listAppointments(Model model) {
        model.addAttribute("appointments", appointmentService.getAllAppointments());
        return "appointment/appointment-list";
    }

    // ✅ Show form to add appointment
    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("appointment", new Appointment());
        model.addAttribute("patient", patientService.getAllPatients());
        model.addAttribute("doctor", doctorService.getAllDoctors());
        return "appointment/appointment-form";
    }

    // ✅ Save or update appointment
    @PostMapping("/save")
    public String saveAppointment(@ModelAttribute("appointment") Appointment appointment) {
        Long doctorId = appointment.getDoctor() != null ? appointment.getDoctor().getId() : null;
        Long patientId = appointment.getPatient() != null ? appointment.getPatient().getId() : null;

        if (doctorId == null || patientId == null) {
            return "redirect:/appointments/form?error=missing-id";
        }

        Optional<Doctor> doctorOpt = doctorService.getDoctorById(doctorId);
        Optional<Patient> patientOpt = patientService.getPatientById(patientId);

        if (doctorOpt.isEmpty() || patientOpt.isEmpty()) {
            return "redirect:/appointments/form?error=invalid-doctor-or-patient";
        }

        appointment.setDoctor(doctorOpt.get());
        appointment.setPatient(patientOpt.get());

        appointmentService.saveAppointment(appointment);
        return "redirect:/appointments";
    }



    // ✅ Show form to edit appointment
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Optional<Appointment> optional = appointmentService.getAppointmentById(id);
        if (optional.isPresent()) {
            model.addAttribute("appointment", optional.get());
            model.addAttribute("patient", patientService.getAllPatients());
            model.addAttribute("doctor", doctorService.getAllDoctors());
            return "appointment/appointment-form";
        } else {
            return "redirect:/appointments";
        }
    }
    
   


    // ✅ Delete appointment
    @GetMapping("/delete/{id}")
    public String deleteAppointment(@PathVariable Long id) {
        appointmentService.deleteAppointment(id);
        return "redirect:/appointments";
    }
}
