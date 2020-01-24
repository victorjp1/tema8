package com.victorlopez.tema08.Ejercicio7;

import java.util.GregorianCalendar;
enum Sexo{Hombre, Mujer}
public class Paciente {
    private long sip;
    private String nombre;
    private Sexo sexo;
    private int edad;
    private GregorianCalendar fechaHoraEntrada;
    private String sintomatologia;
    private static int nPacientes;
    private boolean atendido;

    public Paciente(long sip,String nombre, int sexo, int edad, String sintomatologia) {
        this.sip = sip;
        this.nombre = nombre;
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
    public static void decrementonPacientes(){
        nPacientes = nPacientes -1;
    }

    public boolean isAtendido() {
        return atendido;
    }

    @Override
    public String toString() {
        return
                "Paciente: " +
                "SIP = " + sip +
                ", Nombre = " + nombre +
                ", Sexo = " + sexo +
                ", Edad = " + edad +
                ", Fecha y Hora de Entrada = " + fechaHoraEntrada.getTime() +
                ", Sintomatologia = " + sintomatologia;
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
