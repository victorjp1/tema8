package com.victorlopez.tema08.Ejercicio1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String color;
        String modelo;
        String matricula;
        int tipo;
        int anyoFabricacion;
        Coche coche1 = new Coche(2006);
        Coche coche2 = new Coche();
        Scanner lector = new Scanner(System.in);
        coche1.setTipo(3);
        System.out.println("Introduce el color del coche:");
        color = lector.nextLine();
        coche1.setColor(color);
        System.out.println("Introduce el modelo del coche: ");
        modelo = lector.nextLine();
        coche1.setModelo(modelo);
        coche1.imprimirModeloColor();
        lector.nextLine();
        System.out.println("Intrduce la matrícula: ");
        matricula = lector.nextLine();
        coche1.setMatricula(matricula);
        coche1.setMetalizada(false);
        coche1.setTodoRiesgo(true);
        System.out.println("Introduce el nuevo modelo: ");
        modelo = lector.nextLine();
        coche1.setModelo(modelo);
        System.out.println("Introduce el nuevo color: ");
        coche1.setColor(color);
        coche1.imprimirCoche();
        lector.nextLine();
        System.out.println("Introduce el color:");
        color = lector.nextLine();
        coche2.setColor(color);
        modelo = lector.nextLine();
        coche2.setModelo(modelo);
        coche2.setTodoRiesgo(false);
        coche2.setMetalizada(true);
        System.out.println("Elige el tipo de coche:");
        System.out.println("1. Mini");
        System.out.println("2. Utilitario");
        System.out.println("3. Familiar");
        System.out.println("4. Deportivo");
        tipo = Integer.parseInt(lector.nextLine());
        coche2.setTipo(tipo);
        System.out.println("Introduce el año de fabricación: ");
        anyoFabricacion = Integer.parseInt(lector.nextLine());
        coche2.setAnyoFabricacion(anyoFabricacion);
        System.out.println("Introduce la matrícula: ");
        matricula = lector.nextLine();
        coche2.setMatricula(matricula);
        coche2.imprimirCoche();
        lector.nextLine();
        System.out.println("Introduce la nueva matrícula: ");
        matricula = lector.nextLine();
        coche2.setMatricula(matricula);
        System.out.println("Introduce el nuevo color: ");
        coche2.setColor(color);
        coche2.imprimirCoche();
    }
}
