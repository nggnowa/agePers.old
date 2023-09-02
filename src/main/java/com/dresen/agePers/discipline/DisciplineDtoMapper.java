package com.dresen.agePers.discipline;

import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class DisciplineDtoMapper implements Function<Discipline, DisciplineDto> {

    @Override
    public DisciplineDto apply(Discipline discipline) {

        return new DisciplineDto(
                discipline.getId(),
                discipline.getNom(),
                discipline.getFormation()
        );
    }

}
