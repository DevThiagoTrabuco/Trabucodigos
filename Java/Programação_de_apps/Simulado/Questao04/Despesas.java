package Simulado.Questao04;

import java.util.ArrayList;
import java.util.List;

public class Despesas {
    List<DespesasMes> despesaMes = new ArrayList<>();
    @SuppressWarnings("FieldMayBeFinal")
    private String cpf;

    public Despesas(List<DespesasMes> despesasMes, String cpf) {
        this.despesaMes = despesasMes;
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }

    public DespesasMes totalizaMes(int mes){
        float total = 0;
        for(DespesasMes despesa : despesaMes){
            if(despesa.getMes() == mes){
                total += despesa.getValor();
            }
        }
        DespesasMes despesa = new DespesasMes(mes, total);
        return despesa;
    }

}
