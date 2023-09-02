package com.dresen.agePers.etablissement;

import com.dresen.agePers.affectation.Affectation;
import com.dresen.agePers.arrondissement.Arrondissement;
import com.dresen.agePers.departement.Departement;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


public record EtablissementDto(
        Long id,
        @NotBlank
        String nom,
        @NotNull
        Categorie categorie,
        @NotNull
        OrdreEnseignement ordreEnseignement,
        @NotNull
        SousSysteme sousSysteme,
        Departement departement,
        Arrondissement arrondissement,
        Affectation affectation
) {

}
