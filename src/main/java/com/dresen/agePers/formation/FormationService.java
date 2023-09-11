package com.dresen.agePers.formation;

import com.dresen.agePers.exceptioin.ResourceNotFoundException;
import com.dresen.agePers.exceptioin.ResourceTakenException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class FormationService implements IFormationService {

    private final FormationRepository repository;
    private final FormationDtoMapper  dtoMapper;

    @Override
    public FormationDto createFormation(FormationDto formationDto) {

        Optional<Formation> formationByNom = repository.findByNom(formationDto.nom());

        if (formationByNom.isPresent()) {
            throw new ResourceTakenException(Formation.class.getSimpleName(), "nom", formationDto.nom());
        }

        Formation saved = repository.save(
                new Formation(
                        formationDto.id(),
                        formationDto.nom()
                )
        );

        return dtoMapper.apply(saved);
    }

    @Override
    public List<FormationDto> getAllFormations() {

        List<Formation> formations = repository.findAll();
        return formations.stream().map(dtoMapper).collect(Collectors.toList());

    }

    @Override
    public FormationDto getFormationById(Long id) {

        Formation formation = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException(Formation.class.getSimpleName(), "id", id)
        );

        return dtoMapper.apply(formation);
    }

    @Override
    public FormationDto updateFormation(Long id, FormationDto formationDto) {

        Formation formation = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException(Formation.class.getSimpleName(), "id", id)
        );

        if (!formation.getNom().equals(formationDto.nom())) {
            Optional<Formation> formationByNom = repository.findByNom(formationDto.nom());

            if (formationByNom.isPresent()) {
                throw new ResourceTakenException(Formation.class.getSimpleName(), "nom", formationDto.nom());
            }
            formation.setNom(formationDto.nom());

        }

        Formation saved = repository.save(formation);

        return dtoMapper.apply(saved);
    }

    @Override
    public void deleteFormation(Long id) {

        Formation formation = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException(Formation.class.getSimpleName(), "id", id)
        );

        repository.delete(formation);

    }

}
