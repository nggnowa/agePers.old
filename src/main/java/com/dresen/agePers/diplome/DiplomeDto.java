package com.dresen.agePers.diplome;

import com.dresen.agePers.enseignant.Enseignant;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DiplomeDto(
        Long id,
        @NotBlank
        String nom,
        @NotBlank
        String code,
        @NotNull
        Cycle cycle,
        Enseignant enseignant
) {

}
