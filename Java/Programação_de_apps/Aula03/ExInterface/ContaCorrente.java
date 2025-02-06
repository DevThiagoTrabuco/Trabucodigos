package Aula03.ExInterface;

public class ContaCorrente implements Conta{
    private double saldo;

    public ContaCorrente(double saldo){
        this.saldo = saldo;
    }

    @Override
    public boolean depositar(double valor) {
        if(valor > 0){
            saldo += valor;
            return true;
        }
        return false;
    }

    @Override
    public boolean sacar(double valor) {
        if(valor <= saldo){
            saldo -= valor;
            return true;
        }
        return false;
    }

    @Override
    public String extrato() {
        return "Seu saldo é: " + saldo;
    }
    
}
