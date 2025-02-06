package Atividade03;

public class Rectangle {
    private int base, height;

    public Rectangle(int base, int height){
        this.base = base;
        this.height = height;
    }

    public int getheight(){
        return height;
    }
    public void setheigth(int altura){
        height = altura;
    }

    public int getbase(){
        return base;
    }
    public void setbase(int side){
        base = side;
    }

    public int calcularArea(int side, int altura){
        int area = (side * altura);
        return area;
    }
    public int calcularPerimetro(int side, int altura){
        int perimetro = (2*side)+(2*altura);
        return perimetro;
    }
}
