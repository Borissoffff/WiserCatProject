package com.example.wisercatproject.controller;

import com.example.wisercatproject.dto.UserDto;
import com.example.wisercatproject.mapper.UserMapper;
import com.example.wisercatproject.model.User;
import com.example.wisercatproject.service.implementation.UserServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserServiceImpl userService;
    private final UserMapper userMapper;

    @GetMapping("/")
    public ResponseEntity<Collection<User>> getUsers() {
        Collection<User> users = userService.list();
        return new ResponseEntity<>(users, OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUser(@PathVariable("id") Long id) {
        User user = userService.get(id);
        UserDto userDto = userMapper.toDto(user);
        return new ResponseEntity<>(userDto, OK);
    }

    @PostMapping("/")
    public ResponseEntity<User> saveUser(@Valid @RequestBody User user) {
        User newUser = userService.create(user);
        return new ResponseEntity<>(newUser, CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteUser(@PathVariable("id") Long id) {
        Boolean deleted = userService.delete(id);
        return new ResponseEntity<>(deleted, OK);
    }
}
