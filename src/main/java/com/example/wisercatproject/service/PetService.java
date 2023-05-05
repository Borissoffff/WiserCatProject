package com.example.wisercatproject.service;

import com.example.wisercatproject.model.Pet;

import java.util.Collection;

public interface PetService {
    Pet create(Pet pet);
    Collection<Pet> list();
    Pet get(Long id);
    Pet update(Pet pet);
    void delete(Long id);
    Collection<Pet> getPetsByUserId(Long id);
}
