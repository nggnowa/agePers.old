package com.dresen.agePers.diplome;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class DiplomeService implements IDiplomeService {

    private final DiplomeRepository repository;
    private final DiplomeDtoMapper  dtoMapper;

    @Override
    public DiplomeDto createDiplome(DiplomeDto diplomeDto) {

        Diplome saved = repository.save(
                new Diplome(
                        diplomeDto.id(),
                        diplomeDto.nom(),
                        diplomeDto.code(),
                        diplomeDto.cycle(),
                        diplomeDto.enseignant()
                )
        );

        return dtoMapper.apply(saved);
    }

    @Override
    public List<DiplomeDto> getAllDiplomes() {

        List<Diplome> diplomes = repository.findAll();
        return diplomes.stream().map(dtoMapper).collect(Collectors.toList());

    }

    @Override
    public DiplomeDto getDiplomeById(Long id) {

        Diplome diplome = repository.findById(id).orElseThrow(
                () -> new RuntimeException("Le diplome n'existe pas.")
        );

        return dtoMapper.apply(diplome);
    }

    @Override
    public DiplomeDto updateDiplome(Long id, DiplomeDto diplomeDto) {

        Diplome diplome = repository.findById(id).orElseThrow(
                () -> new RuntimeException("Le diplome n'existe pas.")
        );

        diplome.setNom(diplomeDto.nom());
        Diplome saved = repository.save(diplome);

        return dtoMapper.apply(saved);
    }

    @Override
    public void deleteDiplome(Long id) {

        Diplome diplome = repository.findById(id).orElseThrow(
                () -> new RuntimeException("Le diplome n'existe pas.")
        );

        repository.delete(diplome);

    }

}
