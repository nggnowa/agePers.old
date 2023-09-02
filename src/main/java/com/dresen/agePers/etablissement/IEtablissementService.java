package com.dresen.agePers.etablissement;

import java.util.List;

public interface IEtablissementService {

    EtablissementDto createEtablissement(EtablissementDto etablissementDto);

    List<EtablissementDto> getAllEtablissements();

    EtablissementDto getEtablissementById(Long id);

    EtablissementDto updateEtablissement(Long id, EtablissementDto etablissementDto);

    void deleteEtablissement(Long id);

}
