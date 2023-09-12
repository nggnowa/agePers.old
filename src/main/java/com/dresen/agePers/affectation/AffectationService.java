package com.dresen.agePers.affectation;

import com.dresen.agePers.enseignant.Enseignant;
import com.dresen.agePers.enseignant.EnseignantRepository;
import com.dresen.agePers.etablissement.Etablissement;
import com.dresen.agePers.etablissement.EtablissementRepository;
import com.dresen.agePers.exceptioin.ResourceNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class AffectationService implements AffectationIService {

    private final AffectationRepository   repository;
    private final AffectationDtoMapper    dtoMapper;
    private final EnseignantRepository    enseignantRepository;
    private final EtablissementRepository etablissementRepository;

    @Override
    public AffectationDto createAffectation(Long enseignantId, Long etablissementId, AffectationDto affectationDto) {

        Optional<Enseignant> enseignantById = enseignantRepository.findById(enseignantId);
        if (enseignantById.isEmpty()) {
            throw new ResourceNotFoundException(Enseignant.class.getSimpleName(), "id", enseignantId);
        }

        Optional<Etablissement> etablissementById = etablissementRepository.findById(etablissementId);
        if (etablissementById.isEmpty()) {
            throw new ResourceNotFoundException(Etablissement.class.getSimpleName(), "id", etablissementId);
        }

        Affectation saved = repository.save(
                new Affectation(
                        affectationDto.id(),
                        affectationDto.referenceAffectation(),
                        affectationDto.dateAffectation(),
                        affectationDto.datePriseService(),
                        affectationDto.delegation(),
                        affectationDto.anciennete(),
                        enseignantById.get(),
                        affectationDto.poste(),
                        etablissementById.get()
                )
        );

        return dtoMapper.apply(saved);
    }

    @Override
    public AffectationDto createAffectation(Long enseignantId, AffectationDto affectationDto) {

        Optional<Enseignant> enseignantById = enseignantRepository.findById(enseignantId);

        if (enseignantById.isEmpty()) {
            throw new ResourceNotFoundException(Enseignant.class.getSimpleName(), "id", enseignantId);
        }

        Affectation saved = repository.save(
                new Affectation(
                        affectationDto.id(),
                        affectationDto.referenceAffectation(),
                        affectationDto.dateAffectation(),
                        affectationDto.datePriseService(),
                        affectationDto.delegation(),
                        affectationDto.anciennete(),
                        enseignantById.get(),
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
    public List<AffectationDto> getAffectationsByEnseingnantId(Long enseignantId) {

        Optional<Enseignant> enseignantById = enseignantRepository.findById(enseignantId);

        if (enseignantById.isEmpty()) {
            throw new ResourceNotFoundException(Enseignant.class.getSimpleName(), "id", enseignantId);
        }

        List<Affectation> affectations = repository.findAffectationsByEnseignantId(enseignantId);
        return affectations.stream().map(dtoMapper).collect(Collectors.toList());
    }

    @Override
    public List<AffectationDto> getAffectationsByEtablissementId(Long etablissementId) {

        Optional<Etablissement> etablissementById = etablissementRepository.findById(etablissementId);

        if (etablissementById.isEmpty()) {
            throw new ResourceNotFoundException(Etablissement.class.getSimpleName(), "id", etablissementId);
        }

        List<Affectation> affectations = repository.findAffectationsByEtablissementId(etablissementId);
        return affectations.stream().map(dtoMapper).collect(Collectors.toList());
    }

    @Override
    public AffectationDto getAffectationById(Long id) {

        Affectation affectation = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException(Affectation.class.getSimpleName(), "id", id)
        );

        return dtoMapper.apply(affectation);
    }

    @Override
    public AffectationDto updateAffectation(Long id, AffectationDto affectationDto) {

        Affectation affectation = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException(Affectation.class.getSimpleName(), "id", id)
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
                () -> new ResourceNotFoundException(Affectation.class.getSimpleName(), "id", id)
        );

        repository.delete(affectation);

    }

}
