package com.example.patientManagement.repository;

import com.example.patientManagement.model.Patient;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
        if (currentId > 0) {
            currentId--;
        }
    }

    public Optional<Patient> findById(Long id) {
        return patients.stream().filter(patient -> patient.getId().equals(id)).findFirst();
    }
}
