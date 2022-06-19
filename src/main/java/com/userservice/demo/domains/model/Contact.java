package com.userservice.demo.domains.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
public class Contact {

    private String type;
    private String detail;
}
