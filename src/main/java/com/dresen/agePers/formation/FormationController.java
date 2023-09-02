package com.dresen.agePers.formation;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@AllArgsConstructor
@RestController
@RequestMapping("/formation")
public class FormationController {

    private final FormationService service;

    @PostMapping
    public ResponseEntity<FormationDto> createFormation(@RequestBody FormationDto formationDto) {

        FormationDto saved = service.createFormation(formationDto);
        return new ResponseEntity<>(saved, CREATED);
    }

    @GetMapping
    public ResponseEntity<List<FormationDto>> getAllFormations() {

        List<FormationDto> formations = service.getAllFormations();
        return ResponseEntity.ok(formations);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FormationDto> getFormationById(@PathVariable Long id) {

        FormationDto formationDto = service.getFormationById(id);
        return ResponseEntity.ok(formationDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FormationDto> createFormation(@PathVariable Long id, @RequestBody FormationDto formationDto) {

        FormationDto updated = service.updateFormation(id, formationDto);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> createFormation(@PathVariable Long id) {

        service.deleteFormation(id);
        return ResponseEntity.ok("La formation a été supprimée avec succès");
    }
}
