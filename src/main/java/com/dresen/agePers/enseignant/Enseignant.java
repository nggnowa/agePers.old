package com.dresen.agePers.enseignant;

import com.dresen.agePers.absence.Absence;
import com.dresen.agePers.affectation.Affectation;
import com.dresen.agePers.arrondissement.Arrondissement;
import com.dresen.agePers.conge.Conge;
import com.dresen.agePers.departement.Departement;
import com.dresen.agePers.diplome.Diplome;
import com.dresen.agePers.discipline.Discipline;
import com.dresen.agePers.enseignant.enums.*;
import com.dresen.agePers.ethnie.Ethnie;
import com.dresen.agePers.formation.Formation;
import com.dresen.agePers.grade.Grade;
import com.dresen.agePers.mission.Mission;
import com.dresen.agePers.region.Region;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    @OneToOne
    @JoinColumn(name = "region_id")
    private Region regionOrigine;

    @OneToOne
    @JoinColumn(name = "departement_id")
    private Departement departementOrigine;

    @OneToOne
    @JoinColumn(name = "arrondissement_id")
    private Arrondissement arrondissementOrigine;

    @OneToOne
    @JoinColumn(name = "ethnie_id")
    private Ethnie ethnie;

    @OneToOne
    @JoinColumn(name = "grade_id")
    private Grade grade;

    @OneToOne
    @JoinColumn(name = "formation_id")
    private Formation formation;

    @OneToOne
    @JoinColumn(name = "discipline_id")
    private Discipline discipline;

    @OneToMany(mappedBy = "enseignant")
    @JsonManagedReference
    private List<Diplome> diplomes;

    @OneToMany(mappedBy = "enseignant")
    @JsonManagedReference
    private List<Affectation> affectations;

    @ManyToMany
    @JoinTable(name = "enseignant_mission")
    private List<Mission> missions;

    @ManyToMany
    @JoinTable(name = "enseignant_absence")
    private List<Absence> absences;

    @ManyToMany
    @JoinTable(name = "enseignant_conge")
    private List<Conge> conges;

    public LocalDate getDateRetraite() {

        return dateNaissance.plus(AGE_RETRAITE);
    }

    public Integer getAnciennete() {

        return Period.between(dateEntreeService, LocalDate.now()).getYears();
    }

}
