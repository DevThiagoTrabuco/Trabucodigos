package Atividade07;

public class ContaCorrente {
    private String accOwner, account;
    private double balance;

    public ContaCorrente(String nome, String accNumber){
        this.accOwner = nome;
        this.account = accNumber;
        this.balance = 0.0;
    }

    public String getaccOwner(){
        return accOwner;
    }
    public String getaccount(){
        return account;
    }
    public double getbalance(){
        return balance;
    }

    public double deposit(double deposito){
        balance = balance + deposito;
        return balance;
    }
    public double withdraw(double saque){
        balance = balance - saque;
        return balance;
    }
}
