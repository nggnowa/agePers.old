package com.dresen.agePers.enseignant;


import com.dresen.agePers.arrondissement.Arrondissement;
import com.dresen.agePers.departement.Departement;
import com.dresen.agePers.diplome.Diplome;
import com.dresen.agePers.discipline.Discipline;
import com.dresen.agePers.enseignant.enums.*;
import com.dresen.agePers.ethnie.Ethnie;
import com.dresen.agePers.formation.Formation;
import com.dresen.agePers.grade.Grade;
import com.dresen.agePers.region.Region;
import jakarta.validation.constraints.*;

import java.time.LocalDate;
import java.util.List;

public record EnseignantDto(
        Long id,
        @NotBlank
        String nom,
        @NotNull
        Sexe sexe,
        @NotNull
        @Past
        LocalDate dateNaissance,
        @NotNull
        String lieuNaissance,
        @NotBlank
        String matricule,
        @NotNull
        Categorie categorie,
        @NotNull
        Statut statut,
        @NotNull
        @Past
        LocalDate dateEntreeService,
        Integer anciennete,
        LocalDate dateRetraite,
        @NotNull
        Langue langueTravail,
        @NotNull
        Presence presence,
        @Pattern(regexp = "^6[2-9][0-9]{7}$")
        String telephone,
        @Email
        String email,
        @NotNull
        StatutMedical statutMedical,
        @NotNull
        StatutMatrimonial statutMatrimonial,
        Integer nombreEnfant,
        @NotNull
        Region regionOrigine,
        @NotNull
        Departement departementOrigine,
        @NotNull
        Arrondissement arrondissementOrigine,
        @NotNull
        Ethnie ethnie,
        @NotNull
        Grade grade,
        Formation formation,
        Discipline discipline,
        List<Diplome> diplomes

) {

}
