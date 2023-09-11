package com.dresen.agePers.ethnie;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EthnieRepository extends JpaRepository<Ethnie, Long> {

    Optional<Ethnie> findByNom(String nom);
}
