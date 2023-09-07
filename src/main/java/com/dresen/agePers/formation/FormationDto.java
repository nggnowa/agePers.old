package com.dresen.agePers.formation;


import jakarta.validation.constraints.NotBlank;

public record FormationDto(
        Long id,
        @NotBlank
        String nom
) {

}
