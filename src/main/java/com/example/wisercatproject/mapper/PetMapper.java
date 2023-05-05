package com.example.wisercatproject.mapper;

import com.example.wisercatproject.dto.PetDto;
import com.example.wisercatproject.model.*;
import com.example.wisercatproject.service.implementation.FurColorServiceImpl;
import com.example.wisercatproject.service.implementation.OriginServiceImpl;
import com.example.wisercatproject.service.implementation.PetTypeServiceImpl;
import com.example.wisercatproject.service.implementation.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class PetMapper {

    private final PetTypeServiceImpl petTypeService;
    private final FurColorServiceImpl furColorService;
    private final OriginServiceImpl originService;
    private final UserServiceImpl userService;

    public PetDto toDto(Pet pet) {

        return new PetDto(
                pet.getId(),
                pet.getName(),
                pet.getCode(),
                pet.getType().getName(),
                pet.getColor().getName(),
                pet.getOrigin().getName(),
                pet.getUser().getId()
        );
    }

    public Pet toDomain(PetDto petDto) {

        FurColor color = furColorService.getByName(petDto.getFurColor());
        PetType type = petTypeService.getByName(petDto.getPetType());
        Origin origin = originService.getByName(petDto.getOrigin());
        User user = userService.get(petDto.getUserId());

        Pet pet = new Pet(
                petDto.getName(),
                petDto.getCode(),
                type,
                color,
                origin,
                user
        );

        if (petDto.getId() != null) {
            pet.setId(petDto.getId());
        }
        return pet;
    }
}
