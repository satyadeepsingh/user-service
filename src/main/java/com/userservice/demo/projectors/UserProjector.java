package com.userservice.demo.projectors;

import com.userservice.demo.domains.model.*;
import com.userservice.demo.queries.repositories.UserReadRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Component
@RequiredArgsConstructor
@Slf4j
public class UserProjector {

    private final UserReadRepository readRepository;

    public void project(User user) {
        log.info("projecting user: {}", user);
        UserContact userContact = Optional.ofNullable(readRepository.getUserContact(user.getUserid()))
                .orElse(new UserContact());
        user.getContacts()
                .forEach(contact -> addUserContact(userContact, contact));
        readRepository.addUserContact(user.getUserid(), userContact);

        UserAddress userAddress = Optional.ofNullable(readRepository.getUserAddress(user.getUserid()))
                .orElse(new UserAddress());
        user.getAddresses().forEach(address -> addUserAddress(userAddress, address));
        readRepository.addUserAddress(user.getUserid(), userAddress);
    }

    private void addUserAddress(UserAddress userAddress, Address address) {
        if (userAddress.getAddressByRegion().containsKey(address.getState())) {
            Set<Address> addresses = Optional.ofNullable(userAddress.getAddressByRegion().get(address.getState()))
                    .orElse(new HashSet<>());
            addresses.add(address);
            userAddress.getAddressByRegion().put(address.getState(), addresses);
            return;
        }
        Set<Address> addresses = new HashSet<>();
        addresses.add(address);
        userAddress.getAddressByRegion().put(address.getState(), addresses);
    }

    private void addUserContact(UserContact userContact, Contact contact) {
        if (userContact.getContactByType().containsKey(contact.getType())) {
            Set<Contact> contactSet = Optional.ofNullable(userContact.getContactByType()
                            .get(contact.getType()))
                    .orElse(new HashSet<>());
            contactSet.add(contact);
            userContact.getContactByType().put(contact.getType(), contactSet);
            return;
        }
        Set<Contact> contactSet = new HashSet<>();
        contactSet.add(contact);
        userContact.getContactByType().put(contact.getType(), contactSet);
    }

}
