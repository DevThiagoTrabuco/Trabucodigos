public class Carro {
    @SuppressWarnings("FieldMayBeFinal")
    private String model;
    @SuppressWarnings("FieldMayBeFinal")
    private double fuel;
    @SuppressWarnings("FieldMayBeFinal")
    private double fuelUse;

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
