package com.dresen.agePers.arrondissement;

import com.dresen.agePers.departement.Departement;
import com.dresen.agePers.departement.DepartementRepository;
import com.dresen.agePers.exceptioin.ResourceNotFoundException;
import com.dresen.agePers.exceptioin.ResourceTakenException;
import com.dresen.agePers.region.Region;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class ArrondissementService implements IArrondissementService {

    private final DepartementRepository    departementRepository;
    private final ArrondissementRepository repository;
    private final ArrondissementDtoMapper  dtoMapper;

    @Override
    public ArrondissementDto createArrondissement(Long departementId, ArrondissementDto arrondissementDto) {

        Optional<Departement> departementById = departementRepository.findById(departementId);

        if (departementById.isEmpty()) {
            throw new ResourceNotFoundException(Region.class.getSimpleName(), "id", departementId);
        }

        Optional<Arrondissement> arrondissementByNom = repository.findByNom(arrondissementDto.nom());

        if (arrondissementByNom.isPresent()) {
            throw new ResourceTakenException(Departement.class.getSimpleName(), "nom", arrondissementDto.nom());
        }
        Arrondissement savedArrondissement = repository.save(
                new Arrondissement(
                        arrondissementDto.id(),
                        arrondissementDto.nom(),
                        departementById.get()
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
    public List<ArrondissementDto> getArrondissementsByDepartementId(Long departementId) {

        Optional<Departement> departementById = departementRepository.findById(departementId);

        if (departementById.isEmpty()) {
            throw new ResourceNotFoundException(Region.class.getSimpleName(), "id", departementId);
        }

        List<Arrondissement> arrondissements = repository.findByDepartementId(departementId);
        return arrondissements.stream().map(dtoMapper).collect(Collectors.toList());
    }

    @Override
    public ArrondissementDto getArrondissementById(Long id) {

        Arrondissement arrondissement = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException(Region.class.getSimpleName(), "id", id)
        );
        return dtoMapper.apply(arrondissement);
    }

    @Override
    public ArrondissementDto updateArrondissement(Long id, ArrondissementDto arrondissementDto) {

        Arrondissement arrondissement = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException(Region.class.getSimpleName(), "id", id)
        );


        if (!arrondissement.getNom().equals(arrondissementDto.nom())) {

            Optional<Arrondissement> arrondissementByNom = repository.findByNom(arrondissementDto.nom());

            if (arrondissementByNom.isPresent()) {
                throw new ResourceTakenException(Arrondissement.class.getSimpleName(), "nom", arrondissementDto.nom());
            }
            arrondissement.setNom(arrondissementDto.nom());
        }

        if (arrondissementDto.departement() != null && !arrondissement.getDepartement().equals(arrondissementDto.departement())) {
            arrondissement.setDepartement(arrondissementDto.departement());
        }


        Arrondissement savedArrondissement = repository.save(arrondissement);
        return dtoMapper.apply(savedArrondissement);
    }

    @Override
    public void deleteArrondissement(Long id) {

        Arrondissement arrondissement = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException(Region.class.getSimpleName(), "id", id)
        );
        repository.delete(arrondissement);
    }
}
