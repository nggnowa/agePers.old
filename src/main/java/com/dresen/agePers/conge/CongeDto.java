package com.dresen.agePers.conge;

import com.dresen.agePers.enseignant.Enseignant;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.List;

public record CongeDto(
        Long id,
        @NotNull
        LocalDate dateDepart,
        @Future
        @NotNull
        LocalDate dateRetour,
        Integer duree, //en nombre de jours
        List<Enseignant> enseignants
) {

}
