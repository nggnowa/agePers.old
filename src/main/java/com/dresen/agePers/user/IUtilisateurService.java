package com.dresen.agePers.user;

import java.util.List;

public interface IUtilisateurService {

    UtilisateurDto createUtilisateur(UtilisateurDto utilisateurDto);

    List<UtilisateurDto> getAllUtilisateurs();

    UtilisateurDto getUtilisateurById(Long id);

    UtilisateurDto updateUtilisateur(Long id, UtilisateurDto utilisateurDto);

    void deleteUtilisateur(Long id);

}
