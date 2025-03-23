package com.thiago.atividade_lanche03.entities;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "lanche")
public class Lanche {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "image")
    private String image;

    @Column(name = "price")
    private double price;

    @Override
    public String toString() {
        return "Lanche [id=" + id + 
        ", name=" + name + 
        ", image=" + image + 
        ", price=" + price + 
        "]";
    }

    public Lanche(String name, String image, double price) {
        this.name = name;
        this.image = image;
        this.price = price;
    }

}
