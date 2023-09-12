package com.dresen.agePers.etablissement;

import com.dresen.agePers.etablissement.enums.Categorie;
import com.dresen.agePers.etablissement.enums.OrdreEnseignement;
import com.dresen.agePers.etablissement.enums.SousSysteme;

import java.util.List;

public interface EtablissementIService {

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
