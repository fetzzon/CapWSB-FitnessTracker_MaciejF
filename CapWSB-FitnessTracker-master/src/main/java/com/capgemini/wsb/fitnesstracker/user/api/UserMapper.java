package com.capgemini.wsb.fitnesstracker.user.api;

import com.capgemini.wsb.fitnesstracker.user.api.User;
import com.capgemini.wsb.fitnesstracker.user.api.UserDto;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserDto toDto(User user) {
        return new UserDto(user.getId(),
                           user.getFirstName(),
                           user.getLastName(),
                           user.getBirthdate(),
                           user.getEmail());
    }

}
