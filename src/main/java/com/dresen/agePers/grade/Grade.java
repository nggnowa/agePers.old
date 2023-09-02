package com.dresen.agePers.grade;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "grade")
public class Grade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private IntituleGrade grade;

    @Column(nullable = false)
    private String classe;

    @Column(nullable = false)
    private Integer echelon;

    @Column(nullable = false)
    private Integer indice;

}
