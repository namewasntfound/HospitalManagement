package com.hospitalmanagement.patient;


import com.hospitalmanagement.patient.person.Person;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Patient extends Person {

    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "patient_sequence")
    @SequenceGenerator(name = "patient_sequence", sequenceName = "patient_sequence", allocationSize = 1)
    @Column(nullable = false)
    private Long id;

}
