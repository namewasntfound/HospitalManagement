package com.hospitalmanagement.diagnosismanagement;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Diagnosis {
    @Id
    @Column(unique = true, nullable = false)
    private String id;
    private String name;

    public Diagnosis(String name) {
        this.name = name;
    }
}
