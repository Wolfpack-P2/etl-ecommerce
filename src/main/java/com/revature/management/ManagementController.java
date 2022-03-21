package com.revature.management;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/management")
public class ManagementController {

    private ManagementRepository managementRepository;

    public ManagementController(ManagementRepository managementRepository) {
        this.managementRepository = managementRepository;
    }

    @RequestMapping
    public List<Management> getAllManagements() {
        return managementRepository.findAll();
    }
}
