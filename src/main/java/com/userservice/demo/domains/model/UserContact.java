package com.userservice.demo.domains.model;

import lombok.Data;
import lombok.ToString;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Data
@ToString
public class UserContact {

    private Map<String, Set<String>> contactByType = new HashMap<>();
}
