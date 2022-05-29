package com.userservice.demo.queries;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class ContactByTypeQuery {

    private String userId;
    private String contactType;

}
