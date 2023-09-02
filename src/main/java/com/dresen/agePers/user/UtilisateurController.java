package com.dresen.agePers.user;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@AllArgsConstructor
@RestController
@RequestMapping("/utilisateur")
public class UtilisateurController {

    private final UtilisateurService service;

    @PostMapping
    public ResponseEntity<UtilisateurDto> createUtilisateur(@RequestBody UtilisateurDto utilisateurDto) {

        UtilisateurDto saved = service.createUtilisateur(utilisateurDto);
        return new ResponseEntity<>(saved, CREATED);
    }

    @GetMapping
    public ResponseEntity<List<UtilisateurDto>> getAllUtilisateurs() {

        List<UtilisateurDto> utilisateurs = service.getAllUtilisateurs();
        return ResponseEntity.ok(utilisateurs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UtilisateurDto> getUtilisateurById(@PathVariable Long id) {

        UtilisateurDto utilisateurDto = service.getUtilisateurById(id);
        return ResponseEntity.ok(utilisateurDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UtilisateurDto> createUtilisateur(@PathVariable Long id, @RequestBody UtilisateurDto utilisateurDto) {

        UtilisateurDto updated = service.updateUtilisateur(id, utilisateurDto);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> createUtilisateur(@PathVariable Long id) {

        service.deleteUtilisateur(id);
        return ResponseEntity.ok("L'utilisateur a été supprimée avec succès");
    }

}
