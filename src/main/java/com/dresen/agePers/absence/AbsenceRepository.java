package com.dresen.agePers.absence;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AbsenceRepository extends JpaRepository<Absence, Long> {

    List<Absence> findAbsencesByEnseignantId(Long enseignantId);
}
