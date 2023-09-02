package com.dresen.agePers.enseignant;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(path = "/enseignants")
public class EnseignantController {

	private EnseignantService enseignantService;

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<EnseignantDto> createEnseignant(@RequestBody EnseignantDto enseignantDto) {

		EnseignantDto savedEnseignant = enseignantService.createEnseignant(enseignantDto);
		return new ResponseEntity<>(savedEnseignant, HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<List<EnseignantDto>> getAllEnseignants() {

		List<EnseignantDto> enseignants = enseignantService.getAllEnseignants();

		return ResponseEntity.ok(enseignants);
	}

}
