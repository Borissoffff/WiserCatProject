package com.example.wisercatproject.service;

import com.example.wisercatproject.model.PetType;

import java.util.Collection;

public interface PetTypeService {
    Collection<PetType> list();
    PetType getByName(String name);
}
