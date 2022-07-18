package com.hospitalmanagement.patient.config;

import com.hospitalmanagement.patient.Patient;
import com.hospitalmanagement.patient.PatientRepository;
import com.hospitalmanagement.patient.address.Address;
import com.hospitalmanagement.patient.person.Person;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.parameters.P;

import java.time.LocalDate;

@Configuration
public class PatientConfig {

    @Bean
    CommandLineRunner commandLineRunner(PatientRepository patientRepository) {
        return args -> {
            Patient patient = new Patient("9803046422",
                    "Atilla",
                    "Ashkin",
                    "Chakarov",
                    LocalDate.of(1998, 3, 4),
                    new Address("Bulgaria",
                            "Ruse",
                            "Ruse",
                            "Angel Kunchev 18",
                            7000),
                    "0885108187"
            );
            patientRepository.save(patient);
        };
    }
}
