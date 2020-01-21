package com.victorlopez.tema08.Ejercicio5;

import com.victorlopez.tema08.Ejercicio4.Punto;

public class Circulo {
    private Punto centro;//Variable que almacena una coordenada.
    private double radio;//Variable que almacena el radio

    /**
     * Constructor que recibe el radio y la coordenada con 2 parámetros, posteriormente se convertirá
     * @param radio variable que almacena el radio
     * @param x coordenada x del punto
     * @param y coordenada y del punto
     */
    public Circulo(double radio,double x, double y) {
        this.radio = radio;
        this.centro = new Punto(x,y);
    }

    /**
     * Constructor que obtiene un objeto de tipo punto y el radio.
     * @param centro objeto de tipo punto, una coordenada
     * @param radio radio del circulo
     */
    public Circulo(Punto centro, double radio) {
        this.centro = centro;
        this.radio = radio;
    }

    /**
     * Constructor sin parámetros, las variables se inicializan con valores absurdos.
     */
    public Circulo(){
        this.radio = -1;
        this.centro = new Punto(-1,-1);
    }

    /**
     * Variable que devuelve una variable de tipo punto con coordenadas.
     * @return
     */
    public Punto getCentro() {
        return centro;
    }

    /**
     * Métoodo para cambiar la coordenada.
     * @param centro objeto de tipo punto.
     */
    public void setCentro(Punto centro) {
        this.centro = centro;
    }

    /**
     * Método que cambia el centro con 2 parámetros que se convertirán en un objeto de tipo punto
     * @param x coordenada x
     * @param y coordenada y
     */
    public void setCentro(double x, double y) {
        this.centro = new Punto(x,y);
    }

    /**
     * Método que devuelve un double que es el radio de la circunferencia
     * @return
     */
    public double getRadio() {
        return radio;
    }

    /**
     * Método que cambia el radio del objeto
     * @param radio radio de la circunferencia
     */
    public void setRadio(double radio) {
        this.radio = radio;
    }

    /**
     * Mñetodo que calcula la distancia entre 2 variables de tipo punto
     * @param p2 punto a valorar
     * @return devuelve un double que será la distancia.
     */
    public double calcularDistancia(Punto p2){
        return centro.calcularDistancia(p2);
    }

    /**
     * Método que calcula el área de la circunferencia
     * @return devuelve un double que contiene el área de la circunferencia
     */
    public double calcularArea(){
        return Math.PI * (radio * radio);
    }

    /**
     * Método que calcula el perínetro de la circunferencia
     * @return devovlemos el perímetro de la circunferencia
     */
    public double calcularPerimetro(){
        return 2 * Math.PI * radio;
    }

    /**
     * Método que mostramos información del círculo.
     */
    public void verCirculo(){
        System.out.printf("Círculo de radio %.2fcm situado",radio);
        if (centro.getY() == 0 && centro.getX() == 0){
            System.out.printf("en el origen de coordenadas. %n");
        }else{
            System.out.printf("en el punto (%.2f, %.2f).%n", centro.getX(), centro.getY());
        }
    }
    /**
     * Imprimimos circulo.
     */
    public void imprimirCirculo(){
        verCirculo();
        System.out.printf("El área es: %.2f %n", calcularArea());;
        System.out.printf("El perímetro es: %.2f %n",calcularPerimetro());
    }
}
