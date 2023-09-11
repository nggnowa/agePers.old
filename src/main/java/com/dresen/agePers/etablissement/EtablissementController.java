package com.dresen.agePers.etablissement;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@AllArgsConstructor
@RestController
@RequestMapping("/etablissements")
public class EtablissementController {

    private final EtablissementService service;

    @PostMapping
    public ResponseEntity<EtablissementDto> createEtablissement(@RequestBody @Valid EtablissementDto etablissementDto) {

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

    @GetMapping("/nom/{nom}")
    public ResponseEntity<EtablissementDto> getEtablissementByNom(@PathVariable String nom) {

        EtablissementDto etablissementDto = service.getEtablissementByNom(nom);
        return ResponseEntity.ok(etablissementDto);
    }

    @GetMapping("/categorie/{categorie}")
    public ResponseEntity<List<EtablissementDto>> getEtablissementByCategorie(@PathVariable Categorie categorie) {

        List<EtablissementDto> etablissementDto = service.getEtablissementsByCategorie(categorie);
        return ResponseEntity.ok(etablissementDto);
    }

    @GetMapping("/ordreEnseignement/{ordreEnseignement}")
    public ResponseEntity<List<EtablissementDto>> getEtablissementByOrdreEnseignement(@PathVariable OrdreEnseignement ordreEnseignement) {

        List<EtablissementDto> etablissementDto = service.getEtablissementsByOrdreEnseignement(ordreEnseignement);
        return ResponseEntity.ok(etablissementDto);
    }

    @GetMapping("/sousSysteme/{sousSysteme}")
    public ResponseEntity<List<EtablissementDto>> getEtablissementBySousSysteme(@PathVariable SousSysteme sousSysteme) {

        List<EtablissementDto> etablissementDto = service.getEtablissementsBySousSysteme(sousSysteme);
        return ResponseEntity.ok(etablissementDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EtablissementDto> updateEtablissement(@PathVariable Long id, @RequestBody @Valid EtablissementDto etablissementDto) {

        EtablissementDto updated = service.updateEtablissement(id, etablissementDto);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEtablissement(@PathVariable Long id) {

        service.deleteEtablissement(id);
        return ResponseEntity.ok(String.format("%s with id '%s' successfully deleted.", Etablissement.class.getSimpleName(), id));
    }

}
