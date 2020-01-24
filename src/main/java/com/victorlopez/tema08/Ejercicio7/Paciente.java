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

    public Paciente(long sip,String nombre, int sexo, int edad, String sintomatologia) {
        this.sip = sip;
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
    }

    public static int getnPacientes() {
        return nPacientes;
    }
}
