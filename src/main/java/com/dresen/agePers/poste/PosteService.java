package com.dresen.agePers.poste;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class PosteService implements IPosteService {

    private final PosteRepository repository;
    private final PosteDtoMapper  dtoMapper;

    @Override
    public PosteDto createPoste(PosteDto posteDto) {

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
                () -> new RuntimeException("Le poste n'existe pas.")
        );

        return dtoMapper.apply(poste);
    }

    @Override
    public PosteDto updatePoste(Long id, PosteDto posteDto) {

        Poste poste = repository.findById(id).orElseThrow(
                () -> new RuntimeException("Le poste n'existe pas.")
        );

        poste.setTitre(poste.getTitre());
        poste.setRang(poste.getRang());
        Poste saved = repository.save(poste);

        return dtoMapper.apply(saved);
    }

    @Override
    public void deletePoste(Long id) {

        Poste poste = repository.findById(id).orElseThrow(
                () -> new RuntimeException("Le poste n'existe pas.")
        );

        repository.delete(poste);

    }

}
