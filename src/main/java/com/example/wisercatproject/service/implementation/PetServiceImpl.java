package com.example.wisercatproject.service.implementation;

import com.example.wisercatproject.model.Pet;
import com.example.wisercatproject.model.User;
import com.example.wisercatproject.repo.PetRepo;
import com.example.wisercatproject.repo.UserRepo;
import com.example.wisercatproject.service.PetService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collection;

@RequiredArgsConstructor
@Service
@Transactional
@Slf4j
public class PetServiceImpl implements PetService {

    private final PetRepo petRepo;

    @Override
    public Pet create(Pet pet) {
        return petRepo.save(pet);
    }

    @Override
    public Collection<Pet> list() {
        return petRepo.findAll();
    }

    @Override
    public Pet get(Long id) {
        return petRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Pet not found with id: " + id));
    }

    // Spring data JPA knows if we pass entity with id, it means updating
    @Override
    public Pet update(Pet pet) {
        return petRepo.save(pet);
    }

    @Override
    public void delete(Long id) {
        petRepo.deleteById(id);
    }

    @Override
    public Collection<Pet> getPetsByUserId(Long id) {
        return petRepo.findByUserId(id);
    }
}
