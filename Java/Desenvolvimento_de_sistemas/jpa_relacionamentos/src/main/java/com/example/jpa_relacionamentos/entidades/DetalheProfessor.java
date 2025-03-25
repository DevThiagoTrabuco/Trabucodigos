package com.example.jpa_relacionamentos.entidades;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "detalhe_professor")
public class DetalheProfessor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_detalhe_professor")
    private int id;

    @Column(name = "hobby_professor")
    private String hobby;

    @Column(name = "linkedin_professor")
    private String linkedin;
}
