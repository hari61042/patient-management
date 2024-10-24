package com.example.patientManagement.service;

import com.example.patientManagement.model.MedicalService;
import com.example.patientManagement.repository.ServiceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceService {
    private final ServiceRepository serviceRepository;

    public ServiceService(ServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
        initializeServices();
    }

    public List<MedicalService> getAllServices() {
        return serviceRepository.findAll();
    }

    public void createService(MedicalService service) {
        serviceRepository.save(service);
    }

    private void initializeServices() {
        // Initialize some default services here
        MedicalService service1 = new MedicalService();
        service1.setId(1L);
        service1.setService_name("Consultation");
        service1.setFees(50.0f);

        MedicalService service2 = new MedicalService();
        service2.setId(2L);
        service2.setService_name("X-Ray");
        service2.setFees(100.0f);

        serviceRepository.save(service1);
        serviceRepository.save(service2);
    }
}
