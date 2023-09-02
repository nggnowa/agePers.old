package com.dresen.agePers.diplome;

import com.dresen.agePers.enseignant.Enseignant;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "diplome")
public class Diplome {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;

    private String code;

    @Enumerated(EnumType.STRING)
    private Cycle cycle;

    @ManyToOne
    @JoinColumn(name = "enseignant_id")
    @JsonBackReference
    private Enseignant enseignant;

}
