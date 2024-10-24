package com.example.patientManagement.repository;

import com.example.patientManagement.model.MedicalService;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ServiceRepository {
    private List<MedicalService> services = new ArrayList<>();
    private long currentId = 0; // Counter for IDs

    public List<MedicalService> findAll() {
        return services;
    }

    public void save(MedicalService service) {
        service.setId(++currentId); // Increment ID for new services
        services.add(service);
    }

    public void delete(Long id) {
        services.removeIf(service -> service.getId().equals(id));
    }

}
