package com.dresen.agePers.grade;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@AllArgsConstructor
@RestController
@RequestMapping("/grade")
public class GradeController {

    private final GradeService service;

    @PostMapping
    public ResponseEntity<GradeDto> createGrade(@RequestBody GradeDto gradeDto) {

        GradeDto saved = service.createGrade(gradeDto);
        return new ResponseEntity<>(saved, CREATED);
    }

    @GetMapping
    public ResponseEntity<List<GradeDto>> getAllGrades() {

        List<GradeDto> grades = service.getAllGrades();
        return ResponseEntity.ok(grades);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GradeDto> getGradeById(@PathVariable Long id) {

        GradeDto gradeDto = service.getGradeById(id);
        return ResponseEntity.ok(gradeDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GradeDto> createGrade(@PathVariable Long id, @RequestBody GradeDto gradeDto) {

        GradeDto updated = service.updateGrade(id, gradeDto);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> createGrade(@PathVariable Long id) {

        service.deleteGrade(id);
        return ResponseEntity.ok("Le grade a été supprimé avec succès");
    }

}
