package com.dresen.agePers.diplome;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DiplomeRepository extends JpaRepository<Diplome, Long> {

    List<Diplome> findDiplomesByEnseignantsId(Long enseignantId);

    Optional<Diplome> findByNom(String nom);

    Optional<Diplome> findByCode(String code);
}
