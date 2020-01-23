package com.victorlopez.tema08.Ejercicio7;

import java.util.GregorianCalendar;
enum Motivo{Mejora, Defunción, Derivacion_Hospital}
enum Sexo{HOMBRE, MUJER}
public class Paciente {
    private long sip;
    private String nombre;
    private Sexo sexo;
    private int edad;
    private GregorianCalendar fechaHoraEntrada;
    private String sintomatologia;
    boolean atendido;
    private double temperatura;
    private int ppm;
    private int tenSis;
    private int tenDias;
    private GregorianCalendar HoraAlta;
    private Motivo motivo;
    private static int nPacientes;

    public Paciente(long sip,String nombre, int sexo, int edad, String sintomatologia) {
        this.sip = sip;
        switch (sexo){
            case 1:
                this.sexo = Sexo.HOMBRE;
                break;
            case 2:
                this.sexo = Sexo.MUJER;
        }
        this.edad = edad;
        this.fechaHoraEntrada = new GregorianCalendar();
        this.sintomatologia = sintomatologia;
        nPacientes++;
    }

    public static int getnPacientes() {
        return nPacientes;
    }
}
