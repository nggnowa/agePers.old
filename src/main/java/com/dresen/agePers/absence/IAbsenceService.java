package com.dresen.agePers.absence;

import java.util.List;

public interface IAbsenceService {

    AbsenceDto createAbsence(AbsenceDto absenceDto);

    List<AbsenceDto> getAllAbsences();

    AbsenceDto getAbsenceById(Long id);

    AbsenceDto updateAbsence(Long id, AbsenceDto absenceDto);

    void deleteAbsence(Long id);

}
