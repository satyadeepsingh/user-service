package com.userservice.demo.queries.apis;

import com.userservice.demo.domains.model.Address;
import com.userservice.demo.domains.model.Contact;
import com.userservice.demo.queries.AddressByRegionQuery;
import com.userservice.demo.queries.ContactByTypeQuery;
import com.userservice.demo.queries.projections.UserProjection;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/v1/user")
@RequiredArgsConstructor
public class UserQueryController {

    private final UserProjection userProjection;

    @GetMapping("/addresses")
    public Flux<Address> getUserAddressByRegion(AddressByRegionQuery query) {
        return userProjection.handle(query);
    }

    @GetMapping("/contacts")
    public Flux<Contact> getUserContactByType(ContactByTypeQuery query) {
        return userProjection.handle(query);
    }
}
