package com.userservice.demo.domains.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
public class Address {

    private String city;
    private String state;
    private String postcode;
}
