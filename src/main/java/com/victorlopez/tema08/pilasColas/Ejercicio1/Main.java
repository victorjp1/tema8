package com.victorlopez.tema08.pilasColas.Ejercicio1;

public class Main {
    public static void main(String[] args) {
        Pila p1 = new Pila(10);
        System.out.println(p1.pop());
        p1.push(0);
        p1.push(1);
        p1.push(2);
        p1.push(3);
        p1.push(4);
        p1.push(5);
        p1.push(6);
        p1.push(7);
        p1.push(8);
        p1.push(9);
        System.out.println(p1.top());
        p1.push(10);
        p1.push(11);
        p1.push(12);
        System.out.println(p1.pop());
        p1.push(12);

        System.out.println(p1.toString());
    }
}
