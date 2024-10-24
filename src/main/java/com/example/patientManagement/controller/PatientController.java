package com.example.patientManagement.controller;

import com.example.patientManagement.model.Patient;
import com.example.patientManagement.repository.PatientRepository;
import com.example.patientManagement.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
public class PatientController {
    @Autowired
    private PatientService patientService;

    @GetMapping("/patients")
    public String getAllPatients(Model model) {
        List<Patient> patients = patientService.getAllPatients();
        model.addAttribute("patients", patients);
        return "patients";
    }

    @PostMapping("/patients")
    public String createPatient(@RequestParam String firstname, @RequestParam String lastname) {
        Patient patient = new Patient();
        patient.setFirstname(firstname);
        patient.setLastname(lastname);
        patientService.createPatient(patient);
        return "redirect:/patients";
    }

    @PostMapping("/patients/delete")
    public String deletePatient(@RequestParam Long id) {
        patientService.deletePatient(id);
        return "redirect:/patients";
    }

    @GetMapping("/patients/{id}")
    public String getPatientById(@PathVariable Long id, Model model) {
        Optional<Patient> patient = patientService.searchPatientByID(id);
        if (patient.isPresent()) {
            model.addAttribute("patient", patient.get());
            return "patientDetail"; // Create a new view for patient details
        } else {
            return "redirect:/patients"; // Redirect if not found
        }
    }
}
