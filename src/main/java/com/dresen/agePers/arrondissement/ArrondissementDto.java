package com.dresen.agePers.arrondissement;


import com.dresen.agePers.departement.Departement;
import jakarta.validation.constraints.NotBlank;

public record ArrondissementDto(

        Long id,
        @NotBlank
        String nom,
        Departement departement
) {

}
