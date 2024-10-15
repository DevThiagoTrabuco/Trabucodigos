package Simulado.Questao03;

public class Produto implements IfProduto{
    protected String nome;
    protected float custo;

    public Produto(String nome, float custo){
        this.nome = nome;
        this.custo = custo;
    }

    @Override
    public String getNome(){
        return nome;
    }
    @Override
    public float getCusto(){
        return custo;
    }
}
