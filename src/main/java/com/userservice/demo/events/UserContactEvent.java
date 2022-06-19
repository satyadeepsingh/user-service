package com.userservice.demo.events;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class UserContactEvent extends Event{

    private String contactType;
    private String contactDetails;
}
