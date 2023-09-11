package com.dresen.agePers.mission;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@AllArgsConstructor
@RestController
public class MissionController {

    private final MissionService service;

    @PostMapping("/enseignants/{id}/missions")
    public ResponseEntity<MissionDto> createMission(@PathVariable(name = "id") Long enseignantId, @RequestBody @Valid MissionDto missionDto) {

        MissionDto saved = service.createMission(enseignantId, missionDto);
        return new ResponseEntity<>(saved, CREATED);
    }

    @GetMapping("/missions")
    public ResponseEntity<List<MissionDto>> getAllMissions() {

        List<MissionDto> missions = service.getAllMissions();
        return ResponseEntity.ok(missions);
    }

    @GetMapping("/enseignants/{id}/missions")
    public ResponseEntity<List<MissionDto>> getMissionsByEnseignantId(@PathVariable(name = "id") Long enseignantId) {

        List<MissionDto> missions = service.getMissionsByEnseignantId(enseignantId);
        return ResponseEntity.ok(missions);
    }

    @GetMapping("/missions/{id}")
    public ResponseEntity<MissionDto> getMissionById(@PathVariable Long id) {

        MissionDto missionDto = service.getMissionById(id);
        return ResponseEntity.ok(missionDto);
    }

    @PutMapping("/missions/{id}")
    public ResponseEntity<MissionDto> updateMission(@PathVariable Long id, @RequestBody @Valid MissionDto missionDto) {

        MissionDto updated = service.updateMission(id, missionDto);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/missions/{id}")
    public ResponseEntity<String> deleteMission(@PathVariable Long id) {

        service.deleteMission(id);
        return ResponseEntity.ok(String.format("%s with id '%s' successfully deleted.", Mission.class.getSimpleName(), id));
    }

}
