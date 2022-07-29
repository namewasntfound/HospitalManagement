package com.hospitalmanagement.controllers;


import com.hospitalmanagement.appuser.AppUserService;
import com.hospitalmanagement.patientmanagement.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {
    private final AppUserService appUserService;
    private final PatientService patientService;

    @Autowired
    public DashboardController(AppUserService appUserService, PatientService patientService) {
        this.appUserService = appUserService;
        this.patientService = patientService;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("doctors", appUserService.getDoctors());
        model.addAttribute("patients", patientService.getPatients());
        return "index";
    }
}
