package com.dresen.agePers.absence;

import com.dresen.agePers.enseignant.Enseignant;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDate;
import java.time.Period;

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
    @Enumerated(EnumType.STRING)
    private Nature nature; //persmission ou congé;

    private String motif;//s'il s'agit d'une permission

    @Column(name = "date_depart")
    private LocalDate dateDepart;

    @Column(name = "date_retour")
    private LocalDate dateRetour;

    @Transient
    private Integer duree; //en nombre de jours

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "enseignant_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Enseignant enseignant;

    public Integer getDuree() {

        return Period.between(dateDepart, dateRetour).getDays();
    }
}
