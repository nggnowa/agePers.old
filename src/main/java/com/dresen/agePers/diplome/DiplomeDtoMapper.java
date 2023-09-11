package com.dresen.agePers.diplome;

import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class DiplomeDtoMapper implements Function<Diplome, DiplomeDto> {

    @Override
    public DiplomeDto apply(Diplome diplome) {

        return new DiplomeDto(
                diplome.getId(),
                diplome.getNom(),
                diplome.getCode()
        );
    }

}
