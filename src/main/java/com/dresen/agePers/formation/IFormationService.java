package com.dresen.agePers.formation;

import java.util.List;

public interface IFormationService {

    FormationDto createFormation(FormationDto formationDto);

    List<FormationDto> getAllFormations();

    FormationDto getFormationById(Long id);

    FormationDto updateFormation(Long id, FormationDto formationDto);

    void deleteFormation(Long id);

}
