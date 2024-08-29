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
        double fuelWaste = distance / fuelUse;
        if(fuel >= fuelWaste){
            fuel -= fuelWaste;
        }
        return fuel;
    }
    public double refuel(double gas){
        if(gas > 0){
            fuel += gas;
        }
        return fuel;
    }
}
