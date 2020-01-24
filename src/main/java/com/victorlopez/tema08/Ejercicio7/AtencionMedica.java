package com.victorlopez.tema08.Ejercicio7;

import java.util.GregorianCalendar;

public class AtencionMedica {
    private Paciente paciente;
    private double[] preRev = new double[4];
    GregorianCalendar fechaAlta;

    public AtencionMedica(Paciente paciente, double[] preRev, GregorianCalendar fechaAlta) {
        this.paciente = paciente;
        this.preRev = preRev;
        this.fechaAlta = fechaAlta;
    }
}
