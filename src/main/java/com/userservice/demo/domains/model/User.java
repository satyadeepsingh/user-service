package com.userservice.demo.domains.model;

import lombok.Data;
import lombok.ToString;

import java.util.Set;

@Data
@ToString
public class User {

    private String userid;
    private String firstName;
    private String lastName;
    private Set<Contact> contacts;
    private Set<Address> addresses;

    public User(String userid, String firstName, String lastName) {
        this.userid = userid;
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
