package com.example.patientManagement.service;

import com.example.patientManagement.model.Patient;
import com.example.patientManagement.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {
    private final PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
        initializePatients();
    }

    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    public void createPatient(Patient patient) {
        patientRepository.save(patient);
    }

    private void initializePatients() {
        // Initialize some default patients here
        Patient patient1 = new Patient();
        patient1.setId(1L);
        patient1.setFirstname("Lakshmi Prathyusha");
        patient1.setLastname("Meda");

        Patient patient2 = new Patient();
        patient2.setId(2L);
        patient2.setFirstname("HariKrishna");
        patient2.setLastname("Meda");

        patientRepository.save(patient1);
        patientRepository.save(patient2);
    }
}
