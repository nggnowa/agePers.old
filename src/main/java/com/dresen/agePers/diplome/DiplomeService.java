package com.dresen.agePers.diplome;

import com.dresen.agePers.enseignant.Enseignant;
import com.dresen.agePers.enseignant.EnseignantRepository;
import com.dresen.agePers.exceptioin.ResourceNotFoundException;
import com.dresen.agePers.exceptioin.ResourceTakenException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class DiplomeService implements DiplomeIService {

    private final EnseignantRepository enseignantRepository;

    private final DiplomeRepository repository;
    private final DiplomeDtoMapper  dtoMapper;

    @Override
    public DiplomeDto createDiplome(DiplomeDto diplomeDto) {

        Optional<Diplome> diplomeByNom  = repository.findByNom(diplomeDto.nom());
        Optional<Diplome> diplomeByCode = repository.findByCode(diplomeDto.code());

        if (diplomeByNom.isPresent()) {
            throw new ResourceTakenException(Diplome.class.getSimpleName(), "nom", diplomeDto.nom());
        }
        if (diplomeByCode.isPresent()) {
            throw new ResourceTakenException(Diplome.class.getSimpleName(), "code", diplomeDto.code());
        }

        Diplome saved = repository.save(
                new Diplome(
                        diplomeDto.id(),
                        diplomeDto.nom(),
                        diplomeDto.code()
                )
        );

        return dtoMapper.apply(saved);
    }

    @Override
    public DiplomeDto createDiplome(Long enseignantId, DiplomeDto diplomeDto) {

        Optional<Enseignant> enseignantById = enseignantRepository.findById(enseignantId);

        if (enseignantById.isEmpty()) {
            throw new ResourceNotFoundException(Enseignant.class.getSimpleName(), "id", enseignantId);
        }

        Optional<Diplome> diplomeByNom = repository.findByNom(diplomeDto.nom());

        if (diplomeByNom.isPresent()) {
            throw new ResourceTakenException(Diplome.class.getSimpleName(), "nom", diplomeDto.nom());
        }

        Optional<Diplome> diplomeByCode = repository.findByCode(diplomeDto.code());
        if (diplomeByCode.isPresent()) {
            throw new ResourceTakenException(Diplome.class.getSimpleName(), "code", diplomeDto.code());
        }

        Diplome saved = repository.save(
                new Diplome(
                        diplomeDto.id(),
                        diplomeDto.nom(),
                        diplomeDto.code()
                )
        );

        return dtoMapper.apply(saved);
    }

    @Override
    public List<DiplomeDto> getAllDiplomes() {

        List<Diplome> diplomes = repository.findAll();
        return diplomes.stream().map(dtoMapper).collect(Collectors.toList());

    }

    @Override
    public List<DiplomeDto> getDiplomesByEnseignantId(Long enseignantId) {

        if (!enseignantRepository.existsById(enseignantId)) {
            throw new ResourceNotFoundException(Enseignant.class.getSimpleName(), "id", enseignantId);
        }

        List<Diplome> diplomes = repository.findDiplomesByEnseignantsId(enseignantId);
        return diplomes.stream().map(dtoMapper).collect(Collectors.toList());
    }

    @Override
    public DiplomeDto getDiplomeById(Long id) {

        Diplome diplome = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException(Diplome.class.getSimpleName(), "id", id)
        );

        return dtoMapper.apply(diplome);
    }

    @Override
    public DiplomeDto updateDiplome(Long id, DiplomeDto diplomeDto) {

        Diplome diplome = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException(Diplome.class.getSimpleName(), "id", id)
        );

        if (!diplome.getNom().equals(diplomeDto.nom())) {

            Optional<Diplome> diplomeByNom = repository.findByNom(diplomeDto.nom());

            if (diplomeByNom.isPresent()) {
                throw new ResourceTakenException(Diplome.class.getSimpleName(), "nom", diplomeDto.nom());
            }
            diplome.setNom(diplomeDto.nom());
        }


        if (!diplome.getCode().equals(diplomeDto.code())) {

            Optional<Diplome> diplomeByCode = repository.findByCode(diplomeDto.code());

            if (diplomeByCode.isPresent()) {
                throw new ResourceTakenException(Diplome.class.getSimpleName(), "code", diplomeDto.code());
            }
            diplome.setCode(diplomeDto.code());
        }

        Diplome saved = repository.save(diplome);
        return dtoMapper.apply(saved);
    }

    @Override
    public void deleteDiplome(Long id) {

        Diplome diplome = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException(Diplome.class.getSimpleName(), "id", id)
        );

        repository.delete(diplome);

    }

}
