package com.victorlopez.tema08.Ejercicio7;

import com.victorlopez.tema08.Ejercicio3.Alumno;
import com.victorlopez.tema08.Ejercicio6.Bicicleta;

import java.util.Scanner;

public class Centro {
    private Paciente[] pacientes;
    static Scanner lector = new Scanner (System.in);
    private AtencionMedica[] atenciones = new AtencionMedica[500];
    public Centro(final int MAX) {
        this.pacientes = new Paciente[MAX];

    }

    /**
     * Método para crear pacientes para hacer pruebas
     */
    public void crearPacientes(){
        double[] constantes = {33, 60, 56.5, 70};
        double[] constantes2 = {50, 70, 80.5, 60};
        pacientes[Paciente.getnPacientes()] = new Paciente (666666, "Víctor López Fornés", 1, 34, "Ser demasiado bacano");
        pacientes[Paciente.getnPacientes()] = new Paciente (55555, "KSDA Fornés", 1, 54, "Ser demasiado bacano");
        pacientes[Paciente.getnPacientes()] = new Paciente (4444, "Luís Fornés Dengra", 2, 89, "Ser demasiado bacano");
        pacientes[Paciente.getnPacientes()] = new Paciente (7777777, "Germán Fornés", 1, 15, "Ser demasiado bacano");
        pacientes[Paciente.getnPacientes()] = new Paciente (8888888, "Antonio López Ramírez", 2, 104, "Ser demasiado bacano");
        atenciones[0] = new AtencionMedica(pacientes[0], constantes, pacientes[0].getSintomatologia());
        atenciones[1] = new AtencionMedica(pacientes[1], constantes2, pacientes[1].getSintomatologia());
        atenciones[1].setMotivo("Ser muy poco bacano");
    }

    /**
     * Método que crea un nuevo paciente
     * @return devuelve un String con el resultado de la operación
     */
    public String nuevoPaciente(){
        long sip;
        String nombre;
        int sexo;
        int edad;
        String sintomatologia;
        sip = pedirSip();
        if (unico(sip)){
            for (int i = 0; i < AtencionMedica.getnAtendidos(); i++){
                if (sip == atenciones[i].getPaciente().getSip()){
                    sintomatologia = pedirSintomatologia();
                    pacientes[Paciente.getnPacientes()] = new Paciente(atenciones[i].getPaciente().getSip(),atenciones[i].getPaciente().getNombre(), atenciones[i].getPaciente().getSexo(), atenciones[i].getPaciente().getEdad(), sintomatologia);
                    return "Paciente registrado correctamente!";
                }
            }
            nombre = pedirNombre();
            edad = pedirEdad();
            sexo = pedirSexo();
            sintomatologia = pedirSintomatologia();
            pacientes[Paciente.getnPacientes()] = new Paciente (sip, nombre, sexo, edad, sintomatologia);
            return "Paciente registrado correctamente!";
        }else{
            return "El paciente ya está registrado!";
        }
    }

    /**
     * Método para la atencion de un paciente
     * @return devuelve un String con el resultado de la operacion
     */
    public String atenderPaciente(){
        long sip;
        final int CONSTANTES = 4;
        double[] constantes = new double[CONSTANTES];
        System.out.println("Introduce el SIP del paciente a atender: ");
        sip = lector.nextLong();
        for (int i = 0; i < Paciente.getnPacientes(); i++){
            if (sip == pacientes[i].getSip() && !pacientes[i].isAtendido()){
                constantes[0] = pedirTemperatura();
                constantes[1] = pedirPpm();
                constantes[2] = pedirSistolica();
                constantes[3] = pedirDiastolica();
                atenciones[AtencionMedica.getnAtendidos()] = new AtencionMedica(pacientes[i], constantes, pacientes[i].getSintomatologia());
                return "Atención registrada";
            }
        }
        return "El paciente no está en la lista de espera";
    }

    /**
     * Método para pedir la tension diastolica
     * @return devolvemos la tension
     */
    public double pedirDiastolica(){
        double diastolica;
        boolean validado;
        do {
            System.out.println("Introduce la tension diastólica del paciente: ");
            diastolica = lector.nextDouble();
            lector.nextLine();
            if (diastolica < 0 || diastolica > 300){
                validado = false;
                System.out.println("Error");
                pausa();
            }else{
                validado = true;
            }
        }while(!validado);
        return diastolica;
    }

    /**
     * Método que pide y valida la tension sistolica
     * @return devuelve la tension
     */
    public double pedirSistolica(){
        double sistolica;
        boolean validado;
        do {
            System.out.println("Introduce la tension sistólica del paciente: ");
            sistolica = lector.nextDouble();
            lector.nextLine();
            if (sistolica < 0 || sistolica > 400){
                validado = false;
                System.out.println("Error");
                pausa();
            }else{
                validado = true;
            }
        }while(!validado);
        return sistolica;
    }

    /**
     * Método para pedir las pulsaciones por minuto
     * @return devolvemos las pulsaciones por minuto
     */
    public int pedirPpm(){
        boolean validado;
        int ppm;
        do {
            System.out.println("Introudce las pulsaciones por minuto: ");
            ppm = Integer.parseInt(lector.nextLine());
            if (ppm >= 0 && ppm <= 300){
                validado = true;
            }else{
                validado = false;
                System.out.println("Error!");
                pausa();
            }
        }while(!validado);
        return ppm;
    }

    /**
     * Método que determina si el sip ya se encuentra registrado
     * @param sip sip del paciente
     * @return devuelve un boolean que determina si es unico o no
     */
    public boolean unico(long sip){
        for (int i = 0; i < Paciente.getnPacientes(); i++){
            if (pacientes[i].getSip() == sip){
                return false;
            }
        }
        return true;
    }

    /**
     * Método que pide la temperatura del paciente
     * @return devuelve la temperatura
     */
    public double pedirTemperatura(){
        double temperatura;
        boolean validado;
        do {
            System.out.println("Introduce la temperatura corporal del paciente:");
            temperatura = lector.nextDouble();
            lector.nextLine();
            if (temperatura >= 50 || temperatura <= 0){
                validado = false;
                System.out.println("Temperatura incorrecta");
                pausa();
            }else{
                validado = true;
            }
        }while(!validado);
        return temperatura;
    }

    /***
     * Método que pide el sip del paciente
     * @return devuelve el sip
     */
    public long pedirSip(){
        long sip;
        boolean validado;
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
        return sip;
    }

    /**
     * Método para pedir el nombre del paciente
     * @return devuelve el nombre del paciente en formato String
     */
    public String pedirNombre(){
        String nombre;
        boolean validado;
        do {
            System.out.println("Introduce el nombre!");
            nombre = lector.nextLine();
            if (nombre.length() > 3){
                validado = true;
            }else{
                validado = false;
                System.out.println("Error!");
                pausa();
            }
        }while(!validado);
        return nombre;
    }

    /**
     * Método que pide la edad del paciente
     * @return devuelve la edad del paciente
     */
    public int pedirEdad(){
        int edad;
        boolean validado;
        do {
            System.out.println("Introduce la edad: ");
            edad = Integer.parseInt(lector.nextLine());
            if (edad > 0 && edad <= 150){
                validado = true;
            }else{
                validado = false;
                System.out.println("Edad incorrecta!");
                pausa();
            }
        }while(!validado);
        return edad;
    }

    /**
     * Método que pide el sexo del paciente
     * @return devuelve un entero.
     */
    public int pedirSexo(){
        boolean validado;
        int sexo;
        do {
            System.out.println("SEXO:");
            System.out.println("---------------");
            System.out.println("1. HOMBRE");
            System.out.println("2. MUJER");
            System.out.println("---------------");
            sexo = Integer.parseInt(lector.nextLine());
            if (sexo == 1 || sexo == 2){
                validado = true;
            }else{
                validado = false;
                System.out.println("Error!");
                pausa();
            }
        }while(!validado);
        return sexo;
    }

    /**
     * Método que pide la sintomatologia del paciente
     * @return devuelve la sintomatologia en formato String
     */
    public String pedirSintomatologia(){
        boolean validado;
        String sintomatologia;
        do {
            System.out.println("Introduce la sintomatología");
            sintomatologia = lector.nextLine();
            if (sintomatologia.length() > 4){
                validado = true;
            }else{
                validado = false;
                System.out.println("No puede tener menos de 4 caracteres");
                pausa();
            }
        }while(!validado);
        return sintomatologia;
    }

    /**
     * Método para hacer una pausa en pantalla
     */
    public void pausa(){
        System.out.println("Pulsa intro para continuar.");
        lector.nextLine();
    }

    /**
     * Método para hacer consultas
     * @param opcion opcion a valorar en el menu consultas
     */
    public void consultas(int opcion){
        boolean salir = false;
            switch (opcion){
                case 1:
                    consultaSip();
                    break;
                case 2:
                    //consultaFecha();
                    break;
                case 3:
                    mostrarEstadisticas();
                    break;
                case 4:
                    mostrarHistorico();
                    break;
                case 0:
                    break;
            }
    }

    /**
     * Método que da de alta a un paciente
     * @return Devuelve un String con el resultado de la operacion
     */
    public String altaMedica(){
        long sip = pedirSip();
        String motivo;
        for (int i = 0; i < AtencionMedica.getnAtendidos(); i++){
            if (atenciones[i].getPaciente().getSip() == sip && atenciones[i].getMotivo() == null){
                System.out.println("Introduce el motivo del alta: ");
                motivo = lector.nextLine();
                atenciones[i].setMotivo(motivo);
                return "Paciente dado de alta correctamente";
            }
        }
        return "No se ha encontrado el paciente o no ha sido atendido";
    }

    /**
     * Método que muestra estadísticas generales del historial
     */
    public void mostrarEstadisticas(){
        System.out.printf("Media temperatura: %.2f %n", mediaTemperatura());
        System.out.printf("Media pulsaciones por minuto: %.2f %n", mediaPpm());
        System.out.printf("Media de la tensión sistólica: %.2f %n", mediaTensionSisto());
        System.out.printf("Media de la tensión diastólica: %.2f %n", mediaTensionDiasto());
        System.out.printf("Media de la edad: %.2f %n", mediaEdad());
        System.out.printf("Porcentaje de pacientes hombres: %.2f %% %n", porcentajeHombres());
        System.out.printf("Porcentaje de pacientes mujeres: %.2f %% %n", porcentajeMujeres());
        pausa();
    }

    /**
     * método que calcula el porcentaje de mujeres en base a los pacientes
     * @return devuelve un numero real, es el porcentaje
     */
    public double porcentajeMujeres(){
        double contador = 0;
        for (int i = 0; i < AtencionMedica.getnAtendidos(); i++){
            if (atenciones[i].getPaciente().getSexo() == Sexo.Mujer){
                contador++;
            }
        }
        return 100 * contador / AtencionMedica.getnAtendidos();
    }

    /**
     * Método que calcula el porcentaje de hombres en base a los pacientes
     * @return devuelve un numero real, es el porcentaje
     */
    public double porcentajeHombres(){
        double contador = 0;
        for (int i = 0; i < AtencionMedica.getnAtendidos(); i++){
            if (atenciones[i].getPaciente().getSexo() == Sexo.Hombre){
                contador++;
            }
        }
        return 100 * contador / AtencionMedica.getnAtendidos();
    }

    /**
     * Método que calcula la media de edad entre todos los pacientes
     * @return devolvemos la media
     */
    public double mediaEdad(){
        double acumulador = 0;
        for (int i = 0; i < AtencionMedica.getnAtendidos(); i++){
            acumulador += atenciones[i].getPaciente().getEdad();
        }
        return acumulador / AtencionMedica.getnAtendidos();
    }
    /**
     * Método que calcula la media de tensión diastólica entre todos los pacientes
     * @return devolvemos la media
     */
    public double mediaTensionDiasto(){
        double acumulador = 0;
        for (int i = 0; i< AtencionMedica.getnAtendidos(); i++){
            acumulador += atenciones[i].getPreRevDato(3);
        }
        return acumulador / AtencionMedica.getnAtendidos();
    }
    /**
     * Método que calcula la media de tension sistolica entre todos los pacientes
     * @return devolvemos la media
     */
    public double mediaTensionSisto(){
        double acumulador = 0;
        for (int i = 0; i< AtencionMedica.getnAtendidos(); i++){
            acumulador += atenciones[i].getPreRevDato(2);
        }
        return acumulador / AtencionMedica.getnAtendidos();
    }
    /**
     * Método que calcula la media de pulsaciones por minuto entre todos los pacientes
     * @return devolvemos la media
     */
    public double mediaPpm(){
        double acumulador = 0;
        for (int i = 0; i< AtencionMedica.getnAtendidos(); i++){
            acumulador += atenciones[i].getPreRevDato(1);
        }
        return acumulador / AtencionMedica.getnAtendidos();
    }
    /**
     * Método que calcula la media de temperatura corporal entre todos los pacientes
     * @return devolvemos la media
     */
    public double mediaTemperatura(){
        double acumulador = 0;
        for (int i = 0; i < AtencionMedica.getnAtendidos(); i++){
            acumulador += atenciones[i].getPreRevDato(0);
        }
        return acumulador / AtencionMedica.getnAtendidos();
    }

    /**
     * Método que muestra el historial de pacientes
     */
    public void mostrarHistorico(){
        for (int i = 0; i < AtencionMedica.getnAtendidos(); i++){
                System.out.println(atenciones[i].toString());
        }
        for (int i = 0; i < Paciente.getnPacientes(); i++){
            if (!pacientes[i].isAtendido()){
                System.out.println(pacientes[i].toString());
            }
        }
    }

    /**
     * Método que consulta en el historial sobre un sip.
     */
    public void consultaSip(){
        long sip;
        sip = pedirSip();
        for (int i = 0; i < AtencionMedica.getnAtendidos(); i++){
            if (sip == atenciones[i].getPaciente().getSip()){
                System.out.println(atenciones[i].toString());
            }
        }
    }
}
