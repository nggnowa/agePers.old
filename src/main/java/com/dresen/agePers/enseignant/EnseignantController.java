package com.dresen.agePers.enseignant;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/enseignants")
public class EnseignantController {

    private EnseignantService service;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EnseignantDto> createEnseignant(@RequestBody @Valid EnseignantDto enseignantDto) {

        EnseignantDto savedEnseignant = service.createEnseignant(enseignantDto);
        return new ResponseEntity<>(savedEnseignant, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<EnseignantDto>> getAllEnseignants() {

        List<EnseignantDto> enseignants = service.getAllEnseignants();

        return ResponseEntity.ok(enseignants);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EnseignantDto> getEnseignantById(@PathVariable Long id) {

        EnseignantDto enseignant = service.getEnseignantById(id);

        return ResponseEntity.ok(enseignant);
    }

    @GetMapping("/matricule/{matricule}")
    public ResponseEntity<EnseignantDto> getEnseignantByMatricule(@PathVariable String matricule) {

        EnseignantDto enseignant = service.getEnseignantByMatricule(matricule);

        return ResponseEntity.ok(enseignant);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EnseignantDto> updateEnseignant(@PathVariable Long id, @RequestBody @Valid EnseignantDto enseignantDto) {

        EnseignantDto enseignant = service.updateEnseignant(id, enseignantDto);

        return ResponseEntity.ok(enseignant);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEnseignant(@PathVariable Long id) {


        service.deleteEnseignant(id);

        return ResponseEntity.ok(String.format("%s with id '%s' successfully deleted.", Enseignant.class.getSimpleName(), id));
    }

    @DeleteMapping("matricule/{matricule}")
    public ResponseEntity<String> deleteEnseignant(@PathVariable String matricule) {


        service.deleteEnseignant(matricule);

        return ResponseEntity.ok(String.format("%s with matricule '%s' successfully deleted.", Enseignant.class.getSimpleName(), matricule));
    }

}
