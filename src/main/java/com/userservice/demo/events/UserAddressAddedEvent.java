package com.userservice.demo.events;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;


@EqualsAndHashCode(callSuper = true)
public class UserAddressAddedEvent extends UserAddressEvent {

    public UserAddressAddedEvent(String city, String state, String postCode) {
        super(city, state, postCode);
    }
}
