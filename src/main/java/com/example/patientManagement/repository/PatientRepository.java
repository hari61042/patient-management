package com.example.patientManagement.repository;

import com.example.patientManagement.model.Patient;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PatientRepository {
    private List<Patient> patients = new ArrayList<>();
    private long currentId = 0; // Counter for IDs

    public List<Patient> findAll() {
        return patients;
    }

    public void save(Patient patient) {
        patient.setId(++currentId); // Increment ID for new patients
        patients.add(patient);
    }

    public void delete(Long id) {
        patients.removeIf(patient -> patient.getId().equals(id));
    }
}
