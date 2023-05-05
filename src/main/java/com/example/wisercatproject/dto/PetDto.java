package com.example.wisercatproject.dto;


import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PetDto {
    private Long id;

    @NotBlank(message = "Name is mandatory")
    private String name;

    @NotBlank(message = "Code is mandatory")
    private String code;

    @NotBlank(message = "Pet type is mandatory")
    private String petType;

    @NotBlank(message = "Fur color is mandatory")
    private String furColor;

    @NotBlank(message = "Origin is mandatory")
    private String origin;

    private Long userId;
}