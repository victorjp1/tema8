package com.victorlopez.tema08.Ejercicio6;
import java.util.Scanner;
public class Main {
    static Scanner lector;
    public static void main(String[] args) {
        lector = new Scanner(System.in);//Declaramos el escanaer
        final int MAX_BICIS = 1000;//Maximo de bicis
        Tienda t1 = new Tienda(MAX_BICIS);//Creamos un objeto tienda
        boolean salir = false;//Boolean que controla la salida de la app.
        do {
            int opcion = mostrarMenu();//Mostramos menu, leemos la opcion y la validamos
            switch (opcion)  {
                case 1:
                    t1.anyadirBicicleta();//Añadimos una bicicleta al objeto tiendaa.
                    break;
                case 2:
                    System.out.println(t1.venderBicicleta());//Vendemos una bicicleta, la eliminamos de la tienda y imprimimos la venta o el error.
                    break;
                case 3:
                    t1.Consultas();//Sacamos el menú de consultas y hacemos las consultas según la opción.
                    break;
                case 4:
                    t1.stock();//Imprimimos stock
                    break;
                case 0:
                    salir = true;//Salimos de la app.
                    break;
            }
        }while(!salir);

    }

    /**
     * Mostramos el menú, leemos la opción y la validamos
     * @return devolvemos la opcion
     */
    public static int mostrarMenu(){
        boolean validacion;
        int opcion;
        do{
            System.out.println("*************************");
            System.out.println("**GESTIÓN DE BICICLETAS**");
            System.out.println("*************************");
            System.out.println("1. Añadir bicicleta");
            System.out.println("2. Vender bicicleta");
            System.out.println("3. Consultar bicicleta");
            System.out.println("4. Mostrar stock");
            System.out.println("-------------------------\n");
            System.out.println("0. Salir");
            opcion = Integer.parseInt(lector.nextLine());
            if (opcion >= 0 && opcion <= 4){
                validacion = true;
            }else{
                validacion = false;
            }
        }while(!validacion);
        return opcion;
    }
}
