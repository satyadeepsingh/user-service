package com.userservice.demo.commands;

import com.userservice.demo.domains.model.Address;
import com.userservice.demo.domains.model.Contact;
import lombok.Data;

import java.util.Set;

@Data
public class UpdateUserCommand {

    private String userId;
    private Set<Address> addresses;
    private Set<Contact> contacts;

}