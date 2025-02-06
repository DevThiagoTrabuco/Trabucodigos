package Aula05;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Pais {
    private String nome;

    public Pais (String nome){
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + Objects.hashCode(this.nome);
        return hash;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pais other = (Pais) obj;
        return Objects.equals(this.nome, other.nome);
    }

    public static void main(String[] args) {
        Set<Pais> paises = new HashSet<>();
        paises.add(new Pais("Brasil"));
        paises.add(new Pais("Alemanha"));
        paises.add(new Pais("Mexico"));
        paises.add(new Pais("Mexico"));
    
        System.out.println(paises.size());
    }
    
}
