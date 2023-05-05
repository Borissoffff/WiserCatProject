package com.example.wisercatproject.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(min = 1, max = 128)
    private String name;

    @Size(min = 1, max = 10)
    @NotBlank
    private String code;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "pet_type_id")
    private PetType type;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "fur_color_id")
    private FurColor color;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "origin_id")
    private Origin origin;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    @JoinColumn(name = "user_id")
    private User user;

    public Pet(String name, String code, PetType type, FurColor color, Origin origin, User user) {
        this.name = name;
        this.code = code;
        this.type = type;
        this.color = color;
        this.origin = origin;
        this.user = user;
    }
}