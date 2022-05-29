package com.userservice.demo.commands;

import lombok.Data;

@Data
public class CreateUserCommand {

    private String userId;
    private String firstName;
    private String lastName;

}
