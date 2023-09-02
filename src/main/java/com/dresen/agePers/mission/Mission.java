package com.dresen.agePers.mission;

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
@Table(name = "mission")
public class Mission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String objet;

    @Column(name = "date_depart")
    private LocalDate dateDepart;

    @Column(name = "date_retour")
    private LocalDate dateRetour;

    @Transient
    private Integer duree; //en nombre de jours

    @ManyToMany
    @JoinTable(
            name = "enseignant_mission",
            joinColumns = @JoinColumn(name = "enseignant_id"),
            inverseJoinColumns = @JoinColumn(name = "mission_id")
    )
    private List<Enseignant> enseignants;

    public Integer getDuree() {

        return Period.between(dateDepart, dateRetour).getDays();
    }

}
