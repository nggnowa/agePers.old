package com.dresen.agePers.absence;

import java.util.List;

public interface IAbsenceService {

    AbsenceDto createAbsence(Long enseignantId, AbsenceDto absenceDto);

    List<AbsenceDto> getAllAbsences();

    List<AbsenceDto> getAbsencesByEnseignantId(Long enseignantId);

    AbsenceDto getAbsenceById(Long id);

    AbsenceDto updateAbsence(Long id, AbsenceDto absenceDto);

    void deleteAbsence(Long id);

}
