package com.dresen.agePers.region;

import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class RegionDtoMapper implements Function<Region, RegionDto> {

    @Override
    public RegionDto apply(Region region) {

        return new RegionDto(
                region.getId(),
                region.getNom(),
                region.getCode()
        );
    }

}
