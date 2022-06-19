package com.userservice.demo.events.service;

import com.userservice.demo.domains.model.Address;
import com.userservice.demo.domains.model.Contact;
import com.userservice.demo.domains.model.User;
import com.userservice.demo.events.*;
import com.userservice.demo.events.repository.EventStore;

import java.util.List;
import java.util.UUID;

public class UserUtility {

    public static User recreateUserState(EventStore store, String userId) {
        User user = null;

        List<Event> events = store.getEvents(userId);
        for (Event event : events) {
            if (event instanceof UserCreatedEvent e) {
                user = new User(UUID.randomUUID()
                        .toString(), e.getFirstName(), e.getLastName());
            }
            if (event instanceof UserAddressAddedEvent e) {
                Address address = new Address(e.getCity(), e.getState(), e.getPostCode());
                if (user != null)
                    user.getAddresses()
                            .add(address);
            }
            if (event instanceof UserAddressRemovedEvent e) {
                Address address = new Address(e.getCity(), e.getState(), e.getPostCode());
                if (user != null)
                    user.getAddresses()
                            .remove(address);
            }
            if (event instanceof UserContactAddedEvent e) {
                Contact contact = new Contact(e.getContactType(), e.getContactDetails());
                if (user != null)
                    user.getContacts()
                            .add(contact);
            }
            if (event instanceof UserContactRemovedEvent e) {
                Contact contact = new Contact(e.getContactType(), e.getContactDetails());
                if (user != null)
                    user.getContacts()
                            .remove(contact);
            }
        }

        return user;
    }
}
