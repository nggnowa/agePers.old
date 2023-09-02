package com.dresen.agePers.mission;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@AllArgsConstructor
@RestController
@RequestMapping("/mission")
public class MissionController {

    private final MissionService service;

    @PostMapping
    public ResponseEntity<MissionDto> createMission(@RequestBody MissionDto missionDto) {

        MissionDto saved = service.createMission(missionDto);
        return new ResponseEntity<>(saved, CREATED);
    }

    @GetMapping
    public ResponseEntity<List<MissionDto>> getAllMissions() {

        List<MissionDto> missions = service.getAllMissions();
        return ResponseEntity.ok(missions);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MissionDto> getMissionById(@PathVariable Long id) {

        MissionDto missionDto = service.getMissionById(id);
        return ResponseEntity.ok(missionDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MissionDto> createMission(@PathVariable Long id, @RequestBody MissionDto missionDto) {

        MissionDto updated = service.updateMission(id, missionDto);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> createMission(@PathVariable Long id) {

        service.deleteMission(id);
        return ResponseEntity.ok("La mission a été supprimée avec succès");
    }

}
