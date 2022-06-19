package com.userservice.demo.commands.aggregates;

import com.userservice.demo.commands.CreateUserCommand;
import com.userservice.demo.commands.UpdateUserCommand;
import com.userservice.demo.domains.model.Address;
import com.userservice.demo.domains.model.Contact;
import com.userservice.demo.domains.model.User;
import com.userservice.demo.events.*;
import com.userservice.demo.events.repository.EventStore;
import com.userservice.demo.events.service.UserUtility;
import com.userservice.demo.projectors.UserProjector;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class UserAggregate {

    private final EventStore writeRepository;

    private final UserProjector userProjector;
    
    public List<Event> handleCreateUserCommand(CreateUserCommand command) {
        UserCreatedEvent event = new UserCreatedEvent(command.getUserId(), command.getFirstName(), command.getLastName());
        writeRepository.addEvent(command.getUserId(), event);
        return List.of(event);
    }

    public List<Event> handleUpdateUserCommand(UpdateUserCommand command) {
        User user = UserUtility.recreateUserState(writeRepository, command.getUserId());
        List<Event> events = new ArrayList<>();

        List<Contact> contactsToRemove = user.getContacts()
                .stream()
                .filter(c -> !command.getContacts()
                        .contains(c)).toList();
        for (Contact contact : contactsToRemove) {
            UserContactRemovedEvent contactRemovedEvent = new UserContactRemovedEvent(contact.getType(), contact.getDetail());
            events.add(contactRemovedEvent);
            writeRepository.addEvent(command.getUserId(), contactRemovedEvent);
        }

        List<Contact> contactsToAdd = command.getContacts()
                .stream()
                .filter(c -> !user.getContacts()
                        .contains(c)).toList();
        for (Contact contact : contactsToAdd) {
            UserContactAddedEvent contactAddedEvent = new UserContactAddedEvent(contact.getType(), contact.getDetail());
            events.add(contactAddedEvent);
            writeRepository.addEvent(command.getUserId(), contactAddedEvent);
        }

        List<Address> addressesToRemove = user.getAddresses()
                .stream()
                .filter(a -> !command.getAddresses()
                        .contains(a)).toList();
        for (Address address : addressesToRemove) {
            UserAddressRemovedEvent addressRemovedEvent = new UserAddressRemovedEvent(address.getCity(), address.getState(), address.getPostcode());
            events.add(addressRemovedEvent);
            writeRepository.addEvent(command.getUserId(), addressRemovedEvent);
        }

        List<Address> addressesToAdd = command.getAddresses()
                .stream()
                .filter(a -> !user.getAddresses()
                        .contains(a)).toList();
        for (Address address : addressesToAdd) {
            UserAddressAddedEvent addressAddedEvent = new UserAddressAddedEvent(address.getCity(), address.getState(), address.getPostcode());
            events.add(addressAddedEvent);
            writeRepository.addEvent(command.getUserId(), addressAddedEvent);
        }

        userProjector.project(user.getUserid(), writeRepository.getEvents(user.getUserid()));

        return events;
    }

}
