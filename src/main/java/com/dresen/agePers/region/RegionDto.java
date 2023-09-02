package com.dresen.agePers.region;


import com.dresen.agePers.departement.Departement;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

public record RegionDto(
        Long id,
        @NotBlank
        String nom,
        @NotBlank
        String code,
        List<Departement> departements
) {

}
