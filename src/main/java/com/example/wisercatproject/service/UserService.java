package com.example.wisercatproject.service;

import com.example.wisercatproject.model.Pet;
import com.example.wisercatproject.model.User;

import java.util.Collection;
import java.util.Optional;

public interface UserService {
    User create(User user);
    Collection<User> list();
    User get(Long id);
    Boolean delete(Long id);
    User findByUsernameAndPassword(String username, String password);
}
