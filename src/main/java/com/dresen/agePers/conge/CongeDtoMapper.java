package com.dresen.agePers.conge;

import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class CongeDtoMapper implements Function<Conge, CongeDto> {

    @Override
    public CongeDto apply(Conge conge) {

        return new CongeDto(
                conge.getId(),
                conge.getDateDepart(),
                conge.getDateRetour(),
                conge.getDuree(),
                conge.getEnseignants()
        );
    }
}
