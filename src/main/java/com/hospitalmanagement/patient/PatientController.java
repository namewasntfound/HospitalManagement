package com.hospitalmanagement.patient;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/patient/")
public class PatientController {

    @GetMapping
    public List<Patient> getPatient() {

        return List.of(new Patient());
    }
}
