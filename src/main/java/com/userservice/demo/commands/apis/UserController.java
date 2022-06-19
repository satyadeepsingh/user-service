package com.userservice.demo.commands.apis;

import com.userservice.demo.commands.CreateUserCommand;
import com.userservice.demo.commands.UpdateUserCommand;
import com.userservice.demo.commands.aggregates.UserAggregate;
import com.userservice.demo.projectors.UserProjector;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/user")
public class UserController {

    private final UserAggregate userAggregate;

    private final UserProjector userProjector;
    
    @PostMapping
    public void addUser(@RequestBody CreateUserCommand createUserCommand) {
        userProjector.project(createUserCommand.getUserId(), userAggregate.handleCreateUserCommand(createUserCommand));
    }

    @PutMapping
    public void updateUser(@RequestBody UpdateUserCommand updateUserCommand) {
        userProjector.project(updateUserCommand.getUserId(), userAggregate.handleUpdateUserCommand(updateUserCommand));

    }
}
