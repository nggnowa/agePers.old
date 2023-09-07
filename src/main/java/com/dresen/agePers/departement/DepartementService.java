package com.dresen.agePers.departement;

import com.dresen.agePers.exceptioin.ResourceNotFoundException;
import com.dresen.agePers.exceptioin.ResourceTakenException;
import com.dresen.agePers.region.Region;
import com.dresen.agePers.region.RegionDtoMapper;
import com.dresen.agePers.region.RegionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class DepartementService implements IDepartementService {

    private final RegionRepository regionRepository;
    private final RegionDtoMapper  regionDtoMapper;

    private final DepartementRepository repository;
    private final DepartementDtoMapper  dtoMapper;

    @Override
    public DepartementDto createDepartement(Long regionId, DepartementDto departementDto) {

        Optional<Region> regionById = regionRepository.findById(regionId);

        if (!regionById.isPresent())
            throw new ResourceTakenException(Region.class.getSimpleName(), "id", regionId);

        Optional<Departement> departementByNom = repository.findByNom(departementDto.nom());

        if (departementByNom.isPresent()) {
            throw new ResourceTakenException(Departement.class.getSimpleName(), "nom", departementDto.nom());
        }

        Departement savedDepartement = repository.save(
                new Departement(
                        departementDto.id(),
                        departementDto.nom(),
                        regionById.get()
                )
        );

        return dtoMapper.apply(savedDepartement);
    }

    @Override
    public List<DepartementDto> getAllDepartements() {

        List<Departement> departements = repository.findAll();
        return departements.stream().map(dtoMapper).collect(Collectors.toList());
    }

    @Override
    public DepartementDto getDepartementById(Long id) {

        Departement departement = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException(Departement.class.getSimpleName(), "id", id)
        );
        return dtoMapper.apply(departement);
    }

    @Override
    public DepartementDto updateDepartement(Long id, DepartementDto departementDto) {

        Departement departement = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException(Departement.class.getSimpleName(), "id", id)
        );

        if (!departement.getNom().equals(departementDto.nom())) {

            Optional<Departement> departementByNom = repository.findByNom(departementDto.nom());
            if (departementByNom.isPresent()) {
                throw new ResourceTakenException(Departement.class.getSimpleName(), "nom", departementDto.nom());
            }
            departement.setNom(departementDto.nom());
        }

        departement.setRegion(departementDto.region());

        Departement updated = repository.save(departement);
        return dtoMapper.apply(departement);
    }

    @Override
    public void delelteDepartement(Long id) {

        Departement departement = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException(Departement.class.getSimpleName(), "id", id)
        );
        repository.delete(departement);

    }
}
