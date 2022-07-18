package com.hospitalmanagement.patient.person;

import com.hospitalmanagement.patient.address.Address;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@MappedSuperclass
public class Person {
    @Column(unique = true, nullable = false)
    private String UCN; // Unique citizen number
    @Column(nullable = false)
    private String firstName;

    private String middleName;
    @Column(nullable = false)
    private String lastName;
    @Column(nullable = false)
    private LocalDate dob;
    @Column(nullable = false)
    private Integer age;
    @Embedded
    @Column(nullable = false)
    private Address address;

    private String phoneNumber;

    public Person(String UCN, String firstName, String middleName, String lastName, LocalDate dob, Address address, String phoneNumber) {
        this.UCN = UCN;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.dob = dob;
        this.setAge(dob);
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public void setAge(LocalDate dob) {
        this.age = Period.between(dob, LocalDate.now()).getYears();
    }
}
