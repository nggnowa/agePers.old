package com.dresen.agePers.affectation;

import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class AffectationDtoMapper implements Function<Affectation, AffectationDto> {

    @Override
    public AffectationDto apply(Affectation affectation) {

        return new AffectationDto(
                affectation.getId(),
                affectation.getReferenceAffectation(),
                affectation.getDateAffectation(),
                affectation.getDatePriseService(),
                affectation.getDelegation(),
                affectation.getEnseignant(),
                affectation.getPoste(),
                affectation.getEtablissement(),
                affectation.getAnciennete()
        );
    }
}
