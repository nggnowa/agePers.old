package com.dresen.agePers.region;

import java.util.List;

public interface RegionIService {

    RegionDto createRegion(RegionDto regionDto);

    List<RegionDto> getAllRegions();

    RegionDto getRegionById(Long id);

    RegionDto updateRegion(Long id, RegionDto regionDto);

    void deleteRegion(Long id);

}
