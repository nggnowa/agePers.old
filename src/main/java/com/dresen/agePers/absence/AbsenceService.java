package com.dresen.agePers.absence;

import com.dresen.agePers.enseignant.Enseignant;
import com.dresen.agePers.enseignant.EnseignantRepository;
import com.dresen.agePers.exceptioin.ResourceNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class AbsenceService implements AbsenceIService {

    private final EnseignantRepository enseignantRepository;

    private final AbsenceRepository repository;
    private final AbsenceDtoMapper  dtoMapper;


    @Override
    public AbsenceDto createAbsence(Long enseignantId, AbsenceDto absenceDto) {

        Optional<Enseignant> enseignantById = enseignantRepository.findById(enseignantId);

        if (enseignantById.isEmpty()) {
            throw new ResourceNotFoundException(Enseignant.class.getSimpleName(), "id", enseignantId);
        }

        Absence saved = repository.save(
                new Absence(
                        absenceDto.id(),
                        absenceDto.nature(),
                        absenceDto.motif(),
                        absenceDto.dateDepart(),
                        absenceDto.dateRetour(),
                        absenceDto.duree(),
                        enseignantById.get()
                )
        );

        return dtoMapper.apply(saved);
    }

    @Override
    public List<AbsenceDto> getAllAbsences() {

        List<Absence> absences = repository.findAll();
        return absences.stream().map(dtoMapper).collect(Collectors.toList());

    }

    @Override
    public List<AbsenceDto> getAbsencesByEnseignantId(Long enseignantId) {

        Optional<Enseignant> enseignantById = enseignantRepository.findById(enseignantId);

        if (enseignantById.isEmpty()) {
            throw new ResourceNotFoundException(Enseignant.class.getSimpleName(), "id", enseignantId);
        }

        List<Absence> absences = repository.findAbsencesByEnseignantId(enseignantId);
        return absences.stream().map(dtoMapper).collect(Collectors.toList());
    }

    @Override
    public AbsenceDto getAbsenceById(Long id) {

        Absence absence = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException(Absence.class.getSimpleName(), "id", id)
        );

        return dtoMapper.apply(absence);
    }

    @Override
    public AbsenceDto updateAbsence(Long id, AbsenceDto absenceDto) {

        Absence absence = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException(Absence.class.getSimpleName(), "id", id)
        );

        absence.setId(absenceDto.id());
        absence.setMotif(absenceDto.motif());
        absence.setDateDepart(absenceDto.dateDepart());
        absence.setDateRetour(absenceDto.dateRetour());
        absence.setEnseignant(absenceDto.enseignant());

        Absence saved = repository.save(absence);

        return dtoMapper.apply(saved);
    }

    @Override
    public void deleteAbsence(Long id) {

        Absence absence = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException(Absence.class.getSimpleName(), "id", id)
        );

        repository.delete(absence);

    }

}
