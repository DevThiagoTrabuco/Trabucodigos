package Atividade08;

public class ContaInvestimento {
    private String accOwner, accNumber;
    private double balance, interestRate;

    public ContaInvestimento(String nome, String conta, double taxaJuro){
        this.accOwner = nome;
        this.accNumber = conta;
        this.balance = 0.0;
        this.interestRate = taxaJuro;
    }

    public String getaccOwner(){
        return accOwner;
    }
    public String getaccNumber(){
        return accNumber;
    }
    public double getbalance(){
        return balance;
    }
    public double getinterestRate(){
        return interestRate;
    }

    public double deposit(double deposito){
        balance = balance + deposito;
        return balance;
    }
    public double withdraw(double saque){
        balance = balance - saque;
        return balance;
    }
    public double addInterest(double juros){
        balance = balance + (balance * (juros)/100);
        return balance;
    }
}
