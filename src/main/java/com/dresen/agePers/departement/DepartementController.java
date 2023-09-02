package com.dresen.agePers.departement;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@AllArgsConstructor
@RestController
@RequestMapping("/departement")
public class DepartementController {

    private final DepartementService service;

    @PostMapping
    public ResponseEntity<DepartementDto> createDepartement(@RequestBody DepartementDto toCreate) {

        DepartementDto created = service.createDepartement(toCreate);
        return new ResponseEntity<>(created, CREATED);
    }

    @GetMapping
    public ResponseEntity<List<DepartementDto>> getAllDepartements() {

        List<DepartementDto> departementDtos = service.getAllDepartements();
        return ResponseEntity.ok(departementDtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DepartementDto> getDepartementById(@PathVariable Long id) {

        DepartementDto departementDto = service.getDepartementById(id);
        return ResponseEntity.ok(departementDto);

    }

    @PutMapping
    public ResponseEntity<DepartementDto> updateDepartement(@PathVariable Long id, @RequestBody DepartementDto toUpdate) {

        DepartementDto updated = service.updateDepartement(id, toUpdate);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDepartement(@PathVariable Long id) {

        service.delelteDepartement(id);
        return ResponseEntity.ok("Le département a été supprimé avec succès");
    }

}
