package com.example.patientManagement.controller;

import com.example.patientManagement.model.Patient;
import com.example.patientManagement.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class PatientController {

    @Autowired
    private PatientRepository patientRepository;

    @GetMapping("/patients")
    public String getAllPatients(Model model) {
        List<Patient> patients = patientRepository.findAll();
        model.addAttribute("patients", patients);
        return "patients";
    }

    @PostMapping("/patients")
    public String createPatient(@RequestParam String firstname, @RequestParam String lastname) {
        Patient patient = new Patient();
        patient.setFirstname(firstname);
        patient.setLastname(lastname);
        patientRepository.save(patient);
        return "redirect:/patients";
    }

    @PostMapping("/patients/delete")
    public String deletePatient(@RequestParam Long id) {
        patientRepository.delete(id);
        return "redirect:/patients";
    }
}
