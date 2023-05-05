package com.example.wisercatproject.controller;

import com.example.wisercatproject.dto.PetDto;
import com.example.wisercatproject.mapper.PetMapper;
import com.example.wisercatproject.model.Pet;
import com.example.wisercatproject.service.implementation.PetServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

import static org.springframework.http.HttpStatus.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/pets")
public class PetController {

    private final PetServiceImpl petService;
    private final PetMapper petMapper;

    @GetMapping("/")
    public ResponseEntity<Collection<PetDto>> getPets() {
        Collection<PetDto> petDtos = petService.list()
                .stream()
                .map(petMapper::toDto)
                .toList();

        return new ResponseEntity<>(petDtos, OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PetDto> getPet(@PathVariable("id") Long id) {
        Pet pet = petService.get(id);
        PetDto petDto = petMapper.toDto(pet);
        return new ResponseEntity<>(petDto, OK);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<Collection<PetDto>> getPetsByUserId(@PathVariable("id") Long id) {

        Collection<PetDto> petDtos = petService.getPetsByUserId(id)
                .stream()
                .map(petMapper::toDto)
                .toList();

        return new ResponseEntity<>(petDtos, OK);
    }

    @PostMapping("/")
    public ResponseEntity<Pet> savePet(@Valid @RequestBody PetDto petDto) {
        Pet pet = petMapper.toDomain(petDto);
        petService.create(pet);
        return new ResponseEntity<>(pet, CREATED);
    }

    @PutMapping("/")
    public ResponseEntity<Pet> updatePet(@Valid @RequestBody PetDto petDto) {
        Pet pet = petMapper.toDomain(petDto);
        petService.update(pet);
        return new ResponseEntity<>(pet, OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePet(@PathVariable("id") Long id) {
        petService.delete(id);
        return new ResponseEntity<>(OK);
    }
}