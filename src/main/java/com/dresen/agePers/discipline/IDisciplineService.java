package com.dresen.agePers.discipline;

import java.util.List;

public interface IDisciplineService {

    DisciplineDto createDiscipline(DisciplineDto disciplineDto);

    List<DisciplineDto> getAllDisciplines();

    DisciplineDto getDisciplineById(Long id);

    DisciplineDto updateDiscipline(Long id, DisciplineDto disciplineDto);

    void deleteDiscipline(Long id);

}
