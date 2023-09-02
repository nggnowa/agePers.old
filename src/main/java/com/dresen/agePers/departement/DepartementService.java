package com.dresen.agePers.departement;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class DepartementService implements IDepartementService {

    private final DepartementRepository repository;
    private final DepartementDtoMapper  dtoMapper;

    @Override
    public DepartementDto createDepartement(DepartementDto departementDto) {

        Departement savedDepartement = repository.save(
                new Departement(
                        departementDto.id(),
                        departementDto.nom(),
                        departementDto.region(),
                        departementDto.arrondissements()
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
                () -> new RuntimeException("Le département n'existe pas.")
        );
        return dtoMapper.apply(departement);
    }

    @Override
    public DepartementDto updateDepartement(Long id, DepartementDto departementDto) {

        Departement departement = repository.findById(id).orElseThrow(
                () -> new RuntimeException("Le département n'existe pas.")
        );

        departement.setNom(departementDto.nom());

        Departement updated = repository.save(departement);
        return dtoMapper.apply(departement);
    }

    @Override
    public void delelteDepartement(Long id) {

        Departement departement = repository.findById(id).orElseThrow(
                () -> new RuntimeException("Le département n'existe pas.")
        );
        repository.delete(departement);

    }
}
