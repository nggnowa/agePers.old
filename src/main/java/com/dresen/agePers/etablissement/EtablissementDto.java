package com.dresen.agePers.etablissement;

import com.dresen.agePers.arrondissement.Arrondissement;
import com.dresen.agePers.etablissement.enums.Categorie;
import com.dresen.agePers.etablissement.enums.OrdreEnseignement;
import com.dresen.agePers.etablissement.enums.SousSysteme;
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
        @NotNull
        Arrondissement arrondissement
) {

}
