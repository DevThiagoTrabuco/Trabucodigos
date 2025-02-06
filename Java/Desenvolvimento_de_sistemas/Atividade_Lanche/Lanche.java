public class Lanche {
    
    private final String nome, img_url;
    private final double preco;
    private final int codigo;
    
    public Lanche(String nome, double preco, String img_url, int codigo) {
        this.nome = nome;
        this.preco = preco;
        this.img_url = img_url;
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public String getImg_url() {
        return img_url;
    }

    public double getPreco() {
        return preco;
    }

    public int getCodigo() {
        return codigo;
    }
}