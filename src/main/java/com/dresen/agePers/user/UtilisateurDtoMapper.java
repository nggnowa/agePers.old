package com.dresen.agePers.user;

import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class UtilisateurDtoMapper implements Function<Utilisateur, UtilisateurDto> {

    @Override
    public UtilisateurDto apply(Utilisateur user) {

        return new UtilisateurDto(
                user.getId(),
                user.getNom(),
                user.getEmail(),
                user.getProfil()
        );
    }
}
