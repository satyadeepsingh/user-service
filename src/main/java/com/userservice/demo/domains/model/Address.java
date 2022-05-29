package com.userservice.demo.domains.model;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Address {

    private String city;
    private String state;
    private String postcode;
}
