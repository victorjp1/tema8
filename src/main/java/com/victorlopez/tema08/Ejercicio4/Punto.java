package com.victorlopez.tema08.Ejercicio4;

import com.victorlopez.tema08.Ejercicio5.Circulo;

public class Punto {
    private double x;
    private double y;

    public Punto(double x, double y) {
        this.x = x;
        this.y = y;
    }
    public Punto(){
        this(-1,-1);
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
    public String coordenadasPunto(){
        return "(" + getX() + "," + getY() + ")";
    }
    public double calcularDistancia(Punto p2){
            double cateto1 = x - p2.getX();
            double cateto2 = y - p2.getY();
            double hipotenusa = Math.sqrt(cateto1*cateto1 + cateto2*cateto2);
            return hipotenusa;
    }
    /**
     * Imprimimos circulo
     * @param c
     */
    public static void imprimirCirculo(Circulo c){
        c.verCirculo();
        System.out.printf("El área es: %.2f %n", c.calcularArea());;
        System.out.printf("El perímetro es: %.2f %n",c.calcularPerimetro());
    }
}