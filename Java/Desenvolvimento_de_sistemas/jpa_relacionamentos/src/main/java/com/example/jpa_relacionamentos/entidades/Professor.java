package com.example.jpa_relacionamentos.entidades;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "professor")
public class Professor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_professor")
    private int id;

    @Column(name = "nome_professor")
    private String nome;

    @Column(name = "idade_professor")
    private int idade;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_detalhe_professor", referencedColumnName = "id_detalhe_professor")
    private DetalheProfessor detalheProfessor;

    @OneToMany(mappedBy = "professor", cascade = CascadeType.ALL)
    private List<Curso> cursos = new ArrayList<>();
}
