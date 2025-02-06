package Fixacao;

public class Circulo implements ObjGeometrico{
    private double raio;

    public Circulo(double raio){
        this.raio = raio;
    }

    @Override
    public double area() {
        double area = (Math.PI*(Math.pow(raio, 2)));
        return area;
    }

    @Override
    public double perimetro() {
        double perimetro = 2*(Math.PI*raio);
        return perimetro;
    }
}
