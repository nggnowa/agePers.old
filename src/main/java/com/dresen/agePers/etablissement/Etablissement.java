package com.dresen.agePers.etablissement;

import com.dresen.agePers.arrondissement.Arrondissement;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "etablissement")
public class Etablissement {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, unique = true)
    private String nom;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Categorie categorie;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private OrdreEnseignement ordreEnseignement;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private SousSysteme sousSysteme;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "arrondissement_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Arrondissement arrondissement;

}
