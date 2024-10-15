package Simulado.Questao04;

public class DespesasDia extends DespesasMes{
    @SuppressWarnings("FieldMayBeFinal")
    private int dia;

    public DespesasDia(int dia, int mes, float valor) {
        super(mes, valor);
        this.dia = dia;
    }

    public int getDia() {
        return dia;
    }
    
}
