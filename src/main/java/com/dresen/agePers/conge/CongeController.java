package com.dresen.agePers.conge;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@AllArgsConstructor
@RestController
@RequestMapping("/conge")
public class CongeController {

    private final CongeService service;

    @PostMapping
    public ResponseEntity<CongeDto> createConge(@RequestBody CongeDto congeDto) {

        CongeDto saved = service.createConge(congeDto);
        return new ResponseEntity<>(saved, CREATED);
    }

    @GetMapping
    public ResponseEntity<List<CongeDto>> getAllConges() {

        List<CongeDto> conges = service.getAllConges();
        return ResponseEntity.ok(conges);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CongeDto> getCongeById(@PathVariable Long id) {

        CongeDto congeDto = service.getCongeById(id);
        return ResponseEntity.ok(congeDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CongeDto> createConge(@PathVariable Long id, @RequestBody CongeDto congeDto) {

        CongeDto updated = service.updateConge(id, congeDto);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> createConge(@PathVariable Long id) {

        service.deleteConge(id);
        return ResponseEntity.ok("L'conge a été supprimée avec succès");
    }

}
