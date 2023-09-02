package com.dresen.agePers.grade;

import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class GradeDtoMapper implements Function<Grade, GradeDto> {

    @Override
    public GradeDto apply(Grade grade) {

        return new GradeDto(
                grade.getId(),
                grade.getGrade(),
                grade.getClasse(),
                grade.getEchelon(),
                grade.getIndice()
        );
    }
}
