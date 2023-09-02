package com.dresen.agePers.arrondissement;

import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class ArrondissementDtoMapper implements Function<Arrondissement, ArrondissementDto> {

    @Override
    public ArrondissementDto apply(Arrondissement arrondissement) {

        return new ArrondissementDto(
                arrondissement.getId(),
                arrondissement.getNom(),
                arrondissement.getDepartement()
        );
    }

}
