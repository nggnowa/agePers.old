package com.dresen.agePers.affectation;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@AllArgsConstructor
@RestController
public class AffectationController {

    private final AffectationService service;

    @PostMapping("/enseignants/{enseignantId}/etablissements/{etablissementId}/affectations")
    public ResponseEntity<AffectationDto> createAffectation(@PathVariable Long enseigantId, @PathVariable Long etablissementId, @RequestBody AffectationDto affectationDto) {

        AffectationDto saved = service.createAffectation(enseigantId, etablissementId, affectationDto);
        return new ResponseEntity<>(saved, CREATED);
    }

    @GetMapping("/affectations")
    public ResponseEntity<List<AffectationDto>> getAllAffectations() {

        List<AffectationDto> affectations = service.getAllAffectations();
        return ResponseEntity.ok(affectations);
    }

    @GetMapping("/enseignants/{id}/affectations")
    public ResponseEntity<List<AffectationDto>> getAffectationsByEnseignantId(@PathVariable(name = "id") Long enseignantId) {

        List<AffectationDto> affectations = service.getAffectationsByEnseingnantId(enseignantId);
        return ResponseEntity.ok(affectations);
    }

    @GetMapping("/etablissements/{id}/affectations")
    public ResponseEntity<List<AffectationDto>> getAffectationsByEtablissementId(@PathVariable(name = "id") Long etablissementId) {

        List<AffectationDto> affectations = service.getAffectationsByEtablissementId(etablissementId);
        return ResponseEntity.ok(affectations);
    }

    @GetMapping("/affectations/{id}")
    public ResponseEntity<AffectationDto> getAffectationById(@PathVariable Long id) {

        AffectationDto affectationDto = service.getAffectationById(id);
        return ResponseEntity.ok(affectationDto);
    }

    @PutMapping("/affectations/{id}")
    public ResponseEntity<AffectationDto> updateAffectation(@PathVariable Long id, @RequestBody AffectationDto affectationDto) {

        AffectationDto updated = service.updateAffectation(id, affectationDto);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/affectations/{id}")
    public ResponseEntity<String> deleteAffectation(@PathVariable Long id) {

        service.deleteAffectation(id);
        return ResponseEntity.ok(String.format("%s with id '%s' successfully deleted.", Affectation.class.getSimpleName(), id));
    }

}
