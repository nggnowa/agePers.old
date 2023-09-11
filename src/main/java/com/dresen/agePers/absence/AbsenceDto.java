package com.dresen.agePers.absence;

import com.dresen.agePers.enseignant.Enseignant;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record AbsenceDto(
        Long id,
        @NotBlank
        Nature nature,
        String motif,
        @NotNull
        LocalDate dateDepart,
        @Future
        @NotNull
        LocalDate dateRetour,
        Integer duree, //en nombre de jours
        @NotNull
        Enseignant enseignant
) {

}
