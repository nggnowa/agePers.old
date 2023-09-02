package com.dresen.agePers.diplome;

import java.util.List;

public interface IDiplomeService {

    DiplomeDto createDiplome(DiplomeDto diplomeDto);

    List<DiplomeDto> getAllDiplomes();

    DiplomeDto getDiplomeById(Long id);

    DiplomeDto updateDiplome(Long id, DiplomeDto diplomeDto);

    void deleteDiplome(Long id);

}
