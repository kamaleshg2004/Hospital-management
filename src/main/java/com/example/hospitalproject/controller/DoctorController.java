package com.example.hospitalproject.controller;

import com.example.hospitalproject.model.Doctor;
import com.example.hospitalproject.service.DoctorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/doctors")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    // ✅ Show all doctors
    @GetMapping
    public String listDoctors(Model model) {
        model.addAttribute("doctors", doctorService.getAllDoctors());
        return "doctor/doctor-list";
    }

    // ✅ Show form to add a new doctor
    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("doctor", new Doctor());
        return "doctor/doctor-form";
    }

    // ✅ Save doctor (create or update)
    @PostMapping("/save")
    public String saveDoctor(@ModelAttribute Doctor doctor) {
        doctorService.saveDoctor(doctor);
        return "redirect:/doctors";
    }

    // ✅ Show form to edit doctor
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Optional<Doctor> optional = doctorService.getDoctorById(id);
        if (optional.isPresent()) {
            model.addAttribute("doctor", optional.get());
            return "doctor/doctor-form";
        } else {
            return "redirect:/doctors";
        }
    }

    // ✅ Delete doctor
    @GetMapping("/delete/{id}")
    public String deleteDoctor(@PathVariable Long id) {
        doctorService.deleteDoctor(id);
        return "redirect:/doctors";
    }
}

