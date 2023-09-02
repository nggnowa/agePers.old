package com.dresen.agePers.affectation;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class AffectationService implements IAffectationService {

    private final AffectationRepository repository;
    private final AffectationDtoMapper  dtoMapper;

    @Override
    public AffectationDto createAffectation(AffectationDto affectationDto) {

        Affectation saved = repository.save(
                new Affectation(
                        affectationDto.id(),
                        affectationDto.referenceAffectation(),
                        affectationDto.dateAffectation(),
                        affectationDto.datePriseService(),
                        affectationDto.delegation(),
                        affectationDto.anciennete(),
                        affectationDto.enseignant(),
                        affectationDto.poste(),
                        affectationDto.etablissement()
                )
        );

        return dtoMapper.apply(saved);
    }

    @Override
    public List<AffectationDto> getAllAffectations() {

        List<Affectation> affectations = repository.findAll();
        return affectations.stream().map(dtoMapper).collect(Collectors.toList());

    }

    @Override
    public AffectationDto getAffectationById(Long id) {

        Affectation affectation = repository.findById(id).orElseThrow(
                () -> new RuntimeException("L'affectation n'existe pas.")
        );

        return dtoMapper.apply(affectation);
    }

    @Override
    public AffectationDto updateAffectation(Long id, AffectationDto affectationDto) {

        Affectation affectation = repository.findById(id).orElseThrow(
                () -> new RuntimeException("L'affectation n'existe pas.")
        );

        affectation.setReferenceAffectation(affectationDto.referenceAffectation());
        affectation.setDatePriseService(affectationDto.datePriseService());
        affectation.setDelegation(affectationDto.delegation());
        affectation.setEnseignant(affectationDto.enseignant());
        affectation.setPoste(affectationDto.poste());
        affectation.setEtablissement(affectationDto.etablissement());
        Affectation saved = repository.save(affectation);

        return dtoMapper.apply(saved);
    }

    @Override
    public void deleteAffectation(Long id) {

        Affectation affectation = repository.findById(id).orElseThrow(
                () -> new RuntimeException("L'affectation n'existe pas.")
        );

        repository.delete(affectation);

    }

}
