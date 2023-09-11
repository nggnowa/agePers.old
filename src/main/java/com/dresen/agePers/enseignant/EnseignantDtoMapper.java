package com.dresen.agePers.enseignant;

import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class EnseignantDtoMapper implements Function<Enseignant, EnseignantDto> {

    @Override
    public EnseignantDto apply(Enseignant enseignant) {

        return new EnseignantDto(
                enseignant.getId(),
                enseignant.getNom(),
                enseignant.getSexe(),
                enseignant.getDateNaissance(),
                enseignant.getLieuNaissance(),
                enseignant.getMatricule(),
                enseignant.getCategorie(),
                enseignant.getStatut(),
                enseignant.getDateEntreeService(),
                enseignant.getAnciennete(),
                enseignant.getDateRetraite(),
                enseignant.getLangueTravail(),
                enseignant.getPresence(),
                enseignant.getTelephone(),
                enseignant.getEmail(),
                enseignant.getStatutMedical(),
                enseignant.getStatutMatrimonial(),
                enseignant.getNombreEnfant(),
                enseignant.getRegionOrigine(),
                enseignant.getDepartementOrigine(),
                enseignant.getArrondissementOrigine(),
                enseignant.getEthnie(),
                enseignant.getGrade(),
                enseignant.getFormation(),
                enseignant.getDiscipline(),
                enseignant.getDiplomes()
        );

    }

}
