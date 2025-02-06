public class Quadrado {
    private int side;
    public Quadrado(int side){
        this.side = side;
    }
    public int getside(){
        return side;
    }
    public void setside(int lado){
        side = lado;
    }
    public int calcularArea(int side){
        int area = (side*side);
        return area;
    }
}
