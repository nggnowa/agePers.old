package com.dresen.agePers.departement;


import com.dresen.agePers.region.Region;
import jakarta.validation.constraints.NotBlank;

public record DepartementDto(
        Long id,
        @NotBlank
        String nom,
        Region region
) {

}
