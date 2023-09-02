package com.dresen.agePers.mission;

import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class MissionDtoMapper implements Function<Mission, MissionDto> {

    @Override
    public MissionDto apply(Mission mission) {

        return new MissionDto(
                mission.getId(),
                mission.getObjet(),
                mission.getDateDepart(),
                mission.getDateRetour(),
                mission.getDuree(),
                mission.getEnseignants()
        );
    }
}
