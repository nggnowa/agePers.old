package com.dresen.agePers.region;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RegionRepository extends JpaRepository<Region, Long> {

    Optional<Region> findByNom(String nom);

    Optional<Region> findByCode(String code);

}
