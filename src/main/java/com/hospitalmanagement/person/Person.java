package com.hospitalmanagement.person;

import com.hospitalmanagement.person.address.Address;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;
import java.time.LocalDate;
import java.time.Period;

@Getter
@Setter
@NoArgsConstructor
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

    @Transient
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
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public Integer getAge() {
        return Period.between(this.dob, LocalDate.now()).getYears();
    }
}
