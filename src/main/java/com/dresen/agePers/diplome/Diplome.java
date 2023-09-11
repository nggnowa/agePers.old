package com.dresen.agePers.diplome;

import com.dresen.agePers.enseignant.Enseignant;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

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

    @Column(unique = true, nullable = false)
    private String nom;

    @Column(unique = true, nullable = false)
    private String code;

    @ManyToMany(
            fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            },
            mappedBy = "diplomes")
    @JsonIgnore
    private List<Enseignant> enseignants;

    public Diplome(Long id, String nom, String code) {

        this.id = id;
        this.nom = nom;
        this.code = code;

    }
}
