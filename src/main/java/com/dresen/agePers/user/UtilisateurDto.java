package com.dresen.agePers.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UtilisateurDto(
        Long id,
        @NotBlank
        String nom,
        @Email
        String email,
        Role profil
) {

}
