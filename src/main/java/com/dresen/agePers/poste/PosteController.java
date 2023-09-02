package com.dresen.agePers.poste;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@AllArgsConstructor
@RestController
@RequestMapping("/poste")
public class PosteController {

    private final PosteService service;

    @PostMapping
    public ResponseEntity<PosteDto> createPoste(@RequestBody PosteDto posteDto) {

        PosteDto saved = service.createPoste(posteDto);
        return new ResponseEntity<>(saved, CREATED);
    }

    @GetMapping
    public ResponseEntity<List<PosteDto>> getAllPostes() {

        List<PosteDto> postes = service.getAllPostes();
        return ResponseEntity.ok(postes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PosteDto> getPosteById(@PathVariable Long id) {

        PosteDto posteDto = service.getPosteById(id);
        return ResponseEntity.ok(posteDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PosteDto> createPoste(@PathVariable Long id, @RequestBody PosteDto posteDto) {

        PosteDto updated = service.updatePoste(id, posteDto);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> createPoste(@PathVariable Long id) {

        service.deletePoste(id);
        return ResponseEntity.ok("Le poste a été supprimée avec succès");
    }

}
