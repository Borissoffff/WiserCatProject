package com.example.wisercatproject.mapper;

import com.example.wisercatproject.dto.UserDto;
import com.example.wisercatproject.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserDto toDto(User user) {

        return new UserDto(
                user.getId(),
                user.getFirstName(),
                user.getLastName()
        );
    }
}
