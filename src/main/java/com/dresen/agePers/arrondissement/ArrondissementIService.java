package com.dresen.agePers.arrondissement;

import java.util.List;

public interface ArrondissementIService {

    ArrondissementDto createArrondissement(Long departementId, ArrondissementDto arrondissementDto);

    List<ArrondissementDto> getAllArrondissements();

    List<ArrondissementDto> getArrondissementsByDepartementId(Long departementId);

    ArrondissementDto getArrondissementById(Long id);


    ArrondissementDto updateArrondissement(Long id, ArrondissementDto arrondissementDto);

    void deleteArrondissement(Long id);

    void deleteArrondissementsByDepartementId(Long id);

}
