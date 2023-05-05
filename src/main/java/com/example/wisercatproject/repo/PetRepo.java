package com.example.wisercatproject.repo;

import com.example.wisercatproject.model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PetRepo extends JpaRepository<Pet, Long> {
    List<Pet> findByUserId(Long userId);
}
