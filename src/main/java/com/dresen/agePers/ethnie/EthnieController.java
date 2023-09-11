package com.dresen.agePers.ethnie;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@AllArgsConstructor
@RestController
@RequestMapping("/ethnies")
public class EthnieController {

    private final EthnieService service;

    @PostMapping
    public ResponseEntity<EthnieDto> createEthnie(@RequestBody EthnieDto ethnieDto) {

        EthnieDto saved = service.createEthnie(ethnieDto);
        return new ResponseEntity<>(saved, CREATED);
    }

    @GetMapping
    public ResponseEntity<List<EthnieDto>> getAllEthnies() {

        List<EthnieDto> ehtnies = service.getAllEthnies();
        return ResponseEntity.ok(ehtnies);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EthnieDto> getEthnieById(@PathVariable Long id) {

        EthnieDto ethnieDto = service.getEthnieById(id);
        return ResponseEntity.ok(ethnieDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EthnieDto> updateEthnie(@PathVariable Long id, @RequestBody EthnieDto ethnieDto) {

        EthnieDto updated = service.updateEthnie(id, ethnieDto);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEthnie(@PathVariable Long id) {

        service.deleteEthnie(id);
        return ResponseEntity.ok(String.format("%s with id '%s' successfully deleted.", Ethnie.class.getSimpleName(), id));
    }


}
