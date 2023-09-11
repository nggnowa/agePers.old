package com.dresen.agePers.ethnie;

import com.dresen.agePers.exceptioin.ResourceNotFoundException;
import com.dresen.agePers.exceptioin.ResourceTakenException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class EthnieService implements IEthnieService {

    private final EthnieRepository repository;
    private final EthnieDtoMapper  dtoMapper;

    @Override
    public EthnieDto createEthnie(EthnieDto ethnieDto) {

        Optional<Ethnie> ethnieByNom = repository.findByNom(ethnieDto.nom());
        if (ethnieByNom.isPresent()) {
            throw new ResourceTakenException(Ethnie.class.getSimpleName(), "nom", ethnieDto.nom());
        }

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
                () -> new ResourceNotFoundException(Ethnie.class.getSimpleName(), "id", id)
        );

        return dtoMapper.apply(ethnie);
    }

    @Override
    public EthnieDto updateEthnie(Long id, EthnieDto ethnieDto) {

        Ethnie toUpdate = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException(Ethnie.class.getSimpleName(), "id", id)
        );

        if (!toUpdate.getNom().equals(ethnieDto.nom())) {
            Optional<Ethnie> ethnieByNom = repository.findByNom(ethnieDto.nom());
            if (ethnieByNom.isPresent()) {
                throw new ResourceTakenException(Ethnie.class.getSimpleName(), "nom", ethnieDto.nom());
            }

            toUpdate.setNom(ethnieDto.nom());
        }

        Ethnie saved = repository.save(toUpdate);
        return dtoMapper.apply(saved);
    }

    @Override
    public void deleteEthnie(Long id) {

        Ethnie ethnie = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException(Ethnie.class.getSimpleName(), "id", id)
        );

        repository.delete(ethnie);

    }
}
