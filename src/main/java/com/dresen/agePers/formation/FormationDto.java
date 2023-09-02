package com.dresen.agePers.formation;


import com.dresen.agePers.discipline.Discipline;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

public record FormationDto(
        Long id,
        @NotBlank
        String nom,
        List<Discipline> disciplines
) {

}
