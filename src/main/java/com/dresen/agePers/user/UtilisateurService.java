package com.dresen.agePers.user;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class UtilisateurService implements IUtilisateurService {

    private final UtilisateurRepository repository;
    private final UtilisateurDtoMapper  dtoMapper;

    @Override
    public UtilisateurDto createUtilisateur(UtilisateurDto utilisateurDto) {

        Utilisateur saved = repository.save(
                new Utilisateur(
                        utilisateurDto.id(),
                        utilisateurDto.nom(),
                        utilisateurDto.email(),
                        utilisateurDto.profil()
                )
        );

        return dtoMapper.apply(saved);
    }

    @Override
    public List<UtilisateurDto> getAllUtilisateurs() {

        List<Utilisateur> utilisateurs = repository.findAll();
        return utilisateurs.stream().map(dtoMapper).collect(Collectors.toList());

    }

    @Override
    public UtilisateurDto getUtilisateurById(Long id) {

        Utilisateur utilisateur = repository.findById(id).orElseThrow(
                () -> new RuntimeException("L'utilisateur n'existe pas.")
        );

        return dtoMapper.apply(utilisateur);
    }

    @Override
    public UtilisateurDto updateUtilisateur(Long id, UtilisateurDto utilisateurDto) {

        Utilisateur utilisateur = repository.findById(id).orElseThrow(
                () -> new RuntimeException("L'utilisateur n'existe pas.")
        );

        utilisateur.setNom(utilisateurDto.nom());
        Utilisateur saved = repository.save(utilisateur);

        return dtoMapper.apply(saved);
    }

    @Override
    public void deleteUtilisateur(Long id) {

        Utilisateur utilisateur = repository.findById(id).orElseThrow(
                () -> new RuntimeException("L'utilisateur n'existe pas.")
        );

        repository.delete(utilisateur);

    }

}
