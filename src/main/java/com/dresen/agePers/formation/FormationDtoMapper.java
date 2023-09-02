package com.dresen.agePers.formation;

import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class FormationDtoMapper implements Function<Formation, FormationDto> {

    @Override
    public FormationDto apply(Formation formation) {

        return new FormationDto(
                formation.getId(),
                formation.getNom(),
                formation.getDisciplines()
        );
    }

}
