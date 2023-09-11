package com.dresen.agePers.diplome;

import com.dresen.agePers.enseignant.EnseignantDto;
import com.dresen.agePers.enseignant.EnseignantService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@AllArgsConstructor
@RestController
public class DiplomeController {

    private final DiplomeService service;
    private EnseignantService enseignantService;

    @PostMapping("/diplomes")
    public ResponseEntity<DiplomeDto> createDiplome(@RequestBody @Valid DiplomeDto diplomeDto) {

        DiplomeDto saved = service.createDiplome(diplomeDto);
        return new ResponseEntity<>(saved, CREATED);
    }

    @PostMapping("/enseignants/{id}/diplomes")
    public ResponseEntity<DiplomeDto> createDiplome(@PathVariable(name = "id") Long enseignantId, @RequestBody @Valid DiplomeDto diplomeDto) {

        DiplomeDto saved = service.createDiplome(enseignantId, diplomeDto);
        return new ResponseEntity<>(saved, CREATED);
    }

    @GetMapping("/diplomes")
    public ResponseEntity<List<DiplomeDto>> getAllDiplomes() {

        List<DiplomeDto> diplomes = service.getAllDiplomes();
        return ResponseEntity.ok(diplomes);
    }

    @GetMapping("/enseignants/{id}/diplomes")
    public ResponseEntity<List<DiplomeDto>> getDiplomesByEnseignantId(@PathVariable(name = "id") Long enseignantId) {

        List<DiplomeDto> diplomes = service.getDiplomesByEnseignantId(enseignantId);
        return ResponseEntity.ok(diplomes);
    }

    @GetMapping("/diplomes/{id}/enseignants")
    public ResponseEntity<List<EnseignantDto>> getEnseignantsByDiplomeId(@PathVariable(name = "id") Long diplomeId) {

        List<EnseignantDto> enseignants = enseignantService.getEnseignantsByDiplomeId(diplomeId);
        return ResponseEntity.ok(enseignants);
    }

    @GetMapping("/diplomes/{id}")
    public ResponseEntity<DiplomeDto> getDiplomeById(@PathVariable Long id) {

        DiplomeDto diplomeDto = service.getDiplomeById(id);
        return ResponseEntity.ok(diplomeDto);
    }

    @PutMapping("/diplomes/{id}")
    public ResponseEntity<DiplomeDto> updateDiplome(@PathVariable Long id, @RequestBody @Valid DiplomeDto diplomeDto) {

        DiplomeDto updated = service.updateDiplome(id, diplomeDto);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/diplomes/{id}")
    public ResponseEntity<String> deleteDiplome(@PathVariable Long id) {

        service.deleteDiplome(id);
        return ResponseEntity.ok(String.format("%s with id '%s' successfully deleted.", Diplome.class.getSimpleName(), id));
    }

}
