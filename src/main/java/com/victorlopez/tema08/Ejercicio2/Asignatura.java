package com.victorlopez.tema08.Ejercicio2;

public class Asignatura {
    private String nombre;//Atributo que almacena el nombre de la asignatura.
    private int cod;//Atributo que almacena el código de la asignatura.
    private short curso; //Atributo que almacena el curso de la asignatura.
    private static int nAsignaturas;//Variable que pertenece a la clase y es un contador para el num de asignaturas.

    /**
     * Constructor usado para crear un objeto de la clase asignatura.
     * @param nombre String que almacena el nombre de la asignatura.
     * @param cod Entero que almacena el código de la asignatura
     * @param curso Short que almacena el curso al que pertenece la asignatura.
     */
    public Asignatura(String nombre, int cod, short curso) {
        this.nombre = nombre;
        this.cod = cod;
        this.curso = curso;
        nAsignaturas++;
    }

    /**
     * Método que devuelve el nombre de la asignatura.
     * @return variable que almacena el nombre.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Método que devuelve el código de la asignatura.
     * @return variable de enteros que contiene el codigo de la asignatura.
     */
    public int getCod() {
        return cod;
    }

    /**
     * Método que devuelve el curso de la asignatura.
     * @return variable short que almacena el curso de la asignatura.
     */
    public short getCurso() {
        return curso;
    }
}
