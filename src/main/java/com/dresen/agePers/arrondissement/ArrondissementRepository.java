package com.dresen.agePers.arrondissement;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ArrondissementRepository extends JpaRepository<Arrondissement, Long> {

    Optional<Arrondissement> findByNom(String nom);

    List<Arrondissement> findByDepartementId(Long departementId);

    @Transactional
    void deleteByDepartementId(Long departementId);
}
