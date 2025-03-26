package com.example.jpa_relacionamentos.entidades;

import java.util.List;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "curso")
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_curso")
    private int id;

    @Column(name = "nome_curso")
    private String nome;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType. MERGE})
    @JoinColumn(name = "id_professor", referencedColumnName = "id_professor")
    private Professor professor;

    @OneToMany(mappedBy = "curso", cascade = {CascadeType.PERSIST, CascadeType. MERGE})
    private List<CursoEstudante> cursoEstudantes;
}
