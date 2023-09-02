package com.dresen.agePers.absence;

import com.dresen.agePers.enseignant.Enseignant;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "absence")
public class Absence {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String motif;

    @Column(name = "date_depart")
    private LocalDate dateDepart;

    @Column(name = "date_retour")
    private LocalDate dateRetour;

    @Transient
    private Integer duree; //en nombre de jours

    @ManyToMany
    @JoinTable(
            name = "enseignant_absence",
            joinColumns = @JoinColumn(name = "enseignant_id"),
            inverseJoinColumns = @JoinColumn(name = "absence_id")
    )
    private List<Enseignant> enseignants;

    public Integer getDuree() {

        return Period.between(dateDepart, dateRetour).getDays();
    }
}
