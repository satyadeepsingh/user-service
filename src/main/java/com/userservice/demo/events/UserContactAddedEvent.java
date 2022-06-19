package com.userservice.demo.events;

public class UserContactAddedEvent extends UserContactEvent{
    public UserContactAddedEvent(String contactType, String contactDetails) {
        super(contactType, contactDetails);
    }
}
