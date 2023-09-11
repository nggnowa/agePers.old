package com.dresen.agePers.etablissement;

import com.dresen.agePers.arrondissement.Arrondissement;
import com.dresen.agePers.arrondissement.ArrondissementRepository;
import com.dresen.agePers.exceptioin.ResourceNotFoundException;
import com.dresen.agePers.exceptioin.ResourceTakenException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class EtablissementService implements IEtablissementService {

    private final EtablissementRepository  repository;
    private final EtablissementDtoMapper   dtoMapper;
    private final ArrondissementRepository arrondissementRepository;

    @Override
    public EtablissementDto createEtablissement(EtablissementDto etablissementDto) {

        Optional<Etablissement> etablissementByNom = repository.findByNom(etablissementDto.nom());

        if (etablissementByNom.isPresent()) {
            throw new ResourceTakenException(Etablissement.class.getSimpleName(), "nom", etablissementDto.nom());

        }

        if (!arrondissementRepository.existsById(etablissementDto.arrondissement().getId())) {
            throw new ResourceNotFoundException(Arrondissement.class.getSimpleName(), "id", etablissementDto.arrondissement().getId());
        }

        Etablissement saved = repository.save(
                new Etablissement(
                        etablissementDto.id(),
                        etablissementDto.nom(),
                        etablissementDto.categorie(),
                        etablissementDto.ordreEnseignement(),
                        etablissementDto.sousSysteme(),
                        etablissementDto.arrondissement()
                )
        );

        return dtoMapper.apply(saved);
    }

    @Override
    public List<EtablissementDto> getAllEtablissements() {

        List<Etablissement> etablissements = repository.findAll();
        return etablissements.stream().map(dtoMapper).collect(Collectors.toList());

    }

    @Override
    public List<EtablissementDto> getEtablissementsByCategorie(Categorie categorie) {

        List<Etablissement> etablissements = repository.findByCategorie(categorie);
        return etablissements.stream().map(dtoMapper).collect(Collectors.toList());
    }

    @Override
    public List<EtablissementDto> getEtablissementsByOrdreEnseignement(OrdreEnseignement ordreEnseignement) {

        List<Etablissement> etablissements = repository.findByOrdreEnseignement(ordreEnseignement);
        return etablissements.stream().map(dtoMapper).collect(Collectors.toList());
    }

    @Override
    public List<EtablissementDto> getEtablissementsBySousSysteme(SousSysteme sousSysteme) {

        List<Etablissement> etablissements = repository.findBySousSysteme(sousSysteme);
        return etablissements.stream().map(dtoMapper).collect(Collectors.toList());
    }

    @Override
    public EtablissementDto getEtablissementById(Long id) {

        Etablissement etablissement = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException(Etablissement.class.getSimpleName(), "id", id)
        );

        return dtoMapper.apply(etablissement);
    }

    @Override
    public EtablissementDto getEtablissementByNom(String nom) {

        Etablissement etablissement = repository.findByNom(nom).orElseThrow(
                () -> new ResourceNotFoundException(Etablissement.class.getSimpleName(), "nom", nom)
        );

        return dtoMapper.apply(etablissement);
    }

    @Override
    public EtablissementDto updateEtablissement(Long id, EtablissementDto etablissementDto) {

        Etablissement toUpdate = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException(Etablissement.class.getSimpleName(), "id", id)
        );

        if (!toUpdate.getNom().equals(etablissementDto.nom())) {
            Optional<Etablissement> etablissementByNom = repository.findByNom(etablissementDto.nom());
            if (etablissementByNom.isPresent()) {
                throw new ResourceTakenException(Etablissement.class.getSimpleName(), "nom", etablissementDto.nom());

            }

            toUpdate.setNom(etablissementDto.nom());
        }

        toUpdate.setCategorie(etablissementDto.categorie());
        toUpdate.setOrdreEnseignement(etablissementDto.ordreEnseignement());
        toUpdate.setSousSysteme(etablissementDto.sousSysteme());

        if (!Objects.equals(toUpdate.getArrondissement(), etablissementDto.arrondissement())) {
            if (!arrondissementRepository.existsById(etablissementDto.arrondissement().getId())) {
                throw new ResourceNotFoundException(
                        Arrondissement.class.getSimpleName(),
                        "id",
                        etablissementDto.arrondissement().getId());
            }
            toUpdate.setArrondissement(etablissementDto.arrondissement());
        }

        Etablissement saved = repository.save(toUpdate);
        return dtoMapper.apply(saved);
    }

    @Override
    public void deleteEtablissement(Long id) {

        Etablissement etablissement = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException(Etablissement.class.getSimpleName(), "id", id)
        );

        repository.delete(etablissement);

    }

}
