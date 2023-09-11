package com.dresen.agePers.formation;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@AllArgsConstructor
@RestController
@RequestMapping("/formations")
public class FormationController {

    private final FormationService service;

    @PostMapping
    public ResponseEntity<FormationDto> createFormation(@RequestBody @Valid FormationDto formationDto) {

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
    public ResponseEntity<FormationDto> updateFormation(@PathVariable Long id, @RequestBody @Valid FormationDto formationDto) {

        FormationDto updated = service.updateFormation(id, formationDto);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteFormation(@PathVariable Long id) {

        service.deleteFormation(id);
        return ResponseEntity.ok(String.format("%s with id '%s' successfully deleted.", Formation.class.getSimpleName(), id));
    }
}
