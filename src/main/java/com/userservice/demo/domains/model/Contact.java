package com.userservice.demo.domains.model;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Contact {

    private String type;
    private String detail;
}
