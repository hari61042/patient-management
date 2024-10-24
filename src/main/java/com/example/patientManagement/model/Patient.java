package com.example.patientManagement.model;

import java.util.ArrayList;
import java.util.List;

public class Patient {
    private Long id;
    private String firstname;
    private String lastname;
    private List<MedicalService> services = new ArrayList<>();

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public List<MedicalService> getServices() {
        return services;
    }

    public void setServices(List<MedicalService> services) {
        this.services = services;
    }
}
