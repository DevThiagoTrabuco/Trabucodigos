package Simulado.Questao03;

import java.util.ArrayList;
import java.util.List;

public class GerenteProdutos {
    protected List<Produto> comprados = new ArrayList<>();
    protected List<ProdutoFabricado> fabricados = new ArrayList<>();

    public List<String> ingredientes(String nome){
        List<String> ingredientes = new ArrayList<>();

        for(ProdutoFabricado criado : fabricados){
            if(criado.getNome().equals(nome)){
                for (int i = 0; i < criado.getIngredientes(); i++) {
                    ingredientes.add(criado.getIngrediente(i).getNome());
                }
            }
        }
        return ingredientes;
    }

    public float valorCompra(String nome){
        float custo = 0;

        for(Produto material : comprados){
            if(material.getNome().equals(nome)){
                custo+=material.getCusto();
            }
        }
        return custo;
    }
}