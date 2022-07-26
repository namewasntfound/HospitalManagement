package com.hospitalmanagement.patientmanagement;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
    @Query("SELECT p FROM Patient p WHERE p.UCN = ?1")
    Optional<Patient> findPatientByUCN(String UCN);

    @Query("SELECT p FROM Patient p WHERE p.firstName =?1 and p.lastName = ?2")
    Optional<Patient> findPatientByFirstAndLastName(String firstName, String lastName);

}
