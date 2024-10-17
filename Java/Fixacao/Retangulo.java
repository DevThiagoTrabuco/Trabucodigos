package Fixacao;

public class Retangulo implements ObjGeometrico{
    private int base;
    private int altura;
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
