package com.dresen.agePers.absence;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@AllArgsConstructor
@RestController
@RequestMapping("/absence")
public class AbsenceController {

    private final AbsenceService service;

    @PostMapping
    public ResponseEntity<AbsenceDto> createAbsence(@RequestBody AbsenceDto absenceDto) {

        AbsenceDto saved = service.createAbsence(absenceDto);
        return new ResponseEntity<>(saved, CREATED);
    }

    @GetMapping
    public ResponseEntity<List<AbsenceDto>> getAllAbsences() {

        List<AbsenceDto> absences = service.getAllAbsences();
        return ResponseEntity.ok(absences);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AbsenceDto> getAbsenceById(@PathVariable Long id) {

        AbsenceDto absenceDto = service.getAbsenceById(id);
        return ResponseEntity.ok(absenceDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AbsenceDto> createAbsence(@PathVariable Long id, @RequestBody AbsenceDto absenceDto) {

        AbsenceDto updated = service.updateAbsence(id, absenceDto);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> createAbsence(@PathVariable Long id) {

        service.deleteAbsence(id);
        return ResponseEntity.ok("L'absence a été supprimée avec succès");
    }

}
