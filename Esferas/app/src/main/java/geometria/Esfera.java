package geometria;

public class Esfera {

    private double radio;

    public Esfera() {
        this.radio = 0;
    }

    public double getRadio() {
        return radio;
    }

    public void setRadio(double radio) {
        this.radio = radio;
    }

    public double volumen(){
        return 4.0/3.0*Math.PI*Math.pow(this.radio,3);
    }

    public double area(){
        return 4.0*Math.PI*Math.pow(this.radio,2);
    }
}
