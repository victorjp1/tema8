package com.victorlopez.tema08.Ejercicio3;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
public class Ejercicio3 {
    public static void main(String[] args) {
        boolean salir;//Boolean que controla la salida del bucle del menu principal.
        boolean consulta;//Boolean que controla la salida del bucle del menu de consultas.
        final int MAX_ALUMNOS = 500;//Constante que controla el tamaño del array.
        boolean validado;//Boolean que controla la salida de los bucles de validaciones
        int nia;//Variable usada para almacenar el nia del alumno introducido por el user.
        String nombre;//Variable usada para almacenar el nombre del alumno introducido por el user.
        String apellidos;//Variable usada para almacenar los apellidos del alumno introducido por el user.
        int dia;//Variable usada para almacenar el dia de nacimiento del alumno introducido por el user.
        int mes;//Variable usada para almacenar el mes de nacimiento del alumno introducido por el user.
        int anyo;//Variable usada para almacenar el año de nacimiento del alumno introducido por el user.
        String fechaNacimiento;//Variable usada para almacenar la fecha de nacimiento del alumno creada con los anteriores datos.
        String grupo;//Variable usada para almacenar el grupo del alumno introducido por el user.
        int telefono;//Variable usada para almacenar el telefono del alumno introducido por el user.
        char borrar;//Variable para confirmar una accion de borrar.
        Alumno[] alumnos = new Alumno[MAX_ALUMNOS];//Array de objetos, donde se almacenan alumnos.
        Scanner lector =  new Scanner (System.in);//Declaramos el escáner.
        int opcion;//Variable que almacena la opcion del menu elegida por el usuario.
        //Creamos 4 alumnos para poder hacer pruebas.
        alumnos[Alumno.getnAlumnos()] = new Alumno(54332344, "Víctor","López Fornés", "2B", 608532388, "15/12/2000");
        alumnos[Alumno.getnAlumnos()] = new Alumno(43634564, "Raul","Quesada Vidal", "2B", 608532388, "15/12/2000");
        alumnos[Alumno.getnAlumnos()] = new Alumno(98786667, "Luis","Dengra Dalmau", "4A", 608532388, "15/12/2000");
        alumnos[Alumno.getnAlumnos()] = new Alumno(34869008, "German","Gascón", "1C", 608532388, "15/12/2000");
        do {
            lector.nextLine();
            mostrarMenu();//Mostramos el menú principal
            opcion = Integer.parseInt(lector.nextLine());//Leemos la opción
            switch (opcion) {//Valoramos la opcion
                case 1:
                    do {
                        //Borramos pantalla y situamos el cursor arriba a la izquierda.
                        System.out.print("\u001B[H\u001B[2J");
                        System.out.flush();
                        System.out.printf("Introduce el NIA: %n");//Pedimos el nia
                        nia = Integer.parseInt(lector.nextLine());//Leemos el nia
                        if (nia > 0) {//Si el nia es mayor que 0..
                            if (unico(alumnos, nia)) {//Si el nia no existe ya en el array...
                                validado = true;//Salimos del bucle de validación
                            } else {//Si el nia ya existe...
                                validado = false;//Validado es igual a false, seguimos en el bucle.
                                //Mostramos un error.
                                System.out.println("Ya existe un alumno con ese NIA!! %n");
                            }
                        } else {//Si el nia es menor que 0...
                            //Mostramos un mensaje de error.
                            System.out.println("No existe ese NIA!! %n");
                            validado = false;//Validado es false, volvemos a hacer el bucle.
                        }
                    } while (!validado);
                    do {
                        System.out.println("Introduce el nombre del alumno: ");//Pedimos el nombre del alumno.
                        nombre = lector.nextLine();//Leemos el nombre
                        if (nombre.length() >= 3) {//Si el nombre es mayor a 3 caracteres..
                            validado = true;//Es correcto, salimos del bucle.
                        } else {//Si es menor a 3 caracteres
                            validado = false;
                            //Mostramos un mensaje de error.
                            System.out.println("El nombre debe tener mínino 3 caracteres");
                        }
                    } while (!validado);
                    do {
                        //Pedimos los apellidos del alumno.
                        System.out.println("Introduce los apellidos del alumno: ");
                        apellidos = lector.nextLine();//Leemos los apellidos del alumno
                        if (apellidos.length() >= 3) {//Si su longitud es mayor que 3...
                            validado = true;//Salimos del bucle, es correcto.
                        } else {//Si es menor que 3 caracteres...
                            validado = false;//Volvemos a hacer el bucle
                            //Mostramos un mensaje de error.
                            System.out.println("El apellido o apellidos deben tener mínino 3 caracteres");
                        }
                    } while (!validado);
                    System.out.println("Introduce el grupo del alumno: ");//Pedimos el grupo del alumno
                    grupo = lector.nextLine();//Leemos el grupo del alumno
                    do {
                        //PEdimos el telefono del alymno
                        System.out.println("Introduce el número de contacto del alumno: ");
                        telefono = Integer.parseInt(lector.nextLine());//Leemos el tfno.
                        if (telefono > 0) {//Si es mayor que 0...
                            validado = true;//El número es real, salimos del bucle.
                        } else {//Si es menor que 0...
                            //Volvemos a hacer el bucle y mostramos un mensaje de error
                            validado = false;
                            System.out.println("No puede existir un número de teléfono negativo!!");
                        }
                    } while (!validado);
                    do{
                        //Pedimos el año de nacimiento y lo leemos, validamos si se encuentra entre 1900 y 2030...
                        //Si no lo está volvemos a hacer el bucle.
                        System.out.println("Introduce el año de nacimiento: (Ej: 1980)");
                        anyo = Integer.parseInt(lector.nextLine());
                        if (anyo >= 1900 && anyo <= 2030) {
                            validado = true;
                        } else {
                            validado = false;
                            System.out.println("Año incorrecto!!!!");
                        }
                    }while (!validado);
                    do{
                        //Pedimos el mes de nacimiento y lo leemos, validamos si se encuentra entre 1 y 12
                        //Si no lo está volvemos a hacer el bucle.
                        System.out.println("Introduce el mes de nacimiento: (1-12)");
                        mes = Integer.parseInt(lector.nextLine());
                        if (mes >= 1 && mes <= 12) {
                            validado = true;
                        } else {
                            validado = false;
                            System.out.println("Mes incorrecto!!!!");
                        }
                    }while (!validado);
                    do{
                        //Pedimos el año de nacimiento y lo leemos, validamos si se encuentra entre 1 y 31
                        //Si no lo está volvemos a hacer el bucle.
                        System.out.println("Introduce el día de nacimiento: ");
                        dia = Integer.parseInt(lector.nextLine());
                        if (dia >= 1 && dia <= 31) {
                            validado = true;
                        } else {
                            validado = false;
                            System.out.println("Día incorrecto!!!!");
                        }
                    }while (!validado);
                    //Creamos la fecha de nacimiento entera como String con los datos anteriormente pedidos.
                    fechaNacimiento = dia + "/" + mes + "/" + anyo;
                    salir = false;
                    //Creamos el objeto con todos sus parámetros.
                    alumnos[Alumno.getnAlumnos()] = new Alumno(nia, nombre,apellidos, grupo, telefono, fechaNacimiento);
                    break;
                case 2:
                    //Pedimos el NIA del alumno y lo leemos.
                    System.out.println("Introduce el NIA del alumno a borrar:");
                    nia = Integer.parseInt(lector.nextLine());
                    if (unico(alumnos, nia)){//Si el NIA no existe...
                        //Mostramos un mensaje de error.
                        System.out.println("No existe ningún alumno con ese NIA");
                    }else{//Si el NIA existe...
                        //Mostramos que lo hemos encontrado y preguntamos si lo quiere borrar o no
                        System.out.println("Hemos encontrado al alumno, desea eliminarlo? (S/N)");
                        borrar = lector.nextLine().toLowerCase().charAt(0);//Leemos la respuesta
                        if (borrar == 's'){//Si la respuesta es afirmativa...
                            for (int i = 0; i < Alumno.getnAlumnos(); i++){//Recorremos el array.
                                if (alumnos[i].getNia() == nia){//Si el nia de alguno de ellos es igual al obtenido...
                                    alumnos[i] = null;//Borramos lo que hay en esa posicion
                                    alumnos[i] = alumnos[Alumno.getnAlumnos()-1]; //Ponemos ese array como el último
                                    Alumno.setnAlumnos(Alumno.getnAlumnos()-1);//reducimos en 1 el numero de alumnos.
                                }
                            }
                            System.out.println("Se ha borrado el alumno!!");//Mostramos que se ha borrado.
                        }else if (borrar == 'n'){//Si la respuesta es no mostramos un mensaje.
                            System.out.println("Operación cancelada!");
                        }else{//Si la respuesta es otra mostramos un mensaje de error.
                            System.out.println("Error!!!");
                        }
                    }
                    salir = false;
                    break;
                case 3:
                    do {
                        //Borramos pantalla y situamos el cursor arriba a la izquierda.
                        System.out.print("\u001B[H\u001B[2J");
                        System.out.flush();
                        menuConsultas();//Mostramos el menú de las consultas
                        opcion = Integer.parseInt(lector.nextLine());//Leemos la opcion elegida.
                        switch (opcion){//Valoramos la opcion
                            case 1:
                                //Pedimos el grupo a consultar
                                System.out.println("Introduce el grupo: ");
                                grupo = lector.nextLine();//Leemos el grupo a consultar
                                imprimirAlumnos(alumnos, grupo); //Imprimimos los alumnos
                                consulta = true;//Ponemos a true la variable que controla la salida de consultas
                                break;
                            case 2:
                                System.out.println("De que edad quieres buscar los alumnos?: ");
                                int edad = Integer.parseInt(lector.nextLine());
                                consultaEdad(alumnos,edad);
                                System.out.println("Pulsa intro para continuar");
                                lector.nextLine();
                                consulta = true;//Ponemos a true la variable que controla la salida de consultas
                                break;
                            case 3:
                                //Pedimos el NIA y lo leemos.
                                System.out.println("Introduce el nia: ");
                                nia = Integer.parseInt(lector.nextLine());
                                if (unico(alumnos, nia)){//Si el nia no existe mostramos que no existe
                                    System.out.println("No existe un alumno con ese NIA");
                                }else{//Si existe imprimimos los alumnos con ese NIA
                                    imprimirAlumnos(alumnos,nia);
                                }
                                consulta = true;//Ponemos a true la variable que controla la salida de consultas
                                break;
                            case 4:
                                System.out.println("Introduce los apellidos de la persona: ");//Pedimos los apellidos
                                apellidos = lector.nextLine().trim();//Leemos los apellidos quitando espacion en blanco al principio y al final
                                imprimirAlumnosApellidos(alumnos, apellidos);//Imprimimos los alumnos con ese apellido.
                                consulta = true;//Ponemos a true la variable que controla la salida de consultas
                                break;
                            case 0:
                                consulta = false;//Ponemos a false la variable que controla la salida del bucle, salimos
                                break;
                            default:
                                System.out.println("Opción incorrecta!!");//Mostramos que la opcion es incorrecta
                                consulta = true;//Ponemos a true la variable que controla la salida de consultas
                                break;
                        }
                    }while(consulta);
                    salir = false;
                    break;
                case 0:
                    salir = true;
                    break;
                default:
                    salir = false;
                    System.out.println("Error!!!! %n");
            }
        }while(!salir);
    }

    /**
     * Método que borra un alumno con el nia recibido como parámetro
     * @param alumnos array que contiene los alumnos
     * @param nia nia a valorar
     * @return devuelve el array sin el alumno a borrar
     */
    public static Alumno[] borrarAlumno (Alumno[] alumnos, int nia){
        Alumno[] aux = new Alumno[500];
        int contador = 0;
        for (int i = 0; i < Alumno.getnAlumnos(); i++){
            if (alumnos[i].getNia() != nia){
               aux[contador] = alumnos[i];
               contador++;
            }else{
                Alumno.setnAlumnos(Alumno.getnAlumnos()-1);
            }
        }
        return aux;
    }

    /**
     * Método que imprime todos los alumnos con un mismo NIA aunque solo podrá ser 1
     * @param alumnos array que contiene los alumnos
     * @param nia nia a valorar
     */
    public static void imprimirAlumnos(Alumno[] alumnos, int nia){
        for (int i = 0; i < Alumno.getnAlumnos(); i++){
            if (alumnos[i].getNia() == nia){
                System.out.println(alumnos[i].toString());
            }
        }
    }

    /**
     * Método que imprime alumnos con unos apellidos específicos.
     * @param alumnos array que contiene los alumnos
     * @param apellidos apellidos a valorar
     */
    public static void imprimirAlumnosApellidos(Alumno[] alumnos, String apellidos){
        for (int i = 0; i < Alumno.getnAlumnos(); i++){
            if (alumnos[i].getApellidos().equalsIgnoreCase(apellidos)){
                System.out.println(alumnos[i].toString());
            }
        }
    }

    /**
     * Método que imprime todos los alumnos del mismo grupo.
     * @param alumnos Array que contiene a los alumnos
     * @param grupo String que contiene el grupo el cual deseamos imprimir los alumnos.
     */
    public static void imprimirAlumnos(Alumno[] alumnos, String grupo){
        for (int i = 0; i < Alumno.getnAlumnos(); i++){
            if (alumnos[i].getGrupo().equalsIgnoreCase(grupo)){
                System.out.println(alumnos[i].toString());
            }
        }
    }
    /**
     * Método que sabe si el NIA existe previamente en los alumnos
     * @param alumnos array de alumnos
     * @param nia nia a valorar
     * @return
     */
    public static boolean unico (Alumno[] alumnos, int nia){
        for (int i = 0; i < Alumno.getnAlumnos(); i++){
            if (nia == alumnos[i].getNia()){
                return false;
            }
        }
        return true;
    }

    /**
     * Método que muestra el menú de consultas.
     */
    public static void menuConsultas(){
        System.out.printf("*************** %n");
        System.out.printf("** CONSULTAS ** %n");
        System.out.printf("*************** %n");
        System.out.printf("1. Por grupo %n");
        System.out.printf("2. Por edad %n");
        System.out.printf("3. Por nia %n");
        System.out.printf("4. Por apellidos %n");
        System.out.printf("------------------------- %n");
        System.out.printf("0. Volver al menú principal %n");
    }

    /**
     * Método que muestra el menú principal de la app.
     */
    public static void mostrarMenu(){
        System.out.printf("*********************%n");
        System.out.printf("** GESTIÓN ALUMNOS ** %n");
        System.out.printf("********************* %n");
        System.out.printf("1. Nuevo alumno %n");
        System.out.printf("2. Baja de alumno %n");
        System.out.printf("3. Consultas %n");
        System.out.printf("------------------------------ %n");
        System.out.printf("0. Salir %n");
    }

    /**
     * Método para consultar alumnos con una edad predeterminada
     * @param alumnos array de los alumnos
     * @param edad edad a valorar
     */
    public static void consultaEdad(Alumno alumnos[], int edad){

        for (int i = 0; i < Alumno.getnAlumnos(); i++){//Método que recorre el array
            DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate fechaNac = LocalDate.parse(alumnos[i].getFechaNacimiento(), fmt);
            LocalDate ahora = LocalDate.now();
            Period periodo = Period.between(fechaNac, ahora);
            if (periodo.getYears() == edad){
                System.out.println(alumnos[i].toString());
            }
        }
    }
}
