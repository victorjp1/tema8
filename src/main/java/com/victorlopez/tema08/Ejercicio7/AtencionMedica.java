package com.victorlopez.tema08.Ejercicio7;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.GregorianCalendar;

public class AtencionMedica {
    private Paciente paciente;
    private double[] preRev;
    private GregorianCalendar fechaAlta;
    private String motivo;
    private static int nAtendidos;
    private String sintomatologia;

    /**
     * Constructor de la clase atencion
     * @param paciente objeto de tipo paciente para guardar su informacion
     * @param preRev array de 4 posiciones que contiene la temperatura corporal, las 2 tensiones y las ppm
     */
    public AtencionMedica(Paciente paciente, double[] preRev, String sintomatologia) {
        this.paciente = paciente;
        this.preRev = preRev;
        nAtendidos++;
        motivo = null;
        fechaAlta = null;
    }

    /**
     * Método para cambiar el motivo
     * @param motivo motivo para reemplazar
     */
    public void setMotivo(String motivo) {
        this.motivo = motivo;
        fechaAlta = new GregorianCalendar();
    }

    /**
     * Método que devuelve un dato del array de 4 elementos
     * @param n dato que se almacene en esa posicion
     * @return devolvemos el dato
     */
    public double getPreRevDato(int n) {
        return preRev[n];
    }

    /**
     * Método que devuelve el número de pacientes atendidos, en el historial
     * @return devolvemos el número de pacientes
     */
    public static int getnAtendidos() {
        return nAtendidos;
    }

    /**
     * Método que devuelve el motivo del alta de la persona
     * @return
     */
    public String getMotivo() {
        return motivo;
    }

    /**
     * Método para imprimir la información de la atencion médica junto cn el paciente
     * @return devolvemos la información generada
     */
    @Override
    public String toString() {
        String aux;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat sdfHora = new SimpleDateFormat("hh:mm");
        aux =
                paciente.toString() +
                String.format("%-7.2f", preRev[0]) +
                String.format("%-7.2f", preRev[1]) +
                String.format("%-7.2f", preRev[2]);
                if (motivo != null){
                    aux += String.format("%-15s", sdf.format(fechaAlta.getTime())) +
                    String.format("%-8s", sdfHora.format(fechaAlta.getTime()))+
                    String.format("%-40s", motivo);
                }

                return aux;
    }

    /**
     * Método que devuelve un paciente
     * @return devuelve un objeto de tipo paciente
     */
    public Paciente getPaciente() {
        return paciente;
    }
}
