package com.dresen.agePers.arrondissement;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@AllArgsConstructor
@RestController
public class ArrondissementController {

    private final ArrondissementService service;

    @PostMapping("departements/{id}/arrondissements")
    public ResponseEntity<ArrondissementDto> createArrondissement(@PathVariable(name = "id") Long departementId, @RequestBody @Valid ArrondissementDto toCreate) {

        ArrondissementDto created = service.createArrondissement(departementId, toCreate);
        return new ResponseEntity<>(created, CREATED);
    }

    @GetMapping("departements/{id}/arrondissements")
    public ResponseEntity<List<ArrondissementDto>> getArrondissementsByDepartementId(@PathVariable(name = "id") Long departementId) {

        List<ArrondissementDto> Arrondissements = service.getArrondissementsByDepartementId(departementId);
        return ResponseEntity.ok(Arrondissements);
    }

    @GetMapping("/arrondissements")
    public ResponseEntity<List<ArrondissementDto>> getAllArrondissements() {

        List<ArrondissementDto> Arrondissements = service.getAllArrondissements();
        return ResponseEntity.ok(Arrondissements);
    }

    @GetMapping("/arrondissements/{id}")
    public ResponseEntity<ArrondissementDto> getArrondissementById(@PathVariable Long id) {

        ArrondissementDto Arrondissement = service.getArrondissementById(id);
        return ResponseEntity.ok(Arrondissement);
    }

    @PutMapping("/arrondissements/{id}")
    public ResponseEntity<ArrondissementDto> updateArrondissement(@PathVariable Long id, @RequestBody @Valid ArrondissementDto toUpdate) {

        ArrondissementDto updated = service.updateArrondissement(id, toUpdate);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/arrondissements/{id}")
    public ResponseEntity<String> deleteArrondissement(@PathVariable Long id) {

        service.deleteArrondissement(id);
        return ResponseEntity.ok(String.format("%s with id '%s' successfully deleted.", Arrondissement.class.getSimpleName(), id));
    }


}
