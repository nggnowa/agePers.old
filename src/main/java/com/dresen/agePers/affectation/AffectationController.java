package com.dresen.agePers.affectation;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@AllArgsConstructor
@RestController
@RequestMapping(name = "/affectations")
public class AffectationController {

    private final AffectationService service;

    @PostMapping
    public ResponseEntity<AffectationDto> createAffectation(@RequestBody AffectationDto affectationDto) {

        AffectationDto saved = service.createAffectation(affectationDto);
        return new ResponseEntity<>(saved, CREATED);
    }

    @GetMapping
    public ResponseEntity<List<AffectationDto>> getAllAffectations() {

        List<AffectationDto> affectations = service.getAllAffectations();
        return ResponseEntity.ok(affectations);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AffectationDto> getAffectationById(@PathVariable Long id) {

        AffectationDto affectationDto = service.getAffectationById(id);
        return ResponseEntity.ok(affectationDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AffectationDto> createAffectation(@PathVariable Long id, @RequestBody AffectationDto affectationDto) {

        AffectationDto updated = service.updateAffectation(id, affectationDto);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> createAffectation(@PathVariable Long id) {

        service.deleteAffectation(id);
        return ResponseEntity.ok("L'affectation a été supprimée avec succès");
    }

}
