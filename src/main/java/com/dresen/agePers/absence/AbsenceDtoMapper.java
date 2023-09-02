package com.dresen.agePers.absence;

import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class AbsenceDtoMapper implements Function<Absence, AbsenceDto> {

    @Override
    public AbsenceDto apply(Absence absence) {

        return new AbsenceDto(
                absence.getId(),
                absence.getMotif(),
                absence.getDateDepart(),
                absence.getDateRetour(),
                absence.getDuree(),
                absence.getEnseignants()
        );
    }
}
