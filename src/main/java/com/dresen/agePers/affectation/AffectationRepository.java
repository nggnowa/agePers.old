package com.dresen.agePers.affectation;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AffectationRepository extends JpaRepository<Affectation, Long> {

    List<Affectation> findAffectationsByEnseignantId(Long enseignantId);

    List<Affectation> findAffectationsByEtablissementId(Long etablissementId);
}
