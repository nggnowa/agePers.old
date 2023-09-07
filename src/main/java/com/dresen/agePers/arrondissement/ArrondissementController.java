package com.dresen.agePers.arrondissement;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@AllArgsConstructor
@RestController
@RequestMapping("/arrondissements")
public class ArrondissementController {

    private final ArrondissementService service;

    @PostMapping
    public ResponseEntity<ArrondissementDto> createArrondissement(@RequestBody @Valid ArrondissementDto toCreate) {

        ArrondissementDto created = service.createArrondissement(toCreate);
        return new ResponseEntity<>(created, CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ArrondissementDto>> getAllArrondissements() {

        List<ArrondissementDto> Arrondissements = service.getAllArrondissements();
        return ResponseEntity.ok(Arrondissements);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ArrondissementDto> getArrondissementById(@PathVariable Long id) {

        ArrondissementDto Arrondissement = service.getArrondissementById(id);
        return ResponseEntity.ok(Arrondissement);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ArrondissementDto> updateArrondissement(@PathVariable Long id, @RequestBody @Valid ArrondissementDto toUpdate) {

        ArrondissementDto updated = service.updateArrondissement(id, toUpdate);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteArrondissement(@PathVariable Long id) {

        service.deleteArrondissement(id);
        return ResponseEntity.ok(String.format("%s with id '%s' successfully deleted.", Arrondissement.class.getSimpleName(), id));
    }


}
