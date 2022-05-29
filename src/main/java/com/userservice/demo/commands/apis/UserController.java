package com.userservice.demo.commands.apis;

import com.userservice.demo.commands.CreateUserCommand;
import com.userservice.demo.commands.UpdateUserCommand;
import com.userservice.demo.commands.aggregates.UserAggregate;
import com.userservice.demo.domains.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/user")
public class UserController {

    private final UserAggregate userAggregate;

    @PostMapping
    public void addUser(@RequestBody CreateUserCommand createUserCommand) {
        userAggregate.handleCreateUserCommand(createUserCommand);
    }

    @PutMapping
    public void updateUser(@RequestBody UpdateUserCommand updateUserCommand) {
        userAggregate.handleUpdateUserCommand(updateUserCommand);
    }
}
