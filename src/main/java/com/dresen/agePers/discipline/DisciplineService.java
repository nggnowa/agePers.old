package com.dresen.agePers.discipline;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class DisciplineService implements IDisciplineService {

    private final DisciplineRepository repository;
    private final DisciplineDtoMapper  dtoMapper;

    @Override
    public DisciplineDto createDiscipline(DisciplineDto disciplineDto) {

        Discipline saved = repository.save(
                new Discipline(
                        disciplineDto.id(),
                        disciplineDto.nom(),
                        disciplineDto.formation()
                )
        );

        return dtoMapper.apply(saved);
    }

    @Override
    public List<DisciplineDto> getAllDisciplines() {

        List<Discipline> disciplines = repository.findAll();
        return disciplines.stream().map(dtoMapper).collect(Collectors.toList());

    }

    @Override
    public DisciplineDto getDisciplineById(Long id) {

        Discipline discipline = repository.findById(id).orElseThrow(
                () -> new RuntimeException("L'discipline n'existe pas.")
        );

        return dtoMapper.apply(discipline);
    }

    @Override
    public DisciplineDto updateDiscipline(Long id, DisciplineDto disciplineDto) {

        Discipline discipline = repository.findById(id).orElseThrow(
                () -> new RuntimeException("L'discipline n'existe pas.")
        );

        discipline.setNom(disciplineDto.nom());
        Discipline saved = repository.save(discipline);

        return dtoMapper.apply(saved);
    }

    @Override
    public void deleteDiscipline(Long id) {

        Discipline discipline = repository.findById(id).orElseThrow(
                () -> new RuntimeException("L'discipline n'existe pas.")
        );

        repository.delete(discipline);

    }

}
