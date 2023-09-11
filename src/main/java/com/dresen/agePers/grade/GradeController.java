package com.dresen.agePers.grade;

import com.dresen.agePers.region.Region;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/grades")
public class GradeController {

    private final GradeService service;

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
    public ResponseEntity<GradeDto> updateGrade(@PathVariable Long id, @RequestBody @Valid GradeDto gradeDto) {

        GradeDto updated = service.updateGrade(id, gradeDto);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteGrade(@PathVariable Long id) {

        service.deleteGrade(id);
        return ResponseEntity.ok(String.format("%s with id '%s' successfully deleted.", Region.class.getSimpleName(), id));
    }

}
