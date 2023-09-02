package com.dresen.agePers.grade;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record GradeDto(
        Long id,
        @NotNull
        IntituleGrade grade,
        @NotBlank
        String classe,
        @NotNull
        Integer echelon,
        @NotNull
        Integer indice
) {

}
