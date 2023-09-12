package com.dresen.agePers.grade;

import java.util.List;

public interface GradeIService {

    List<GradeDto> getAllGrades();

    GradeDto getGradeById(Long id);

    GradeDto updateGrade(Long id, GradeDto gradeDto);

    void deleteGrade(Long id);

}
