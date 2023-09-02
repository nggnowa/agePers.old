package com.dresen.agePers.affectation;

import java.util.List;

public interface IAffectationService {

    AffectationDto createAffectation(AffectationDto affectationDto);

    List<AffectationDto> getAllAffectations();

    AffectationDto getAffectationById(Long id);

    AffectationDto updateAffectation(Long id, AffectationDto affectationDto);

    void deleteAffectation(Long id);

}
