package com.example.patientManagement.controller;

import com.example.patientManagement.model.MedicalService;
import com.example.patientManagement.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ServiceController {

    @Autowired
    private ServiceRepository serviceRepository;

    @GetMapping("/services")
    public String getAllServices(Model model) {
        List<MedicalService> services = serviceRepository.findAll();
        model.addAttribute("services", services);
        return "services";
    }

    @PostMapping("/services")
    public String createService(@RequestParam String service_name, @RequestParam float fees) {
        MedicalService service = new MedicalService();
        service.setService_name(service_name);
        service.setFees(fees);
        serviceRepository.save(service);
        return "redirect:/services";
    }

    @PostMapping("/services/delete")
    public String deleteService(@RequestParam Long id) {
        serviceRepository.delete(id);
        return "redirect:/services";
    }

}