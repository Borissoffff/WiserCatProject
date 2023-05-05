package com.example.wisercatproject.service.implementation;

import com.example.wisercatproject.model.FurColor;
import com.example.wisercatproject.repo.FurColorRepo;
import com.example.wisercatproject.service.FurColorService;
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
public class FurColorServiceImpl implements FurColorService {

    private final FurColorRepo furColorRepo;

    @Override
    public Collection<FurColor> list() {
        return furColorRepo.findAll();
    }

    @Override
    public FurColor getByName(String name) {
        return furColorRepo.findByName(name)
                .orElseThrow(() -> new EntityNotFoundException("Fur color not found with name: " + name));
    }
}