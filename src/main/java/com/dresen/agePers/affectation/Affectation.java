package com.dresen.agePers.affectation;

import com.dresen.agePers.enseignant.Enseignant;
import com.dresen.agePers.etablissement.Etablissement;
import com.dresen.agePers.poste.Poste;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDate;
import java.time.Period;

import static jakarta.persistence.EnumType.STRING;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "affectation")
public class Affectation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String referenceAffectation;

    @Column(nullable = false)
    private LocalDate dateAffectation;

    private LocalDate datePriseService;

    @Column(nullable = false)
    @Enumerated(STRING)
    private DelegationEN delegation;

    @Transient
    private Integer anciennete;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "enseignant_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Enseignant enseignant;

    @OneToOne
    @JoinColumn(name = "poste_id")
    private Poste poste;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "etablissement_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Etablissement etablissement;

    public Integer getAnciennete() {

        return Period.between(datePriseService, LocalDate.now()).getYears();
    }

}
