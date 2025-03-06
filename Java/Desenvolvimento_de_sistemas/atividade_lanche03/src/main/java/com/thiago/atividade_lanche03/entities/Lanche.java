package com.thiago.atividade_lanche03.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Lanche {
    private String name, imagePath;
    private double price;
    private int code;

    @Override
    public String toString() {
        return "Lanche [name=" + name 
        + ", imagePath=" + imagePath 
        + ", price=" + price 
        + ", code=" + code 
        + "]";
    }
}
