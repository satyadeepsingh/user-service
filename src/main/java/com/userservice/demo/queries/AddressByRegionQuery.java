package com.userservice.demo.queries;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class AddressByRegionQuery {

    private String userId;
    private String state;

}
