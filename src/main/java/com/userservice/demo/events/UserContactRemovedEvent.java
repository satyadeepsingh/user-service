package com.userservice.demo.events;

public class UserContactRemovedEvent extends UserContactEvent{
    public UserContactRemovedEvent(String contactType, String contactDetails) {
        super(contactType, contactDetails);
    }
}
