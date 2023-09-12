package com.dresen.agePers.mission;

import java.util.List;

public interface MissionIService {

    MissionDto createMission(Long enseignantId, MissionDto missionDto);

    List<MissionDto> getAllMissions();

    List<MissionDto> getMissionsByEnseignantId(Long enseignantId);

    MissionDto getMissionById(Long id);

    MissionDto updateMission(Long id, MissionDto missionDto);

    void deleteMission(Long id);

}
