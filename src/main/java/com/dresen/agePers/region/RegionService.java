package com.dresen.agePers.region;

import com.dresen.agePers.exceptioin.ResourceNotFoundException;
import com.dresen.agePers.exceptioin.ResourceTakenException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class RegionService implements IRegionService {

    private final RegionRepository repository;

    private final RegionDtoMapper dtoMapper;

    @Override
    public RegionDto createRegion(RegionDto regionDto) {

        Optional<Region> regionByNom  = repository.findByNom(regionDto.nom());
        Optional<Region> regionByCode = repository.findByCode(regionDto.code());

        if (regionByNom.isPresent()) {
            throw new ResourceTakenException(Region.class.getSimpleName(), "nom", regionDto.nom());
        }
        if (regionByCode.isPresent()) {
            throw new ResourceTakenException(Region.class.getSimpleName(), "code", regionDto.code());
        }

        Region savedRegion = repository.save(
                new Region(
                        regionDto.id(),
                        regionDto.nom(),
                        regionDto.code()
                )
        );
        return dtoMapper.apply(savedRegion);
    }

    @Override
    public List<RegionDto> getAllRegions() {

        List<Region> regions = repository.findAll();
        return regions.stream().map(dtoMapper).collect(Collectors.toList());
    }

    @Override
    public RegionDto getRegionById(Long id) {

        Region region = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException(Region.class.getSimpleName(), "id", id)
        );

        return dtoMapper.apply(region);
    }

    @Override
    public RegionDto getRegionByCode(String code) {

        Region region = repository.findByCode(code).orElseThrow(
                () -> new ResourceNotFoundException(Region.class.getSimpleName(), "code", code)
        );

        return dtoMapper.apply(region);
    }

    @Override
    public RegionDto updateRegion(Long id, RegionDto regionDto) {

        Region region = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException(Region.class.getSimpleName(), "id", id)
        );

        if (!region.getNom().equals(regionDto.nom())) {

            Optional<Region> regionByNom = repository.findByNom(regionDto.nom());
            if (regionByNom.isPresent()) {
                throw new ResourceTakenException(Region.class.getSimpleName(), "nom", regionDto.nom());
            }

            region.setNom(regionDto.nom());
        }

        if (!region.getCode().equals(regionDto.code())) {

            Optional<Region> regionByCode = repository.findByCode(regionDto.code());
            if (regionByCode.isPresent()) {
                throw new ResourceTakenException(Region.class.getSimpleName(), "code", regionDto.code());
            }

            region.setCode(regionDto.code());
        }

        Region updatedRegion = repository.save(region);
        return dtoMapper.apply(updatedRegion);
    }

    @Override
    public void deleteRegion(Long id) {

        Region region = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException(Region.class.getSimpleName(), "id", id)
        );

        repository.delete(region);

    }
}
