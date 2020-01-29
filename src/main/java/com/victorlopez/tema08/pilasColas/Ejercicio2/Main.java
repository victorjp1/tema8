package com.victorlopez.tema08.pilasColas.Ejercicio2;

public class Main {
    public static void main(String[] args) {
        //Pruebas para la clase AnalizadoroOperaciones.
        String[] operacion = {"12","3","5","+","2","*","-"};
        AnalizadorOperaciones a1 = new AnalizadorOperaciones(operacion);
        System.out.println(a1.valorar());
        System.out.println(AnalizadorOperaciones.valorar(operacion));
    }
}
