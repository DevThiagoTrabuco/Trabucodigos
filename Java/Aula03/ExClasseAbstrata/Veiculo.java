public abstract class Veiculo {
    protected String marca, modelo;
    protected int ano;

    public Veiculo(String marca, String modelo, int ano){
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
    }

    public abstract void acelerar();

    @SuppressWarnings("unused")
    public static void main(String[] args) {
        Veiculo v = new Veiculo("Ford", "Focus", 2000) {

            @Override
            public void acelerar() {}
            
        };
    }
}
