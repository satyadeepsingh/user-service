package com.userservice.demo.domains.model;

import lombok.Data;
import lombok.ToString;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Data
@ToString
public class UserAddress {

    private Map<String, Set<Address>> addressByRegion = new HashMap<>();
}
