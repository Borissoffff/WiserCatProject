package com.example.wisercatproject.repo;

import com.example.wisercatproject.model.FurColor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FurColorRepo extends JpaRepository<FurColor, Long> {
    Optional<FurColor> findByName(String name);
}
