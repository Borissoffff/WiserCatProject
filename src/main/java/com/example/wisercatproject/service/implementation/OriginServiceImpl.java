package com.example.wisercatproject.service.implementation;

import com.example.wisercatproject.model.Origin;
import com.example.wisercatproject.repo.OriginRepo;
import com.example.wisercatproject.service.OriginService;
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
public class OriginServiceImpl implements OriginService {

    private final OriginRepo originRepo;

    @Override
    public Collection<Origin> list() {
        return originRepo.findAll();
    }

    @Override
    public Origin getByName(String name) {
        return originRepo.findByName(name)
                .orElseThrow(() -> new EntityNotFoundException("Origin not found with name: " + name));
    }
}
