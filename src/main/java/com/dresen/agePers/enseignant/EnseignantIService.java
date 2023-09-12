package com.dresen.agePers.enseignant;

import com.dresen.agePers.arrondissement.Arrondissement;
import com.dresen.agePers.departement.Departement;
import com.dresen.agePers.diplome.Diplome;
import com.dresen.agePers.discipline.Discipline;
import com.dresen.agePers.enseignant.enums.*;
import com.dresen.agePers.etablissement.Etablissement;
import com.dresen.agePers.formation.Formation;
import com.dresen.agePers.grade.Grade;
import com.dresen.agePers.poste.Poste;
import com.dresen.agePers.region.Region;

import java.time.LocalDate;
import java.util.List;

public interface EnseignantIService {

    EnseignantDto createEnseignant(EnseignantDto enseignantDto);

    EnseignantDto getEnseignantById(Long id);

    EnseignantDto getEnseignantByMatricule(String matricule);

    List<EnseignantDto> getAllEnseignants();

    List<EnseignantDto> getEnseignantsByDiplomeId(Long diplomeId); //tous les enseignants ayant le diplome dont l'id est passé en parametre

    EnseignantDto updateEnseignant(Long id, EnseignantDto enseignantDto);

    EnseignantDto updateEnseignantIidentite(Long id, String nom, Sexe sexe, LocalDate dateNaissance, String lieuNaissance);


    EnseignantDto updateEnseignantConditionP(Long id, StatutMedical statutMedical);

    EnseignantDto updateEnseignantOrigine(Long id, Region region, Departement departement, Arrondissement arrondissement);

    EnseignantDto updateEnseignantFamille(Long id, StatutMatrimonial statutMatrimonial, Integer nombreEnfant);

    EnseignantDto updateEnseignantContact(Long id, String telephone, String email);

    EnseignantDto updateEnseignantFormation(Long id, Formation formation, Discipline discipline, Diplome dernierDiplome);

    EnseignantDto updateEnseignantCarriere(Long id, String matricule, Categorie categorie, Statut statut, LocalDate dateEntreeService, Diplome diplomeEntree, Grade grade, String langueTravail);

    EnseignantDto updateEnseignantAffectation(Long id, Poste poste, String rang, LocalDate dateAffectation, String referenceAffectation, LocalDate datePriseService, Presence presence, Etablissement etablissement);

    void deleteEnseignant(Long id);

    void deleteEnseignant(String matricule);

}
