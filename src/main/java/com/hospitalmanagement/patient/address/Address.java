package com.hospitalmanagement.patient.address;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Embeddable;

@Getter
@Setter
@NoArgsConstructor
@Embeddable
public class Address {
    private String country;
    private String city;
    private String state;
    private String streetName;
    private Integer postalCode;

    public Address(String country, String city, String state, String streetName, Integer postalCode) {
        this.country = country;
        this.city = city;
        this.state = state;
        this.streetName = streetName;
        this.postalCode = postalCode;
    }
}
