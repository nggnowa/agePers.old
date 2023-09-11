package com.dresen.agePers.discipline;


import com.dresen.agePers.formation.Formation;
import jakarta.validation.constraints.NotBlank;

public record DisciplineDto(
        Long id,
        @NotBlank
        String nom,
        Formation formation
) {

}
