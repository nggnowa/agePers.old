package com.dresen.agePers.departement;

import com.dresen.agePers.region.Region;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@AllArgsConstructor
@RestController
public class DepartementController {

    private final DepartementService service;

    @PostMapping("/regions/{id}/departements")
    public ResponseEntity<DepartementDto> createDepartement(@PathVariable(name = "id") Long regionId, @RequestBody @Valid DepartementDto toCreate) {

        DepartementDto created = service.createDepartement(regionId, toCreate);
        return new ResponseEntity<>(created, CREATED);
    }

    @GetMapping("/departements")
    public ResponseEntity<List<DepartementDto>> getAllDepartements() {

        List<DepartementDto> departementDtos = service.getAllDepartements();
        return ResponseEntity.ok(departementDtos);
    }

    @GetMapping("/regions/{id}/departements")
    public ResponseEntity<List<DepartementDto>> getDepartementsByRegionId(@PathVariable(name = "id") Long regionId) {

        List<DepartementDto> departementDtos = service.getDepartementsByRegionId(regionId);
        return ResponseEntity.ok(departementDtos);
    }

    @GetMapping("/departements/{id}")
    public ResponseEntity<DepartementDto> getDepartementById(@PathVariable Long id) {

        DepartementDto departementDto = service.getDepartementById(id);
        return ResponseEntity.ok(departementDto);

    }

    @PutMapping("/departements/{id}")
    public ResponseEntity<DepartementDto> updateDepartement(@PathVariable Long id, @RequestBody @Valid DepartementDto toUpdate) {

        DepartementDto updated = service.updateDepartement(id, toUpdate);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/departements/{id}")
    public ResponseEntity<String> deleteDepartement(@PathVariable Long id) {

        service.delelteDepartement(id);
        return ResponseEntity.ok(String.format("%s with id '%s' successfully deleted.", Departement.class.getSimpleName(), id));
    }

    @DeleteMapping("regions/{id}/departements")
    public ResponseEntity<String> deleteDepartementsByRegionId(@PathVariable(name = "id") Long regionId) {

        service.delelteDepartementsByRegionId(regionId);
        return ResponseEntity.ok(
                String.format("All %ss of %s with id '%s' successfully deleted.",
                              Departement.class.getSimpleName(),
                              Region.class.getSimpleName(),
                              regionId));
    }

}
