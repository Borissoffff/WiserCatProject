package com.example.wisercatproject.repo;

import com.example.wisercatproject.model.PetType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PetTypeRepo extends JpaRepository<PetType, Long> {
    Optional<PetType> findByName(String name);
}
