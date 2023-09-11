package com.dresen.agePers.diplome;

import jakarta.validation.constraints.NotBlank;

public record DiplomeDto(
        Long id,
        @NotBlank
        String nom,
        @NotBlank
        String code
) {

}
