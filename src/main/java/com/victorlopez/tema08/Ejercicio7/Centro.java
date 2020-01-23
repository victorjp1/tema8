package com.victorlopez.tema08.Ejercicio7;

import java.util.Scanner;

public class Centro {
    private Paciente[] pacientes;
    static Scanner lector = new Scanner (System.in);
    public Centro(final int MAX) {
        this.pacientes = new Paciente[MAX];
    }
    public void nuevoPaciente(){
        boolean validado;
        long sip;
        String nombre;
        int sexo;
        int edad;
        String sintomatologia;
        do {
            System.out.println("Introduce el sip: ");
            sip = lector.nextLong();
            lector.nextLine();
            if (sip >= 0){
                validado = true;
            }else{
                validado = false;
                System.out.println("Error!");
                pausa();
            }
        }while(!validado);
        do {
            System.out.println("Introduce el nombre!");
            nombre = lector.nextLine();
            if (nombre.length() > 3){
                validado = true;
            }else{
                validado = false;
                System.out.println("Error!");
            }
        }while(!validado);
        do {
            System.out.println("Introduce la edad: ");
            edad = Integer.parseInt(lector.nextLine());
            if (edad > 0){
                validado = true;
            }else{
                validado = false;
                System.out.println("Edad incorrecta!");
            }
        }while(!validado);
        do {
            System.out.println("SEXO:");
            System.out.println("---------------");
            System.out.println("1. HOMBRE");
            System.out.println("2. MUJER");
            sexo = Integer.parseInt(lector.nextLine());
            if (sexo >= 1 && sexo <= 2){
                validado = true;
            }else{
                validado = false;
                System.out.println("Error!");
            }
        }while(!validado);
        do {
            System.out.printf("Introduce la sintomatología");
            sintomatologia = lector.nextLine();
            if (sintomatologia.length() < 4){
                validado = false;
            }else{
                validado = true;
                System.out.println("No puede tener menos de 4 caracteres");
            }
        }while(!validado);
        pacientes[Paciente.getnPacientes()] = new Paciente (sip, nombre, sexo, edad, sintomatologia);
    }
    public void pausa(){
        System.out.println("Pulsa intro para continuar.");
        lector.nextLine();
    }
}
