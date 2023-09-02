package com.dresen.agePers.affectation;

import com.dresen.agePers.enseignant.Enseignant;
import com.dresen.agePers.etablissement.Etablissement;
import com.dresen.agePers.poste.Poste;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record AffectationDto(
        Long id,
        @NotBlank
        String referenceAffectation,
        @NotNull
        LocalDate dateAffectation,
        @NotNull
        LocalDate datePriseService,
        @NotNull
        DelegationEN delegation,
        @NotNull
        Enseignant enseignant,
        @NotNull
        Poste poste,
        @NotNull
        Etablissement etablissement,
        Integer anciennete
) {

}
