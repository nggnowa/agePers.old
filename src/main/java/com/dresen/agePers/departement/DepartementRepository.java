package com.dresen.agePers.departement;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DepartementRepository extends JpaRepository<Departement, Long> {

    Optional<Departement> findByNom(String nom);

    List<Departement> findByRegionId(Long regionId);

    @Transactional
    void deleteByRegionId(Long regionId);
}
