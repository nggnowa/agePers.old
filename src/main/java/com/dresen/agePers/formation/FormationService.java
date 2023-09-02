package com.dresen.agePers.formation;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class FormationService implements IFormationService {

    private final FormationRepository repository;
    private final FormationDtoMapper  dtoMapper;

    @Override
    public FormationDto createFormation(FormationDto formationDto) {

        Formation saved = repository.save(
                new Formation(
                        formationDto.id(),
                        formationDto.nom(),
                        formationDto.disciplines()
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
                () -> new RuntimeException("La formation n'existe pas.")
        );

        return dtoMapper.apply(formation);
    }

    @Override
    public FormationDto updateFormation(Long id, FormationDto formationDto) {

        Formation formation = repository.findById(id).orElseThrow(
                () -> new RuntimeException("La formation n'existe pas.")
        );

        formation.setNom(formationDto.nom());
        Formation saved = repository.save(formation);

        return dtoMapper.apply(saved);
    }

    @Override
    public void deleteFormation(Long id) {

        Formation formation = repository.findById(id).orElseThrow(
                () -> new RuntimeException("La formation n'existe pas.")
        );

        repository.delete(formation);

    }

}
