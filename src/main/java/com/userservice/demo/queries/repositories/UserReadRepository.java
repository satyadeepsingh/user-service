package com.userservice.demo.queries.repositories;

import com.userservice.demo.domains.model.UserAddress;
import com.userservice.demo.domains.model.UserContact;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class UserReadRepository {

    private final Map<String, UserAddress> userAddress = new HashMap<>();

    private final Map<String, UserContact> userContact = new HashMap<>();

    public void addUserAddress(String id, UserAddress user) {
        userAddress.put(id, user);
    }

    public UserAddress getUserAddress(String id) {
        return userAddress.get(id);
    }

    public void addUserContact(String id, UserContact user) {
        userContact.put(id, user);
    }

    public UserContact getUserContact(String id) {
        return userContact.get(id);
    }
}
