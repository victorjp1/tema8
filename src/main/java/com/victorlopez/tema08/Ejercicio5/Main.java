package com.victorlopez.tema08.Ejercicio5;

import com.victorlopez.tema08.Ejercicio4.Punto;

public class Main {
    public static void main(String[] args) {
        Punto p1 = new Punto(2.5, 4.5);//Creamos un objeto de tipo punto.
        Circulo c1 = new Circulo(p1, 5);//Creamos un circulo con el objeto anterior y un radio
        imprimirCirculo(c1);//Imprimimos circulo.
        Circulo c2 = new Circulo(3.5, 4.5, 5.5);//Creamos un nuevo circulo con x e y que se convertiran en un objeto tipo punto.
        imprimirCirculo(c2);//Imprimimos circulo
        Circulo c3 = new Circulo();//Creamos un circulo sin parametros
        Punto p2 = new Punto (3,5);//Creamos un nuevo punto.
        c3.setCentro(p2);//Definimos el centro de c3 con el punto p2
        c3.setRadio(4.5);//Definimos el radio de c3.
        imprimirCirculo(c3);//Imprimimos el circulo
        Circulo c4 = new Circulo();//Creamos un nuevo circulo
        c4.setCentro(2.5,4.5);//Definimos su centro, de tipo punto.
        c4.setRadio(4.5);//Definimos radio
        imprimirCirculo(c4);//Imprimimos circulo
        //Imprimimos la distancia entre el centro de la circunferencia y otro punto.
        System.out.printf("La distancia es: %.2f %n", c3.calcularDistancia(c4.getCentro()));
    }

    /**
     * Imprimimos circulo.
     * @param c circulo a imprimir
     */
    public static void imprimirCirculo(Circulo c){
        c.verCirculo();
        System.out.printf("El área es: %.2f %n", c.calcularArea());;
        System.out.printf("El perímetro es: %.2f %n",c.calcularPerimetro());
    }
}
