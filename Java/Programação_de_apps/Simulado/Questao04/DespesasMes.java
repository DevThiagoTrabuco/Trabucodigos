package Simulado.Questao04;

public class DespesasMes {
    @SuppressWarnings("FieldMayBeFinal")
    private int mes;
    @SuppressWarnings("FieldMayBeFinal")
    private float valor;

    public DespesasMes(int mes, float valor) {
        this.mes = mes;
        this.valor = valor;
    }

    public int getMes() {
        return mes;
    }

    public float getValor() {
        return valor;
    }

}
