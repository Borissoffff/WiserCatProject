package com.example.wisercatproject.service.implementation;

import com.example.wisercatproject.model.PetType;
import com.example.wisercatproject.repo.PetTypeRepo;
import com.example.wisercatproject.service.PetTypeService;
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
public class PetTypeServiceImpl implements PetTypeService {

    private final PetTypeRepo petTypeRepo;

    @Override
    public Collection<PetType> list() {
        return petTypeRepo.findAll();
    }

    @Override
    public PetType getByName(String name) {
        return petTypeRepo.findByName(name)
                .orElseThrow(() -> new EntityNotFoundException("Pet type not found with name: " + name));
    }
}
