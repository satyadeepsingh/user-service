package com.userservice.demo.events;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
public class UserAddressRemovedEvent extends UserAddressEvent{

    public UserAddressRemovedEvent(String city, String state, String postCode) {
        super(city, state, postCode);
    }
}
