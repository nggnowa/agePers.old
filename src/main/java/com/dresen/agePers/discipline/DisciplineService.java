package com.dresen.agePers.discipline;

import com.dresen.agePers.exceptioin.ResourceNotFoundException;
import com.dresen.agePers.exceptioin.ResourceTakenException;
import com.dresen.agePers.formation.Formation;
import com.dresen.agePers.formation.FormationRepository;
import com.dresen.agePers.region.Region;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class DisciplineService implements DisciplineIService {

    private final FormationRepository  formationRepository;
    private final DisciplineRepository repository;
    private final DisciplineDtoMapper  dtoMapper;


    @Override
    public DisciplineDto createDiscipline(Long formationId, DisciplineDto disciplineDto) {

        Optional<Formation> formationById = formationRepository.findById(formationId);

        if (formationById.isEmpty()) {
            throw new ResourceNotFoundException(Formation.class.getSimpleName(), "id", formationId);
        }

        Discipline saved = repository.save(
                new Discipline(
                        disciplineDto.id(),
                        disciplineDto.nom(),
                        formationById.get()
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
    public List<DisciplineDto> getDisciplinesByFormationId(Long formationId) {

        Optional<Formation> formationById = formationRepository.findById(formationId);

        if (formationById.isEmpty()) {
            throw new ResourceNotFoundException(Region.class.getSimpleName(), "id", formationId);
        }

        List<Discipline> disciplines = repository.findDisciplinesByFormationId(formationId);
        return disciplines.stream().map(dtoMapper).collect(Collectors.toList());
    }

    @Override
    public DisciplineDto getDisciplineById(Long id) {

        Discipline discipline = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException(Region.class.getSimpleName(), "id", id)
        );

        return dtoMapper.apply(discipline);
    }

    @Override
    public DisciplineDto updateDiscipline(Long id, DisciplineDto disciplineDto) {

        Discipline discipline = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException(Region.class.getSimpleName(), "id", id)
        );

        if (!discipline.getNom().equals(disciplineDto.nom())) {

            Optional<Discipline> disciplineByNom = repository.findByNom(disciplineDto.nom());

            if (disciplineByNom.isPresent()) {
                throw new ResourceTakenException(Discipline.class.getSimpleName(), "nom", disciplineDto.nom());
            }
            discipline.setNom(disciplineDto.nom());
        }

        if (disciplineDto.formation() != null) {

            if (!discipline.getFormation().equals(disciplineDto.formation())) {

                discipline.setFormation(disciplineDto.formation());
            }
        }

        Discipline saved = repository.save(discipline);
        return dtoMapper.apply(saved);
    }

    @Override
    public void deleteDiscipline(Long id) {

        Discipline discipline = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException(Region.class.getSimpleName(), "id", id)
        );

        repository.delete(discipline);

    }

}
