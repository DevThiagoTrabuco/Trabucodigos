package Atividade14;
public class BombaCombustivel {
    private String fuelType, id;
    private double priceByLiter, fuelQtt;

    public BombaCombustivel(String id, String fuelType, double price, double fuelQtt){
        this.id = id;
        this.fuelType = fuelType;
        this.priceByLiter = price;
        this.fuelQtt = fuelQtt;
    }
    
    public String getid(){
        return id;
    }
    public String gettype(){
        return fuelType;
    }
    public void settype(String tipo){
        this.fuelType = tipo;
    }
    public double getprice(){
        return priceByLiter;
    }
    public void setprice(double preco){
        this.priceByLiter = preco;
    }
    public double getqtt(){
        return fuelQtt;
    }
    public void setqtt(double qtt){
        this.fuelQtt = qtt; 
    }

    public void fillByPrice(double valor){
        double volume = valor / priceByLiter;
        if(volume <= fuelQtt){
            fuelQtt -= volume;
            System.out.println("Total abastecido (em L): " + volume);
        } else {
            System.out.println("Volume de combustível na bomba é insuficiente.");
        }
    }
    public void fillByVolume(double volume){
        double valor = volume * priceByLiter;
        if(volume <= fuelQtt){
            fuelQtt -= volume;
            System.out.println("Total a ser pago: R$" + valor);
        } else {
            System.out.println("Volume de combustível na bomba é insuficiente.");
        }
    }
}
