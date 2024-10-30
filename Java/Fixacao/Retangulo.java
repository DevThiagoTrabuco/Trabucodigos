package Fixacao;

public class Retangulo implements ObjGeometrico{
    private double base;
    private double altura;

    public Retangulo(double base, double altura){
        this.base = base;
        this.altura = altura;
    }

    @Override
    public double area() {
        double area = base*altura;
        return area;
    }

    @Override
    public double perimetro() {
        double perimetro = (2*base)+(2*altura);
        return perimetro;
    }
    
}
