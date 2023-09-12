package com.dresen.agePers.poste;

import com.dresen.agePers.poste.enums.Rang;
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
