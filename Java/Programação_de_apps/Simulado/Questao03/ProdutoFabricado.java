package Simulado.Questao03;

import java.util.ArrayList;
import java.util.List;

public abstract class ProdutoFabricado implements IfProdutoFabricado{
    @SuppressWarnings("FieldMayBeFinal")
    private String nome;
    @SuppressWarnings("FieldMayBeFinal")
    private List<Produto> ingredientes = new ArrayList<>();

    public ProdutoFabricado(String nome, List<Produto> ingredientes) {
        this.nome = nome;
        this.ingredientes = ingredientes;
    }

    @Override
    public String getNome(){
        return nome;
    }
    @Override
    public float getCusto(){
        float custo = 0;

        for(Produto ingrediente : ingredientes){
            if(!ingrediente.getNome().isEmpty()){
                custo+=ingrediente.getCusto();
            }
        }
        return custo;
    }
    @Override
    public int getIngredientes(){
        return ingredientes.size();
    }
    @Override
    public IfProduto getIngrediente(int num){
        return ingredientes.get(num);
    }
}
