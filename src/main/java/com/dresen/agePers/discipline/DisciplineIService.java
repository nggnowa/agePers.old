package com.dresen.agePers.discipline;

import java.util.List;

public interface DisciplineIService {

    DisciplineDto createDiscipline(Long formationId, DisciplineDto disciplineDto);

    List<DisciplineDto> getAllDisciplines();

    List<DisciplineDto> getDisciplinesByFormationId(Long formationId);

    DisciplineDto getDisciplineById(Long id);

    DisciplineDto updateDiscipline(Long id, DisciplineDto disciplineDto);

    void deleteDiscipline(Long id);

}
