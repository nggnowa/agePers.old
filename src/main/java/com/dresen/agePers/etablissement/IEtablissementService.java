package com.dresen.agePers.etablissement;

import java.util.List;

public interface IEtablissementService {

    EtablissementDto createEtablissement(EtablissementDto etablissementDto);

    List<EtablissementDto> getAllEtablissements();

    List<EtablissementDto> getEtablissementsByCategorie(Categorie categorie);

    List<EtablissementDto> getEtablissementsByOrdreEnseignement(OrdreEnseignement ordreEnseignement);

    List<EtablissementDto> getEtablissementsBySousSysteme(SousSysteme sousSysteme);

    EtablissementDto getEtablissementById(Long id);

    EtablissementDto getEtablissementByNom(String nom);

    EtablissementDto updateEtablissement(Long id, EtablissementDto etablissementDto);

    void deleteEtablissement(Long id);

}
