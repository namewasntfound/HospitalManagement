package com.hospitalmanagement.patientmanagement;

import com.hospitalmanagement.diagnosismanagement.Diagnosis;
import com.hospitalmanagement.person.Person;
import com.hospitalmanagement.person.address.Address;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

import static javax.persistence.GenerationType.SEQUENCE;

@NoArgsConstructor
@Entity
public class Patient extends Person {

    @Getter
    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "patient_sequence")
    @SequenceGenerator(name = "patient_sequence", sequenceName = "patient_sequence", allocationSize = 1)
    private Long id;
    @Getter
    @ManyToMany
    @JoinColumn(name = "diagnosis_id")
    private Map<LocalDateTime, Diagnosis> diagnoses;

    public Patient(String UCN, String firstName, String middleName, String lastName, LocalDate dob, Address address, String phoneNumber, Map<LocalDateTime, Diagnosis> diagnoses) {
        super(UCN, firstName, middleName, lastName, dob, address, phoneNumber);
        this.diagnoses = new LinkedHashMap<>();
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + getId() + ", " +
                "UCN = " + getUCN() + ", " +
                "firstName = " + getFirstName() + ", " +
                "middleName = " + getMiddleName() + ", " +
                "lastName = " + getLastName() + ", " +
                "dob = " + getDob() + ", " +
                "age = " + getAge() + ", " +
                "address = " + getAddress() + ", " +
                "phoneNumber = " + getPhoneNumber() + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Patient patient = (Patient) o;
        return id != null && Objects.equals(id, patient.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
