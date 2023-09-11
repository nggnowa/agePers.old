package com.dresen.agePers.discipline;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@AllArgsConstructor
@RestController
public class DisciplineController {

    private final DisciplineService service;

    @PostMapping("/formations/{id}/disciplines")
    public ResponseEntity<DisciplineDto> createDiscipline(@PathVariable(name = "id") Long formationId, @RequestBody @Valid DisciplineDto disciplineDto) {

        DisciplineDto saved = service.createDiscipline(formationId, disciplineDto);
        return new ResponseEntity<>(saved, CREATED);
    }

    @GetMapping("/disciplines")
    public ResponseEntity<List<DisciplineDto>> getAllDisciplines() {

        List<DisciplineDto> disciplines = service.getAllDisciplines();
        return ResponseEntity.ok(disciplines);
    }

    @GetMapping("/formations/{id}/disciplines")
    public ResponseEntity<List<DisciplineDto>> getDisciplinesByFormationId(@PathVariable(name = "id") Long fornationId) {

        List<DisciplineDto> disciplines = service.getDisciplinesByFormationId(fornationId);
        return ResponseEntity.ok(disciplines);
    }

    @GetMapping("/disciplines/{id}")
    public ResponseEntity<DisciplineDto> getDisciplineById(@PathVariable Long id) {

        DisciplineDto disciplineDto = service.getDisciplineById(id);
        return ResponseEntity.ok(disciplineDto);
    }

    @PutMapping("/disciplines/{id}")
    public ResponseEntity<DisciplineDto> updateDiscipline(@PathVariable Long id, @RequestBody @Valid DisciplineDto disciplineDto) {

        DisciplineDto updated = service.updateDiscipline(id, disciplineDto);
        return ResponseEntity.ok(updated);
    }


    @DeleteMapping("/disciplines/{id}")
    public ResponseEntity<String> deleteDiscipline(@PathVariable Long id) {

        service.deleteDiscipline(id);
        return ResponseEntity.ok(String.format("%s with id '%s' successfully deleted.", Discipline.class.getSimpleName(), id));
    }

}
