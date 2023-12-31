package com.dresen.agePers.departement;

import java.util.List;

public interface DepartementIService {

    DepartementDto createDepartement(Long regionId, DepartementDto departementDto);

    List<DepartementDto> getAllDepartements();

    List<DepartementDto> getDepartementsByRegionId(Long regionId);

    DepartementDto getDepartementById(Long id);


    DepartementDto updateDepartement(Long id, DepartementDto departementDto);

    void delelteDepartement(Long id);

    void delelteDepartementsByRegionId(Long id);

}
