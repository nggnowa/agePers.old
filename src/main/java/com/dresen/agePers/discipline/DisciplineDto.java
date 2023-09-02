package com.dresen.agePers.discipline;


import com.dresen.agePers.formation.Formation;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DisciplineDto(
        Long id,
        @NotBlank
        String nom,
        @NotNull
        Formation formation
) {

}
