package com.dresen.agePers.region;


import jakarta.validation.constraints.NotBlank;

public record RegionDto(
        Long id,
        @NotBlank
        String nom,
        @NotBlank
        String code
) {

}
