package com.dresen.agePers.grade;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class GradeService implements IGradeService {

    private final GradeRepository repository;
    private final GradeDtoMapper  dtoMapper;

    @Override
    public GradeDto createGrade(GradeDto gradeDto) {

        Grade saved = repository.save(
                new Grade(
                        gradeDto.id(),
                        gradeDto.grade(),
                        gradeDto.classe(),
                        gradeDto.echelon(),
                        gradeDto.indice()
                )
        );

        return dtoMapper.apply(saved);
    }

    @Override
    public List<GradeDto> getAllGrades() {

        List<Grade> grades = repository.findAll();
        return grades.stream().map(dtoMapper).collect(Collectors.toList());

    }

    @Override
    public GradeDto getGradeById(Long id) {

        Grade grade = repository.findById(id).orElseThrow(
                () -> new RuntimeException("Le grade n'existe pas.")
        );

        return dtoMapper.apply(grade);
    }

    @Override
    public GradeDto updateGrade(Long id, GradeDto gradeDto) {

        Grade grade = repository.findById(id).orElseThrow(
                () -> new RuntimeException("Le grade n'existe pas.")
        );

        grade.setGrade(gradeDto.grade());
        grade.setClasse(gradeDto.classe());
        grade.setEchelon(gradeDto.echelon());
        grade.setIndice(gradeDto.indice());

        Grade saved = repository.save(grade);

        return dtoMapper.apply(saved);
    }

    @Override
    public void deleteGrade(Long id) {

        Grade grade = repository.findById(id).orElseThrow(
                () -> new RuntimeException("Le grade n'existe pas.")
        );

        repository.delete(grade);

    }

}
