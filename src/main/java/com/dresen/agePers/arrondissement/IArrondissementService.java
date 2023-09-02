package com.dresen.agePers.arrondissement;

import java.util.List;

public interface IArrondissementService {

    ArrondissementDto createArrondissement(ArrondissementDto arrondissementDto);

    List<ArrondissementDto> getAllArrondissements();

    ArrondissementDto getArrondissementById(Long id);

    ArrondissementDto updateArrondissement(Long id, ArrondissementDto arrondissementDto);

    void deleteArrondissement(Long id);

}
