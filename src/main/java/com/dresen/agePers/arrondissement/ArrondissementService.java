package com.dresen.agePers.arrondissement;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class ArrondissementService implements IArrondissementService {

    private final ArrondissementRepository repository;
    private final ArrondissementDtoMapper  dtoMapper;

    @Override
    public ArrondissementDto createArrondissement(ArrondissementDto arrondissementDto) {

        Arrondissement savedArrondissement = repository.save(
                new Arrondissement(
                        arrondissementDto.id(),
                        arrondissementDto.nom(),
                        arrondissementDto.departement()
                )
        );

        return dtoMapper.apply(savedArrondissement);
    }

    @Override
    public List<ArrondissementDto> getAllArrondissements() {

        List<Arrondissement> arrondissements = repository.findAll();
        return arrondissements.stream().map(dtoMapper).collect(Collectors.toList());
    }

    @Override
    public ArrondissementDto getArrondissementById(Long id) {

        Arrondissement arrondissement = repository.findById(id).orElseThrow(
                () -> new RuntimeException("L'arrondissement n'existe pas.")
        );
        return dtoMapper.apply(arrondissement);
    }

    @Override
    public ArrondissementDto updateArrondissement(Long id, ArrondissementDto arrondissementDto) {

        Arrondissement arrondissement = repository.findById(id).orElseThrow(
                () -> new RuntimeException("L'arrondissement n'existe pas.")
        );

        arrondissement.setNom(arrondissementDto.nom());

        Arrondissement savedArrondissement = repository.save(arrondissement);
        return dtoMapper.apply(savedArrondissement);
    }

    @Override
    public void deleteArrondissement(Long id) {

        Arrondissement arrondissement = repository.findById(id).orElseThrow(
                () -> new RuntimeException("L'arrondissement n'existe pas.")
        );
        repository.delete(arrondissement);
    }
}
