package com.dresen.agePers.diplome;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@AllArgsConstructor
@RestController
@RequestMapping("/diplome")
public class DiplomeController {

    private final DiplomeService service;

    @PostMapping
    public ResponseEntity<DiplomeDto> createDiplome(@RequestBody DiplomeDto diplomeDto) {

        DiplomeDto saved = service.createDiplome(diplomeDto);
        return new ResponseEntity<>(saved, CREATED);
    }

    @GetMapping
    public ResponseEntity<List<DiplomeDto>> getAllDiplomes() {

        List<DiplomeDto> diplomes = service.getAllDiplomes();
        return ResponseEntity.ok(diplomes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DiplomeDto> getDiplomeById(@PathVariable Long id) {

        DiplomeDto diplomeDto = service.getDiplomeById(id);
        return ResponseEntity.ok(diplomeDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DiplomeDto> createDiplome(@PathVariable Long id, @RequestBody DiplomeDto diplomeDto) {

        DiplomeDto updated = service.updateDiplome(id, diplomeDto);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> createDiplome(@PathVariable Long id) {

        service.deleteDiplome(id);
        return ResponseEntity.ok("Le diplome a été supprimé avec succès");
    }

}
