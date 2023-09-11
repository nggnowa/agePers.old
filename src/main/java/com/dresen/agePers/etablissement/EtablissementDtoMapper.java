package com.dresen.agePers.etablissement;

import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class EtablissementDtoMapper implements Function<Etablissement, EtablissementDto> {

    @Override
    public EtablissementDto apply(Etablissement etablissement) {

        return new EtablissementDto(
                etablissement.getId(),
                etablissement.getNom(),
                etablissement.getCategorie(),
                etablissement.getOrdreEnseignement(),
                etablissement.getSousSysteme(),
                etablissement.getArrondissement()
        );
    }
}
