package com.dresen.agePers.affectation;

import java.util.List;

public interface IAffectationService {

    AffectationDto createAffectation(Long enseignantId, Long etablissementId, AffectationDto affectationDto);

    List<AffectationDto> getAllAffectations();

    List<AffectationDto> getAffectationsByEnseingnantId(Long enseigantId);

    List<AffectationDto> getAffectationsByEtablissementId(Long enseigantId);

    AffectationDto getAffectationById(Long id);

    AffectationDto updateAffectation(Long id, AffectationDto affectationDto);

    void deleteAffectation(Long id);

}
