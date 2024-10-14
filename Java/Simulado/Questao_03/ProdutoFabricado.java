package Simulado.Questao_03;

import java.util.ArrayList;
import java.util.List;

public abstract class ProdutoFabricado implements IfProdutoFabricado{
    protected String nome;
    protected float custo;
    List<Produto> ingredientes = new ArrayList<>();

    @Override
    public String getNome(){
        return nome;
    }
    @Override
    public float getCusto(){
        return custo;
    }
    @Override
    public int getIngredientes(){
        int numIngrediente = 0;

        for(Produto ingrediente : ingredientes){
            if(!ingrediente.getNome().isEmpty()){
                numIngrediente++;
                custo+=ingrediente.getCusto();
            }
        }

        return numIngrediente;
    }

    @Override
    public IfProduto getIngrediente(int num){
        return ingredientes.get(num);
    }
}
