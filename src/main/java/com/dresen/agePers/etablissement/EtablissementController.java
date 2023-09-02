package com.dresen.agePers.etablissement;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@AllArgsConstructor
@RestController
@RequestMapping("/etablissement")
public class EtablissementController {

    private final EtablissementService service;

    @PostMapping
    public ResponseEntity<EtablissementDto> createEtablissement(@RequestBody EtablissementDto etablissementDto) {

        EtablissementDto saved = service.createEtablissement(etablissementDto);
        return new ResponseEntity<>(saved, CREATED);
    }

    @GetMapping
    public ResponseEntity<List<EtablissementDto>> getAllEtablissements() {

        List<EtablissementDto> etablissements = service.getAllEtablissements();
        return ResponseEntity.ok(etablissements);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EtablissementDto> getEtablissementById(@PathVariable Long id) {

        EtablissementDto etablissementDto = service.getEtablissementById(id);
        return ResponseEntity.ok(etablissementDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EtablissementDto> createEtablissement(@PathVariable Long id, @RequestBody EtablissementDto etablissementDto) {

        EtablissementDto updated = service.updateEtablissement(id, etablissementDto);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> createEtablissement(@PathVariable Long id) {

        service.deleteEtablissement(id);
        return ResponseEntity.ok("L'etablissement a été supprimée avec succès");
    }

}
