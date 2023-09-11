package com.dresen.agePers.mission;

import com.dresen.agePers.enseignant.Enseignant;
import com.dresen.agePers.enseignant.EnseignantRepository;
import com.dresen.agePers.exceptioin.ResourceNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class MissionService implements IMissionService {

    private final MissionRepository repository;

    private final MissionDtoMapper     dtoMapper;
    private final EnseignantRepository enseignantRepository;


    @Override
    public MissionDto createMission(Long enseignantId, MissionDto missionDto) {

        Optional<Enseignant> enseignantById = enseignantRepository.findById(enseignantId);

        if (enseignantById.isEmpty()) {
            throw new ResourceNotFoundException(Enseignant.class.getSimpleName(), "id", enseignantId);
        }

        Mission saved = repository.save(
                new Mission(
                        missionDto.id(),
                        missionDto.objet(),
                        missionDto.dateDepart(),
                        missionDto.dateRetour(),
                        missionDto.duree(),
                        enseignantById.get()
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
    public List<MissionDto> getMissionsByEnseignantId(Long enseignantId) {

        List<Mission> missions = repository.findByEnseignantId(enseignantId);
        return missions.stream().map(dtoMapper).collect(Collectors.toList());

    }

    @Override
    public MissionDto getMissionById(Long id) {

        Mission mission = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException(Enseignant.class.getSimpleName(), "id", id)
        );

        return dtoMapper.apply(mission);
    }

    @Override
    public MissionDto updateMission(Long id, MissionDto missionDto) {

        Mission mission = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException(Enseignant.class.getSimpleName(), "id", id)
        );

        mission.setId(missionDto.id());
        mission.setObjet(missionDto.objet());
        mission.setDateDepart(missionDto.dateDepart());
        mission.setDateRetour(missionDto.dateRetour());
        mission.setEnseignant(missionDto.enseignant());

        Mission saved = repository.save(mission);

        return dtoMapper.apply(saved);
    }

    @Override
    public void deleteMission(Long id) {

        Mission mission = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException(Enseignant.class.getSimpleName(), "id", id)
        );

        repository.delete(mission);

    }

}
