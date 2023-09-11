package com.dresen.agePers.poste;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record PosteDto(
        Long id,
        @NotBlank
        String titre,
        @NotNull
        Rang rang
) {

}
