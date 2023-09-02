package com.dresen.agePers.discipline;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@AllArgsConstructor
@RestController
@RequestMapping("/discipline")
public class DisciplineController {

    private final DisciplineService service;

    @PostMapping
    public ResponseEntity<DisciplineDto> createDiscipline(@RequestBody DisciplineDto disciplineDto) {

        DisciplineDto saved = service.createDiscipline(disciplineDto);
        return new ResponseEntity<>(saved, CREATED);
    }

    @GetMapping
    public ResponseEntity<List<DisciplineDto>> getAllDisciplines() {

        List<DisciplineDto> disciplines = service.getAllDisciplines();
        return ResponseEntity.ok(disciplines);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DisciplineDto> getDisciplineById(@PathVariable Long id) {

        DisciplineDto disciplineDto = service.getDisciplineById(id);
        return ResponseEntity.ok(disciplineDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DisciplineDto> createDiscipline(@PathVariable Long id, @RequestBody DisciplineDto disciplineDto) {

        DisciplineDto updated = service.updateDiscipline(id, disciplineDto);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> createDiscipline(@PathVariable Long id) {

        service.deleteDiscipline(id);
        return ResponseEntity.ok("L'discipline a été supprimée avec succès");
    }

}
