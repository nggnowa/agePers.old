package com.dresen.agePers.discipline;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DisciplineRepository extends JpaRepository<Discipline, Long> {

    List<Discipline> findDisciplinesByFormationId(Long formationId);

    Optional<Discipline> findByNom(String nom);
}
