package com.example.jpa_relacionamentos.entidades;

import java.util.List;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "estudante")
public class Estudante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_estudante")
    private int id;

    @Column(name = "nome_estudante")
    private String nome;

    @Column(name = "sobrenome_estudante")
    private String sobrenome;

    @Column(name = "email_estudante")
    private String email;

    @OneToMany(mappedBy = "estudante", cascade = {CascadeType.PERSIST, CascadeType. MERGE})
    private List<CursoEstudante> cursoEstudantes;
}
