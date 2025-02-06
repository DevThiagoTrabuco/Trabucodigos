package Fixacao;

public class Triangulo implements ObjGeometrico{
    private double sideA, sideB, sideC;
    @SuppressWarnings("FieldMayBeFinal")
    private double s = (sideA + sideB + sideC)/2;

    public Triangulo (double sideA, double sideB, double sideC){
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    @Override
    public double area() {
        double area = Math.sqrt(s * (s - sideA) * (s - sideB) * (s - sideC));
        return area;
    }

    @Override
    public double perimetro() {
        double perimetro = sideA + sideB + sideC;
        return perimetro;
    }
    
}
