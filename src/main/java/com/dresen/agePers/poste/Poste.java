package com.dresen.agePers.poste;

import com.dresen.agePers.poste.enums.Rang;
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
@Table(name = "poste")
public class Poste {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String titre;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Rang rang;

}
