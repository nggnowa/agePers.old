package com.dresen.agePers.conge;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class CongeService implements ICongeService {

    private final CongeRepository repository;

    private final CongeDtoMapper dtoMapper;

    @Override
    public CongeDto createConge(CongeDto congeDto) {

        Conge saved = repository.save(
                new Conge(
                        congeDto.id(),
                        congeDto.dateDepart(),
                        congeDto.dateRetour(),
                        congeDto.duree(),
                        congeDto.enseignants()
                )
        );

        return dtoMapper.apply(saved);
    }

    @Override
    public List<CongeDto> getAllConges() {

        List<Conge> conges = repository.findAll();
        return conges.stream().map(dtoMapper).collect(Collectors.toList());

    }

    @Override
    public CongeDto getCongeById(Long id) {

        Conge conge = repository.findById(id).orElseThrow(
                () -> new RuntimeException("Le conge n'existe pas.")
        );

        return dtoMapper.apply(conge);
    }

    @Override
    public CongeDto updateConge(Long id, CongeDto congeDto) {

        Conge conge = repository.findById(id).orElseThrow(
                () -> new RuntimeException("Le conge n'existe pas.")
        );

        conge.setId(congeDto.id());
        conge.setDateDepart(congeDto.dateDepart());
        conge.setDateRetour(congeDto.dateRetour());
        conge.setEnseignants(congeDto.enseignants());

        Conge saved = repository.save(conge);

        return dtoMapper.apply(saved);
    }

    @Override
    public void deleteConge(Long id) {

        Conge conge = repository.findById(id).orElseThrow(
                () -> new RuntimeException("Le conge n'existe pas.")
        );

        repository.delete(conge);

    }

}
