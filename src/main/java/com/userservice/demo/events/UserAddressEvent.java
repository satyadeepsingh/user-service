package com.userservice.demo.events;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class UserAddressEvent extends Event {

    private String city;
    private String state;
    private String postCode;
}
