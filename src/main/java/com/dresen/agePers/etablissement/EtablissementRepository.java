package com.dresen.agePers.etablissement;

import com.dresen.agePers.etablissement.enums.Categorie;
import com.dresen.agePers.etablissement.enums.OrdreEnseignement;
import com.dresen.agePers.etablissement.enums.SousSysteme;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EtablissementRepository extends JpaRepository<Etablissement, Long> {

    Optional<Etablissement> findByNom(String nom);

    List<Etablissement> findByCategorie(Categorie categorie);

    List<Etablissement> findByOrdreEnseignement(OrdreEnseignement ordreEnseignement);

    List<Etablissement> findBySousSysteme(SousSysteme sousSysteme);

}
