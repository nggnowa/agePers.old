package com.dresen.agePers.poste;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PosteRepository extends JpaRepository<Poste, Long> {

    Optional<Poste> findByTitre(String titre);
}
