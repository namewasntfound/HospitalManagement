package com.hospitalmanagement.appuser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class AppUserController {

    private final AppUserService appUserService;

    @Autowired
    public AppUserController(AppUserService appUserService) {
        this.appUserService = appUserService;
    }

    @GetMapping("/doctors")
    public ModelAndView getDoctorCount() {
        ModelAndView modelAndView = new ModelAndView("index");
        List<AppUser> doctorList = appUserService.getDoctors();
        modelAndView.addObject("doctors", doctorList);
        return modelAndView;
    }

}
