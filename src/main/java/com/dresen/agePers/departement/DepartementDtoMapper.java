package com.dresen.agePers.departement;

import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class DepartementDtoMapper implements Function<Departement, DepartementDto> {

    @Override
    public DepartementDto apply(Departement departement) {

        return new DepartementDto(
                departement.getId(),
                departement.getNom(),
                departement.getRegion(),
                departement.getArrondissements()
        );
    }

}
