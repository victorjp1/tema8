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
    public void crearPacientes(){
        double[] constantes = {33, 60, 56.5, 70};
        double[] constantes2 = {50, 70, 80.5, 60};
        pacientes[Paciente.getnPacientes()] = new Paciente (666666, "Víctor López Fornés", 1, 34, "Ser demasiado bacano");
        pacientes[Paciente.getnPacientes()] = new Paciente (55555, "KSDA Fornés", 1, 54, "Ser demasiado bacano");
        pacientes[Paciente.getnPacientes()] = new Paciente (4444, "Luís Fornés Dengra", 2, 89, "Ser demasiado bacano");
        pacientes[Paciente.getnPacientes()] = new Paciente (7777777, "Germán Fornés", 1, 15, "Ser demasiado bacano");
        pacientes[Paciente.getnPacientes()] = new Paciente (8888888, "Antonio López Ramírez", 2, 104, "Ser demasiado bacano");
        atenciones[0] = new AtencionMedica(pacientes[0], constantes);
        atenciones[1] = new AtencionMedica(pacientes[1], constantes2);
        atenciones[1].setMotivo("Ser muy poco bacano");
    }
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
                atenciones[AtencionMedica.getnAtendidos()] = new AtencionMedica(pacientes[i], constantes);
                pacientes[i] = null;
                pacientes[i] = pacientes[Paciente.getnPacientes()-1]; //Ponemos ese array como el último
                Paciente.decrementonPacientes();
                return "Atención registrada";
            }
        }
        return "El paciente no está en la lista de espera";
    }
    public int pedirDiastolica(){
        int diastolica;
        boolean validado;
        do {
            System.out.println("Introduce la tension diastólica del paciente: ");
            diastolica = Integer.parseInt(lector.nextLine());
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
    public int pedirSistolica(){
        int sistolica;
        boolean validado;
        do {
            System.out.println("Introduce la tension sistólica del paciente: ");
            sistolica = Integer.parseInt(lector.nextLine());
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
    public boolean unico(long sip){
        for (int i = 0; i < Paciente.getnPacientes(); i++){
            if (pacientes[i].getSip() == sip){
                return false;
            }
        }
        return true;
    }
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

    public void pausa(){
        System.out.println("Pulsa intro para continuar.");
        lector.nextLine();
    }
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
    public double porcentajeMujeres(){
        double contador = 0;
        for (int i = 0; i < AtencionMedica.getnAtendidos(); i++){
            if (atenciones[i].getPaciente().getSexo() == Sexo.Mujer){
                contador++;
            }
        }
        return 100 * contador / AtencionMedica.getnAtendidos();
    }
    public double porcentajeHombres(){
        double contador = 0;
        for (int i = 0; i < AtencionMedica.getnAtendidos(); i++){
            if (atenciones[i].getPaciente().getSexo() == Sexo.Hombre){
                contador++;
            }
        }
        return 100 * contador / AtencionMedica.getnAtendidos();
    }
    public double mediaEdad(){
        double acumulador = 0;
        for (int i = 0; i < AtencionMedica.getnAtendidos(); i++){
            acumulador += atenciones[i].getPaciente().getEdad();
        }
        return acumulador / AtencionMedica.getnAtendidos();
    }
    public double mediaTensionDiasto(){
        double acumulador = 0;
        for (int i = 0; i< AtencionMedica.getnAtendidos(); i++){
            acumulador += atenciones[i].getPreRevDato(3);
        }
        return acumulador / AtencionMedica.getnAtendidos();
    }
    public double mediaTensionSisto(){
        double acumulador = 0;
        for (int i = 0; i< AtencionMedica.getnAtendidos(); i++){
            acumulador += atenciones[i].getPreRevDato(2);
        }
        return acumulador / AtencionMedica.getnAtendidos();
    }
    public double mediaPpm(){
        double acumulador = 0;
        for (int i = 0; i< AtencionMedica.getnAtendidos(); i++){
            acumulador += atenciones[i].getPreRevDato(1);
        }
        return acumulador / AtencionMedica.getnAtendidos();
    }
    public double mediaTemperatura(){
        double acumulador = 0;
        for (int i = 0; i < AtencionMedica.getnAtendidos(); i++){
            acumulador += atenciones[i].getPreRevDato(0);
        }
        return acumulador / AtencionMedica.getnAtendidos();
    }
    public void mostrarHistorico(){
        for (int i = 0; i < AtencionMedica.getnAtendidos(); i++){
                System.out.println(atenciones[i].toString());
        }
        for (int i = 0; i < Paciente.getnPacientes(); i++){
            System.out.println(pacientes[i].toString());
        }
    }
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
