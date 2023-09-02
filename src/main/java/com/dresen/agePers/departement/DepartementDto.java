package com.dresen.agePers.departement;


import com.dresen.agePers.arrondissement.Arrondissement;
import com.dresen.agePers.region.Region;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

public record DepartementDto(
        Long id,
        @NotBlank
        String nom,
        Region region,
        List<Arrondissement> arrondissements
) {

}
