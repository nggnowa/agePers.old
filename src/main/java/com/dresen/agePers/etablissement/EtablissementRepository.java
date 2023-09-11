package com.dresen.agePers.etablissement;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EtablissementRepository extends JpaRepository<Etablissement, Long> {

    Optional<Etablissement> findByNom(String nom);

    List<Etablissement> findByCategorie(Categorie categorie);

    List<Etablissement> findByOrdreEnseignement(OrdreEnseignement ordreEnseignement);

    List<Etablissement> findBySousSysteme(SousSysteme sousSysteme);

}
