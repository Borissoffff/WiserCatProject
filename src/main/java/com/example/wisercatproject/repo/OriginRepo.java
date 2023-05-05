package com.example.wisercatproject.repo;

import com.example.wisercatproject.model.Origin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OriginRepo extends JpaRepository<Origin, Long> {
    Optional<Origin> findByName(String name);
}
