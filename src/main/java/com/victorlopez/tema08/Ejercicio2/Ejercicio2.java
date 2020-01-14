package com.victorlopez.tema08.Ejercicio2;

public class Ejercicio2 {
    public static void main(String[] args) {
        Asignatura asig1 = new Asignatura("Programacion", 1017, (short) 1);//Creamos el objetos con todos los datos.
        System.out.println("La asignatura es: " + asig1.getNombre());//Mostramos el nombre de asignatura.
        System.out.println("El código de asignatura es: " + asig1.getCod());//Mostramos el código de la asignatura.
        System.out.println("El curso es: " + asig1.getCurso());//Mostramos el curso.
    }
}
