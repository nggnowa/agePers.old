package com.dresen.agePers.mission;

import java.util.List;

public interface IMissionService {

    MissionDto createMission(MissionDto missionDto);

    List<MissionDto> getAllMissions();

    MissionDto getMissionById(Long id);

    MissionDto updateMission(Long id, MissionDto missionDto);

    void deleteMission(Long id);

}
