package com.dresen.agePers.enseignant;

import com.dresen.agePers.arrondissement.Arrondissement;
import com.dresen.agePers.departement.Departement;
import com.dresen.agePers.diplome.Diplome;
import com.dresen.agePers.discipline.Discipline;
import com.dresen.agePers.enseignant.enums.*;
import com.dresen.agePers.ethnie.Ethnie;
import com.dresen.agePers.formation.Formation;
import com.dresen.agePers.grade.Grade;
import com.dresen.agePers.region.Region;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.TemporalAmount;
import java.util.List;

import static jakarta.persistence.EnumType.STRING;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "enseignant")
public class Enseignant {

    private static final TemporalAmount AGE_RETRAITE = Period.of(60, 0, 0);

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nom;

    @Column(nullable = false)
    @Enumerated(STRING)
    private Sexe sexe;

    @Column(nullable = false)
    private LocalDate dateNaissance;

    @Column(nullable = false)
    private String lieuNaissance;

    @Column(unique = true, nullable = false)
    private String matricule;

    @Column(nullable = false)
    @Enumerated(STRING)
    private Categorie categorie;

    @Column(nullable = false)
    @Enumerated(STRING)
    private Statut statut;

    @Column(nullable = false)
    private LocalDate dateEntreeService;

    @Transient
    private Integer anciennete;

    @Transient
    private LocalDate dateRetraite;

    @Column(nullable = false)
    @Enumerated(STRING)
    private Langue langueTravail;

    @Column(nullable = false)
    @Enumerated(STRING)
    private Presence presence;

    @Column(unique = true, nullable = false)
    private String telephone;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    @Enumerated(STRING)
    private StatutMedical statutMedical;

    @Column(nullable = false)
    @Enumerated(STRING)
    private StatutMatrimonial statutMatrimonial;

    private Integer nombreEnfant = 0;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "region_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Region regionOrigine;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "departement_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Departement departementOrigine;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "arrondissement_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Arrondissement arrondissementOrigine;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "ethnie_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Ethnie ethnie;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "grade_id")
    private Grade grade;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "formation_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Formation formation;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "discipline_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Discipline discipline;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = CascadeType.MERGE)
    @JoinTable(
            name = "enseignant_diplomes",
            joinColumns = {@JoinColumn(name = "enseignant_id")},
            inverseJoinColumns = {@JoinColumn(name = "diplome_id")}
    )
    private List<Diplome> diplomes;

    public LocalDate getDateRetraite() {

        return dateNaissance.plus(AGE_RETRAITE);
    }

    public Integer getAnciennete() {

        return Period.between(dateEntreeService, LocalDate.now()).getYears();
    }

}
