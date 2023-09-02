package com.dresen.agePers.mission;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class MissionService implements IMissionService {

    private final MissionRepository repository;

    private final MissionDtoMapper dtoMapper;

    @Override
    public MissionDto createMission(MissionDto missionDto) {

        Mission saved = repository.save(
                new Mission(
                        missionDto.id(),
                        missionDto.objet(),
                        missionDto.dateDepart(),
                        missionDto.dateRetour(),
                        missionDto.duree(),
                        missionDto.enseignants()
                )
        );

        return dtoMapper.apply(saved);
    }

    @Override
    public List<MissionDto> getAllMissions() {

        List<Mission> missions = repository.findAll();
        return missions.stream().map(dtoMapper).collect(Collectors.toList());

    }

    @Override
    public MissionDto getMissionById(Long id) {

        Mission mission = repository.findById(id).orElseThrow(
                () -> new RuntimeException("La mission n'existe pas.")
        );

        return dtoMapper.apply(mission);
    }

    @Override
    public MissionDto updateMission(Long id, MissionDto missionDto) {

        Mission mission = repository.findById(id).orElseThrow(
                () -> new RuntimeException("La mission n'existe pas.")
        );

        mission.setId(missionDto.id());
        mission.setObjet(missionDto.objet());
        mission.setDateDepart(missionDto.dateDepart());
        mission.setDateRetour(missionDto.dateRetour());
        mission.setEnseignants(missionDto.enseignants());

        Mission saved = repository.save(mission);

        return dtoMapper.apply(saved);
    }

    @Override
    public void deleteMission(Long id) {

        Mission mission = repository.findById(id).orElseThrow(
                () -> new RuntimeException("La mission n'existe pas.")
        );

        repository.delete(mission);

    }

}
