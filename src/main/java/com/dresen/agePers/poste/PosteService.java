package com.dresen.agePers.poste;

import com.dresen.agePers.exceptioin.ResourceNotFoundException;
import com.dresen.agePers.exceptioin.ResourceTakenException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class PosteService implements IPosteService {

    private final PosteRepository repository;
    private final PosteDtoMapper  dtoMapper;

    @Override
    public PosteDto createPoste(PosteDto posteDto) {

        Optional<Poste> posteByTitre = repository.findByTitre(posteDto.titre());

        if (posteByTitre.isPresent()) {
            throw new ResourceTakenException(Poste.class.getSimpleName(), "titre", posteDto.titre());
        }

        Poste saved = repository.save(
                new Poste(
                        posteDto.id(),
                        posteDto.titre(),
                        posteDto.rang()
                )
        );

        return dtoMapper.apply(saved);
    }

    @Override
    public List<PosteDto> getAllPostes() {

        List<Poste> postes = repository.findAll();
        return postes.stream().map(dtoMapper).collect(Collectors.toList());

    }

    @Override
    public PosteDto getPosteById(Long id) {

        Poste poste = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException(Poste.class.getSimpleName(), "id", id)
        );

        return dtoMapper.apply(poste);
    }

    @Override
    public PosteDto updatePoste(Long id, PosteDto posteDto) {

        Poste toUpdate = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException(Poste.class.getSimpleName(), "id", id)
        );

        if (!toUpdate.getTitre().equals(posteDto.titre())) {
            Optional<Poste> posteByTitre = repository.findByTitre(posteDto.titre());

            if (posteByTitre.isPresent()) {
                throw new ResourceTakenException(Poste.class.getSimpleName(), "titre", posteDto.titre());
            }
            toUpdate.setTitre(posteDto.titre());
        }

        toUpdate.setRang(posteDto.rang());

        Poste saved = repository.save(toUpdate);
        return dtoMapper.apply(saved);
    }

    @Override
    public void deletePoste(Long id) {

        Poste poste = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException(Poste.class.getSimpleName(), "id", id)
        );

        repository.delete(poste);

    }

}
