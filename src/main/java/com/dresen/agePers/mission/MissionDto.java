package com.dresen.agePers.mission;

import com.dresen.agePers.enseignant.Enseignant;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record MissionDto(
        Long id,
        @NotBlank
        String objet,
        @NotNull
        LocalDate dateDepart,
        @Future
        LocalDate dateRetour,
        Integer duree, //en nombre de jours
        @NotNull
        Enseignant enseignant
) {

}
