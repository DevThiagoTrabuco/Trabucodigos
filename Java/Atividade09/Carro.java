package Atividade09;

public class Carro {
    private String model;
    private double fuel, fuelUse;

    public Carro(String modelo, double consumo){
        this.fuel = 0.0;
        this.model = modelo;
        this.fuelUse = consumo;
    }

    public String getmodel(){
        return model;
    }
    public double getfuel(){
        return fuel;
    }
    public double getfuelUse(){
        return fuelUse;
    }
    public double drive(double distance){
        fuel = fuel - (distance * fuelUse)/100;
        return fuel;
    }
    public double refuel(double gas){
        fuel = fuel + gas;
        return fuel;
    }
}
