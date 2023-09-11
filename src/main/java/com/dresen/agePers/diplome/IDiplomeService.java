package com.dresen.agePers.diplome;

import java.util.List;

public interface IDiplomeService {

    DiplomeDto createDiplome(DiplomeDto diplomeDto);

    DiplomeDto createDiplome(Long enseignantId, DiplomeDto diplomeDto);

    List<DiplomeDto> getAllDiplomes();

    List<DiplomeDto> getDiplomesByEnseignantId(Long enseignantId);

    DiplomeDto getDiplomeById(Long id);


    DiplomeDto updateDiplome(Long id, DiplomeDto diplomeDto);

    void deleteDiplome(Long id);

}
