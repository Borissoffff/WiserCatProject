package com.example.wisercatproject.controller;

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

    @GetMapping("/")
    public ResponseEntity<Collection<User>> getUsers() {
        Collection<User> users = userService.list();
        return new ResponseEntity<>(users, OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable("id") Long id) {
        User user = userService.get(id);
        return new ResponseEntity<>(user, OK);
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
