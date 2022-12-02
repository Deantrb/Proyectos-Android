package geometria;

public class Cuadrado {
    private double lado;
    public Cuadrado() {this.lado=0; }

    public double getLado(){return lado;}

    public void setLado(double lado){this.lado = lado; }

    public double perimetro(){ return lado*4;}
    public double area(){return lado*lado;}

}
