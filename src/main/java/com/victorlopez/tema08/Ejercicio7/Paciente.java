package com.victorlopez.tema08.Ejercicio7;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
enum Sexo{Hombre, Mujer}//Enumerado para el sexo
public class Paciente {
    private long sip;
    private String nombre;
    private Sexo sexo;
    private int edad;
    private GregorianCalendar fechaHoraEntrada;
    private String sintomatologia;
    private static int nPacientes;
    private boolean atendido;

    /**
     * Constructor de la clase paciente
     * @param sip sip perteneciente al paciente
     * @param nombre nombre del paciente
     * @param sexo sexo del paciente
     * @param edad edad del paciente
     * @param sintomatologia sintomatologia del paciente
     */
    public Paciente(long sip,String nombre, int sexo, int edad, String sintomatologia) {
        this.sip = sip;
        this.nombre = nombre;
        //Valoramos el entero de parametro para asignar el enumerado
        switch (sexo){
            case 1:
                this.sexo = Sexo.Hombre;
                break;
            case 2:
                this.sexo = Sexo.Mujer;
        }
        this.edad = edad;
        this.fechaHoraEntrada = new GregorianCalendar();
        this.sintomatologia = sintomatologia;
        nPacientes++;
        atendido = false;
    }

    public String getSintomatologia() {
        return sintomatologia;
    }

    /**
     * Método para decrementar pacientes
     */
    public static void decrementonPacientes(){
        nPacientes = nPacientes -1;
    }

    /**
     * Método que evalua si ha sido atendido o no
     * @return devuelve un boolean
     */
    public boolean isAtendido() {
        return atendido;
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat sdfHora = new SimpleDateFormat("hh:mm");
        return
                String.format("%-10d",sip) +
                String.format("%-25s",nombre) +
                String.format("%-10s",getSexo()) +
                String.format("%-15s",sdf.format(fechaHoraEntrada.getTime())) +
                String.format("%-8s",sdfHora.format(fechaHoraEntrada.getTime())) +
                String.format("%-40s",sintomatologia);
                /*
                "Paciente: " +
                "SIP = " + sip +
                ", Nombre = " + nombre +
                ", Sexo = " + sexo +
                ", Edad = " + edad +
                ", Fecha y Hora de Entrada = " + fechaHoraEntrada.getTime() +
                ", Sintomatologia = " + sintomatologia;*/
    }

    public Paciente(long sip, String nombre, Sexo sexo, int edad, String sintomatologia) {
        this.sip = sip;
        this.nombre = nombre;
        this.sexo = sexo;
        this.edad = edad;
        this.fechaHoraEntrada = new GregorianCalendar();
        this.sintomatologia = sintomatologia;
        nPacientes++;
    }

    public static int getnPacientes() {
        return nPacientes;
    }

    public long getSip() {
        return sip;
    }

    public String getNombre() {
        return nombre;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public int getEdad() {
        return edad;
    }
}
