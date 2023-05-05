package com.example.wisercatproject.controller;

import com.example.wisercatproject.model.PetType;
import com.example.wisercatproject.service.implementation.PetTypeServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

import static org.springframework.http.HttpStatus.OK;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/petTypes")
public class PetTypeController {

    private final PetTypeServiceImpl petTypeService;

    @GetMapping("/")
    public ResponseEntity<Collection<PetType>> getPetTypes() {
        Collection<PetType> petTypes = petTypeService.list();
        return new ResponseEntity<>(petTypes, OK);
    }
}
