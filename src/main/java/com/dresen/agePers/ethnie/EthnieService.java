package com.dresen.agePers.ethnie;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class EthnieService implements IEthnieService {

    private final EthnieRepository repository;
    private final EthnieDtoMapper  dtoMapper;

    @Override
    public EthnieDto createEthnie(EthnieDto ethnieDto) {

        Ethnie saved = repository.save(
                new Ethnie(
                        ethnieDto.id(),
                        ethnieDto.nom()
                )
        );

        return dtoMapper.apply(saved);
    }

    @Override
    public List<EthnieDto> getAllEthnies() {

        List<Ethnie> ethnies = repository.findAll();
        return ethnies.stream().map(dtoMapper).collect(Collectors.toList());

    }

    @Override
    public EthnieDto getEthnieById(Long id) {

        Ethnie ethnie = repository.findById(id).orElseThrow(
                () -> new RuntimeException("L'ethnie n'existe pas.")
        );

        return dtoMapper.apply(ethnie);
    }

    @Override
    public EthnieDto updateEthnie(Long id, EthnieDto ethnieDto) {

        Ethnie ethnie = repository.findById(id).orElseThrow(
                () -> new RuntimeException("L'ethnie n'existe pas.")
        );

        ethnie.setNom(ethnieDto.nom());
        Ethnie saved = repository.save(ethnie);

        return dtoMapper.apply(saved);
    }

    @Override
    public void deleteEthnie(Long id) {

        Ethnie ethnie = repository.findById(id).orElseThrow(
                () -> new RuntimeException("L'ethnie n'existe pas.")
        );

        repository.delete(ethnie);

    }
}
