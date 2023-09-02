package com.dresen.agePers.etablissement;

import com.dresen.agePers.affectation.Affectation;
import com.dresen.agePers.arrondissement.Arrondissement;
import com.dresen.agePers.departement.Departement;
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
@Table(name = "etablissement")
public class Etablissement {

    @Id
    @GeneratedValue
    private Long id;

    @Column(
            nullable = false,
            unique = true
    )
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

    @OneToOne
    @JoinColumn(name = "departement_id")
    private Departement departement;

    @OneToOne
    @JoinColumn(name = "arrondissement_id")
    private Arrondissement arrondissement;

    @OneToOne
    @JoinColumn(name = "affectation_id")
    private Affectation affectation;


}
