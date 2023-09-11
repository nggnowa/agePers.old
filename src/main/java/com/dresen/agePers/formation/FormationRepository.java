package com.dresen.agePers.formation;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FormationRepository extends JpaRepository<Formation, Long> {

    Optional<Formation> findByNom(String nom);
}
