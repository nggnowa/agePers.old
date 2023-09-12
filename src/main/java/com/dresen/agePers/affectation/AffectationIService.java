package com.dresen.agePers.affectation;

import java.util.List;

public interface AffectationIService {

    AffectationDto createAffectation(Long enseignantId, Long etablissementId, AffectationDto affectationDto);

    AffectationDto createAffectation(Long enseignantId, AffectationDto affectationDto);

    List<AffectationDto> getAllAffectations();

    List<AffectationDto> getAffectationsByEnseingnantId(Long enseigantId);

    List<AffectationDto> getAffectationsByEtablissementId(Long enseigantId);

    AffectationDto getAffectationById(Long id);

    AffectationDto updateAffectation(Long id, AffectationDto affectationDto);

    void deleteAffectation(Long id);

}
