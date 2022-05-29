package com.userservice.demo.commands.aggregates;

import com.userservice.demo.commands.CreateUserCommand;
import com.userservice.demo.commands.UpdateUserCommand;
import com.userservice.demo.domains.model.User;
import com.userservice.demo.repository.UserWriteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserAggregate {

    private final UserWriteRepository writeRepository;

    public User handleCreateUserCommand(CreateUserCommand command) {
        User user = new User(command.getUserId(), command.getFirstName(), command.getLastName());
        writeRepository.addUser(user.getUserid(), user);
        return user;
    }

    public User handleUpdateUserCommand(UpdateUserCommand command) {
        User user = writeRepository.getUser(command.getUserId());
        user.setAddresses(command.getAddresses());
        user.setContacts(command.getContacts());
        writeRepository.addUser(user.getUserid(), user);
        return user;
    }


}
