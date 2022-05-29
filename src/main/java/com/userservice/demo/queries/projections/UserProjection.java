package com.userservice.demo.queries.projections;

import com.userservice.demo.domains.model.Address;
import com.userservice.demo.domains.model.Contact;
import com.userservice.demo.domains.model.UserAddress;
import com.userservice.demo.domains.model.UserContact;
import com.userservice.demo.queries.AddressByRegionQuery;
import com.userservice.demo.queries.ContactByTypeQuery;
import com.userservice.demo.queries.repositories.UserReadRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * Projection/Projector:
 * Projection is another microservice design pattern which greatly benefits CQRS.
 * Projection essentially means representing domain objects in different shapes and structures.
 */
@RequiredArgsConstructor
@Service
public class UserProjection {

    private final UserReadRepository readRepository;

    public Set<Contact> handle(ContactByTypeQuery query) {
        UserContact userContact = readRepository.getUserContact(query.getUserId());
        return userContact.getContactByType()
                .get(query.getContactType());
    }

    public Set<Address> handle(AddressByRegionQuery query) {
        UserAddress userAddress = readRepository.getUserAddress(query.getUserId());
        return userAddress.getAddressByRegion()
                .get(query.getState());
    }

}
