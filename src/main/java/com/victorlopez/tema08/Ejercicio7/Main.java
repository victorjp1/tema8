package com.victorlopez.tema08.Ejercicio7;

import java.util.Scanner;

public class Main {
    static Scanner lector;
    public static void main(String[] args) {
        lector = new Scanner(System.in);
        int opcionConsulta;
        boolean salir = false;
        final int MAX_PACIENTES = 40;
        Centro c1 = new Centro(MAX_PACIENTES);
        c1.crearPacientes();
        do {
            int opcion = mostrarMenu();
            switch (opcion){
                case 1:
                    System.out.println(c1.nuevoPaciente());
                    break;
                case 2:
                    System.out.println(c1.atenderPaciente());
                    break;
                case 3:
                    do {
                        opcionConsulta = menuConsultas();
                        c1.consultas(opcionConsulta);
                    }while(opcionConsulta != 0);
                    break;
                case 4:
                    System.out.println(c1.altaMedica());
                    break;
                case 0:
                    salir = true;
                    System.out.println("Has salido del programa!");
            }
        }while(!salir);
    }
    private static int menuConsultas(){
        int opcion;
        boolean validado;
        do {
            System.out.println("***************");
            System.out.println("** Consultas **");
            System.out.println("***************");
            System.out.println("1. Por SIP");
            System.out.println("2. Por fechas ");
            System.out.println("3. Estadísticas");
            System.out.println("4. Mostrar histórico mensual");
            System.out.println("----------------------------\n");
            System.out.println("0. Volver al menú principal");
            opcion = Integer.parseInt(lector.nextLine());
            if (opcion >= 0 && opcion <= 4){
                validado = true;
            }else{
                validado = false;
                System.out.println("Opción no válida!");
            }
        }while (!validado);
        return opcion;
    }
    private static int mostrarMenu(){
        int opcion;
        boolean validado;
        do {
            System.out.println("*********************");
            System.out.println("**    URGENCIAS    **");
            System.out.println("*********************");
            System.out.println("1. Nuevo paciente");
            System.out.println("2. Atender paciente");
            System.out.println("3. Consultas");
            System.out.println("4. Alta médica");
            System.out.println("----------------------------\n");
            System.out.println("0. Salir");
            opcion = Integer.parseInt(lector.nextLine());
            if (opcion >= 0 && opcion <= 4){
                validado = true;
            }else{
                validado = false;
                System.out.println("Opción no válida!");
            }
        }while (!validado);
        return opcion;
    }
}
