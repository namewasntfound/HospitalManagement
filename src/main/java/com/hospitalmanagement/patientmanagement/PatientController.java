package com.hospitalmanagement.patientmanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/patients")
public class PatientController {
    private final PatientService patientService;

    @Autowired
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping
    public ModelAndView patientsPage() {
        ModelAndView modelAndView = new ModelAndView("patients");
        List<Patient> patients = patientService.getPatients();
        modelAndView.addObject("patients", patients);
        return modelAndView;
    }

}
