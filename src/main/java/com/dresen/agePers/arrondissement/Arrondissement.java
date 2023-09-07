package com.dresen.agePers.arrondissement;

import com.dresen.agePers.departement.Departement;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "arrondissement")
public class Arrondissement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    @NotBlank
    private String nom;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "departement_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Departement departement;


}
