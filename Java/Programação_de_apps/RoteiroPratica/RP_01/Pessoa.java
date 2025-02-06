package RP_01;

public class Pessoa {
    @SuppressWarnings("FieldMayBeFinal")
    private String name;
    @SuppressWarnings("FieldMayBeFinal")
    private String cpf;
    @SuppressWarnings("FieldMayBeFinal")
    private int birthYear;

    public Pessoa(String name, String cpf, int birthYear){
        this.name = name;
        this.cpf = cpf;
        this.birthYear = birthYear;
    }

    public String getname(){
        return name;
    }
    public String getcpf(){
        return cpf;
    }
    public int getyear(){
        return birthYear;
    }
}
