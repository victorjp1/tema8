package com.victorlopez.tema08.Ejercicio7;

import java.util.Arrays;
import java.util.GregorianCalendar;

public class AtencionMedica {
    private Paciente paciente;
    private double[] preRev;
    private GregorianCalendar fechaAlta;
    private String motivo;
    private static int nAtendidos;

    public AtencionMedica(Paciente paciente, double[] preRev) {
        this.paciente = paciente;
        this.preRev = preRev;
        nAtendidos++;
        motivo = null;
        fechaAlta = null;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
        fechaAlta = new GregorianCalendar();
    }

    public double getPreRevDato(int n) {
        return preRev[n];
    }

    public static int getnAtendidos() {
        return nAtendidos;
    }

    public String getMotivo() {
        return motivo;
    }

    @Override
    public String toString() {
        String aux;
        aux =
                paciente.toString() +
                ", Temperatura = " + preRev[0] +
                ", PPM: " + preRev[1] +
                " Tensión Sistólica: " + preRev[2] +
                " Tensión Diastólica: " + preRev[3];
                if (motivo != null){
                    aux += " Motivo " + motivo + " Fecha de Alta " + fechaAlta.getTime();
                }
                return aux;
    }

    public Paciente getPaciente() {
        return paciente;
    }
}
