package com.thiago.atividade_lanche03.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name = "lanche")
public class Lanche {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "image")
    private String image;

    @Column(name = "price")
    private double price;

    @Column(name = "code")
    private int code;

    @Override
    public String toString() {
        return "Lanche [name=" + name 
        + ", imagePath=" + image
        + ", price=" + price 
        + ", code=" + code 
        + "]";
    }
}
