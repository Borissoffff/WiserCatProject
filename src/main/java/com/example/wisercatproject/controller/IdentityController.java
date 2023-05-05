package com.example.wisercatproject.controller;

import com.example.wisercatproject.dto.Login;
import com.example.wisercatproject.dto.UserDto;
import com.example.wisercatproject.mapper.UserMapper;
import com.example.wisercatproject.model.User;
import com.example.wisercatproject.service.implementation.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.OK;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/identity")
public class IdentityController {

    private final UserServiceImpl userService;
    private final UserMapper userMapper;

    @PostMapping("/login")
    public ResponseEntity<UserDto> login(@RequestBody Login login)
    {
        User user = userService.findByUsernameAndPassword(
                login.getUsername(),
                login.getPassword());

        UserDto userDto = userMapper.toDto(user);
        return new ResponseEntity<>(userDto, OK);
    }
}
