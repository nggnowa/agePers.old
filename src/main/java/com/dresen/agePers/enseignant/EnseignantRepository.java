package com.dresen.agePers.enseignant;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EnseignantRepository extends JpaRepository<Enseignant, Long> {

    Optional<Enseignant> findEnseignantByMatricule(String matricule);

    Optional<Enseignant> findEnseignantByEmail(String email);

    List<Enseignant> findEnseignantsByDiplomesId(Long diplomeId);

}
