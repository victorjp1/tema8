package com.victorlopez.tema08.Ejercicio6;

import java.util.Scanner;
import java.util.GregorianCalendar;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
public class Tienda {
    private  Bicicleta[] bicicletas;
    static Scanner lector = new Scanner(System.in);
    private Bicicleta[] aux;
    public Tienda(final int MAX_BICIS) {
        this.bicicletas = new Bicicleta[MAX_BICIS];
        this.aux = new Bicicleta[MAX_BICIS];
    }

    /**
     * Método para pausar el programa hasta que el usuario pulse intro
     */
    public static void pausa() {
        System.out.println("Pulsa intro para continuar.");
        lector.nextLine();
    }

    /**
     * Método para añadir una bicicleta
     */
    public void anyadirBicicleta() {
        boolean validado;//Variable para controlar la entrada de datos
        int referencia;//Variable para almacenar la referencia de la bici
        String marca; //Variable para almacenar la marca
        String modelo; //Variable para almacenar el modelo
        double pesoKg; //Variable para almacenar el peso
        double tamanyoRuedas; //Variable para almacenar el tamaño de las ruedas
        char c;//Variable para controlar elecciones de S/N del usuario
        boolean motor;//Boolean que controla si tiene motor o no
        GregorianCalendar fechaFabricacion = null;//Fecha de fabricacion
        double precio;//Variable que controla el precio
        String fechaFabricacionString;//Variable que almacena la fecha de fabricacion en formato String.
        do {
            System.out.println("Introduce la referencia: ");//Pedimos referencia
            referencia = Integer.parseInt(lector.nextLine());//Leemos referencia
            validado = referencia > 0;//Controlamos que sea correcta
            if (!validado) {//Si es incorrecta
                System.out.println("Una referencia no puede ser negativa");//Mostramos error
                pausa();//Pausamos para que pueda leer
            }
        }while (!validado);
            do {
                System.out.println("Introduce la marca: ");//Pedimos la marca
                marca = lector.nextLine();//Leemos la marca
                validado = marca.length() > 2;//Validamos
                if (!validado) {//Si es incorrecta
                    //Mostramos mensaje de error y pausamos
                    System.out.println("La marca debe tener almenos 2 caracteres");
                    pausa();
                }
            } while (!validado);

            do {
                System.out.println("Introduce el modelo: ");//Pedimos el modelo
                modelo = lector.nextLine();//leemos el modelo
                validado = modelo.length() > 2;//Validamos el modelo
                if (!validado) {//Si es incorrecto
                    //Mostramos un mensaje de error y pausamos
                    System.out.println("El modelo debe tener almenos 2 caracteres");
                    pausa();
                }
            } while (!validado);
            do {
                //Pedimos el peso y lo leemos
                System.out.println("Introduce el peso en Kg: ");
                pesoKg = lector.nextDouble();
                lector.nextLine();
                validado = pesoKg >= 0;//Validamos
                if (!validado) {//Si es incorrecto
                    //Mostramos mensaje de error.
                    System.out.println("El preco debe ser mayor que 0.");
                    pausa();
                }
            } while (!validado);
            do {
                //Pedimos el tamaño en ruedas y lo leemos
                System.out.println("Introduce el tamaño de las ruedas en pulgadas: ");
                tamanyoRuedas = lector.nextDouble();
                lector.nextLine();
                validado = tamanyoRuedas > 0;//Validamos
                if (!validado) {//Si es incorrecto
                    //Mostramos mensaje de error y pausamos.
                    System.out.println("El tamaño de las ruedas debe ser mayor que 0.");
                    pausa();
                }
            } while (!validado);
            do {
                //Preguntamos si la bici tiene motor y leemos s/n
                System.out.println("La bici tiene motor? [S/N]:");
                c = lector.nextLine().toLowerCase().charAt(0);
                if (c == 's'){//Si es afirmativo
                    motor = true;//Motor es true.
                    validado = true;//Validado es true, correcto
                }else if (c == 'n'){//Si es negativo
                    motor = false;//Motor es igual a false
                    validado = true;//Validado = true
                }else{//Si no es s o n...
                    //La opcion es incorrecta y pausa, validado se vuelve en false
                    System.out.println("Opción incorrecta");
                    pausa();
                    validado = false;
                    motor = false;
                }
            }while (!validado);

            do {
                //Pedimos la fecha de fabricacion y la leemos como String
                System.out.println("Fecha de fabricación: (dd/mm/yyyy): ");
                fechaFabricacionString = lector.nextLine();
                //Establecemos el formato de fecha.
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                try {
                    //Convertimos a fecha y se lo asignamos a gregorian calendar
                    Date date = sdf.parse(fechaFabricacionString);
                    fechaFabricacion = new GregorianCalendar();
                    fechaFabricacion.setTime(date);
                    validado = true;
                } catch (ParseException pe) {
                    //Si es algo diferente imprimimos un mensaje de error y validación es false
                    validado = false;
                    System.out.println("Error!");
                    pausa();
                }
            } while (!validado);
            do {
                //Pide el precio en euros y lo leemos
                System.out.println("Introduce el precio en euros: ");
                precio = lector.nextDouble();
                lector.nextLine();
                validado = precio > 0;//Comprobamos
                if (!validado) {//Si es incorrecto mostramos mensaje de error y pausamos
                    System.out.println("El precio no puede ser negativo: ");
                    pausa();
                }
            } while (!validado);
            //Creamos la bicicleta
            bicicletas[Bicicleta.getnBicicletas()] = new Bicicleta(referencia, marca, modelo, pesoKg, tamanyoRuedas, motor, fechaFabricacion, precio);
    }

    /**
     * Método para vender una bicicleta
     * @return devolvemos un String que dice si el resultado de la operación es correcto o incorrecto
     */
    public String venderBicicleta(){
        int referencia;
        System.out.println("Introduce el número de referencia: ");
        referencia = Integer.parseInt(lector.nextLine());
        for (int i = 0; i < Bicicleta.getnBicicletas(); i++){
            if(referencia == bicicletas[i].getReferencia()){
                bicicletas[i] = null;//Borramos lo que hay en esa posicion
                bicicletas[i] = bicicletas[Bicicleta.getnBicicletas()-1]; //Ponemos ese array como el último
                Bicicleta.decrementoBicicletas();
                return "Bicicleta " + referencia + " se ha vendido correctamente";
            }
        }
        return "No hay stock de esta bicicleta en la tienda!";
    }

    /**
     * Método para consultar, muestra menú, valora opciones y hace las consultas con sus debidos métodos.
     */
    public void Consultas(){
        boolean menuPrincipal = false;
        do {
            System.out.println("**********************");
            System.out.println("**CONSULTA BICICLETA**");
            System.out.println("**********************");
            System.out.println("1. Consultar por referencia");
            System.out.println("2. Consultar por marca");
            System.out.println("3. Consultar  por modelo");
            System.out.println("------------------------------ \n");
            System.out.println("0. Volver al menú principal");
            int opcion = Integer.parseInt(lector.nextLine());
            int contador;
            switch (opcion){
                case 1:
                    int posicion = consultaReferencia();
                    if (posicion >= 0){
                        System.out.println(bicicletas[posicion].toString());
                    }else{
                        System.out.println("No existe una bicicleta con esa referencia");
                    }
                    break;
                case 2:
                    contador = consultaMarca(aux);
                    if (contador > 0){
                        for (int i = 0; i < contador; i++){
                            aux[i].toString();
                        }
                    }else{
                        System.out.println("No tenemos bicis de esa marca!");
                    }
                    pausa();
                    break;
                case 3:
                    contador = consultarModelo(aux);
                    if (contador > 0){
                        for (int i = 0; i < contador; i++){
                            aux[i].toString();
                        }
                    }else{
                        System.out.println("No tenemos bicis de ese modelo!");
                    }
                    pausa();
                    break;
                case 0:
                    menuPrincipal = true;
                    break;
                default:
                    System.out.println("Error!");
                    pausa();
            }
        }while(!menuPrincipal);
    }

    /**
     * Método para consultar por referencia
     * @return devuelve la posicion en la que se encuentra la bici, si no existe, devuelve -1.
     */
    public int consultaReferencia(){
        int referencia;
        System.out.println("Introduce la referencia: ");
        referencia = Integer.parseInt(lector.nextLine());
        for (int i = 0; i < Bicicleta.getnBicicletas(); i++){
            if (bicicletas[i].getReferencia() == referencia){
                return i;
            }
        }
        return -1;
    }

    /**
     * Método para consultar por marca
     * @param aux modifica un array auxiliar con todas las bicicletas que contengan esa marca
     * @return devuelve un entero con el número de existencias.
     */
    public int consultaMarca (Bicicleta[] aux){
        String marca;
        int contador = 0;
        System.out.println("Introduce la marca a visualizar: ");
        marca = lector.nextLine();
        for (int i = 0; i < Bicicleta.getnBicicletas(); i++){
            if (bicicletas[i].getMarca().contains(marca)){
                aux[contador] = bicicletas[i];
                contador++;
            }
        }
        return contador;
    }

    /**
     * Método para consultar por modelo
     * @param aux modifica un array auxiliar con todas las bicicletas que contengan esa marca
     * @return devuelve un entero con el número de existencias
     */
    public int consultarModelo(Bicicleta[] aux){
        String modelo;
        int contador = 0;
        System.out.println("Introduce el modelo a visualizar: ");
        modelo = lector.nextLine();
        for (int i = 0; i < Bicicleta.getnBicicletas(); i++){
            if (bicicletas[i].getModelo().contains(modelo)){
                aux[contador] = bicicletas[i];
                contador++;
            }
        }
        return contador;
    }

    /**
     * Método para calcular el Stock de bicicletas
     */
    public void stock(){
        int cantidad;
        int referencia;
        for (int i = 0; i < Bicicleta.getnBicicletas(); i++){

        }
    }
}
