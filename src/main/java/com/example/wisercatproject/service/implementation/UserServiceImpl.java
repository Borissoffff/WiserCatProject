package com.example.wisercatproject.service.implementation;

import com.example.wisercatproject.model.User;
import com.example.wisercatproject.repo.UserRepo;
import com.example.wisercatproject.service.UserService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;

@RequiredArgsConstructor
@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;

    @Override
    public User create(User user) {
        return userRepo.save(user);
    }

    @Override
    public Collection<User> list() {
        return userRepo.findAll();
    }

    @Override
    public User get(Long id) {
        return userRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + id));
    }

    @Override
    public Boolean delete(Long id) {
        userRepo.deleteById(id);
        return true;
    }

    @Override
    public User findByUsernameAndPassword(String username, String password) {
        return userRepo.findByUsernameAndPassword(username, password)
                .orElseThrow(() ->
                        new EntityNotFoundException("User not found with the provided username and password"));
    }
}
