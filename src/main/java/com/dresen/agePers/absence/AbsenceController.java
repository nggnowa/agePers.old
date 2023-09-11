package com.dresen.agePers.absence;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@AllArgsConstructor
@RestController
public class AbsenceController {

    private final AbsenceService service;

    @PostMapping("/enseignants/{id}/absences")
    public ResponseEntity<AbsenceDto> createAbsence(@PathVariable(name = "id") Long enseignantId, @RequestBody @Valid AbsenceDto absenceDto) {

        AbsenceDto saved = service.createAbsence(enseignantId, absenceDto);
        return new ResponseEntity<>(saved, CREATED);
    }

    @GetMapping("/absences")
    public ResponseEntity<List<AbsenceDto>> getAllAbsences() {

        List<AbsenceDto> absences = service.getAllAbsences();
        return ResponseEntity.ok(absences);
    }

    @GetMapping("/enseignants/{id}/absences")
    public ResponseEntity<List<AbsenceDto>> getAbsencesByEnseignantId(@PathVariable(name = "id") Long enseignantId) {

        List<AbsenceDto> absences = service.getAbsencesByEnseignantId(enseignantId);
        return ResponseEntity.ok(absences);
    }

    @GetMapping("/absences/{id}")
    public ResponseEntity<AbsenceDto> getAbsenceById(@PathVariable Long id) {

        AbsenceDto absenceDto = service.getAbsenceById(id);
        return ResponseEntity.ok(absenceDto);
    }

    @PutMapping("/absences/{id}")
    public ResponseEntity<AbsenceDto> updateAbsence(@PathVariable Long id, @RequestBody AbsenceDto absenceDto) {

        AbsenceDto updated = service.updateAbsence(id, absenceDto);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/absences/{id}")
    public ResponseEntity<String> deleteAbsence(@PathVariable Long id) {

        service.deleteAbsence(id);
        return ResponseEntity.ok(String.format("%s with id '%s' successfully deleted.", Absence.class.getSimpleName(), id));
    }

}
