package com.dresen.agePers.region;

import java.util.List;

public interface IRegionService {

    RegionDto createRegion(RegionDto regionDto);

    List<RegionDto> getAllRegions();

    RegionDto getRegionById(Long id);

    RegionDto getRegionByCode(String code);

    RegionDto updateRegion(Long id, RegionDto regionDto);

    void deleteRegion(Long id);

}
