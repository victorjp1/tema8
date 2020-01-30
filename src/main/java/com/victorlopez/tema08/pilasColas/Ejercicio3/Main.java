package com.victorlopez.tema08.pilasColas.Ejercicio3;

public class Main {
    public static void main(String[] args) {
        //Pruebas clase cola
        Cola c1 = new Cola();
        System.out.println(c1.peek());
        c1.add(1);
        c1.add(2);
        c1.add(3);
        c1.add(4);
        c1.add(5);
        System.out.println(c1.peek());
        c1.add(6);
        System.out.println(c1.size());
        c1.add(7);
        System.out.println(c1.remove());
        c1.add(8);
        c1.add(9);
        c1.add(10);
        c1.add(11);
        c1.add(12);
        System.out.println(c1.remove());
        System.out.println(c1.toString());
    }
}
