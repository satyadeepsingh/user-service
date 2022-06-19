package com.userservice.demo.events;

import lombok.ToString;

import java.time.LocalDateTime;
import java.util.UUID;

@ToString
public class Event {

    public final UUID id = UUID.randomUUID();

    public final LocalDateTime created = LocalDateTime.now();
}
