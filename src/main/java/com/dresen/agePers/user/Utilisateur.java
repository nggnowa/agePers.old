package com.dresen.agePers.user;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "utilisateur")
public class Utilisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nom;

    @Column(
            unique = true,
            nullable = false
    )
    private String login;

    @Column(nullable = false)
    private String motDePasse;

    @Column(
            unique = true,
            nullable = false
    )
    private String email;

    private Role profil;

    public Utilisateur(Long id, String nom, String email, Role profil) {
        

    }
}
