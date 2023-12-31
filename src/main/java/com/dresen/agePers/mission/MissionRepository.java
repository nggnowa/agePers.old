package com.dresen.agePers.mission;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MissionRepository extends JpaRepository<Mission, Long> {

    List<Mission> findByEnseignantId(Long enseignantId);
}
