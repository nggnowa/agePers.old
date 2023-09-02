package com.dresen.agePers.etablissement;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class EtablissementService implements IEtablissementService {

    private final EtablissementRepository repository;
    private final EtablissementDtoMapper  dtoMapper;

    @Override
    public EtablissementDto createEtablissement(EtablissementDto etablissementDto) {

        Etablissement saved = repository.save(
                new Etablissement(
                        etablissementDto.id(),
                        etablissementDto.nom(),
                        etablissementDto.categorie(),
                        etablissementDto.ordreEnseignement(),
                        etablissementDto.sousSysteme(),
                        etablissementDto.departement(),
                        etablissementDto.arrondissement(),
                        etablissementDto.affectation()
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
    public EtablissementDto getEtablissementById(Long id) {

        Etablissement etablissement = repository.findById(id).orElseThrow(
                () -> new RuntimeException("L'etablissement n'existe pas.")
        );

        return dtoMapper.apply(etablissement);
    }

    @Override
    public EtablissementDto updateEtablissement(Long id, EtablissementDto etablissementDto) {

        Etablissement etablissement = repository.findById(id).orElseThrow(
                () -> new RuntimeException("L'etablissement n'existe pas.")
        );

        etablissement.setNom(etablissementDto.nom());
        Etablissement saved = repository.save(etablissement);

        return dtoMapper.apply(saved);
    }

    @Override
    public void deleteEtablissement(Long id) {

        Etablissement etablissement = repository.findById(id).orElseThrow(
                () -> new RuntimeException("L'etablissement n'existe pas.")
        );

        repository.delete(etablissement);

    }

}
