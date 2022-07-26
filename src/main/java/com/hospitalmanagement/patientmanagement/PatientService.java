package com.hospitalmanagement.patientmanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {

    private final PatientRepository patientRepository;

    @Autowired
    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @GetMapping
    public List<Patient> getPatients() {
        return patientRepository.findAll();
    }

    public void addNewPatient(Patient patient) {
        Optional<Patient> patientByUCN = patientRepository.findPatientByUCN(patient.getUCN());

        if (patientByUCN.isPresent()) {
            throw new IllegalStateException("Patient already exists");
        }

        patientRepository.save(patient);
    }
}
