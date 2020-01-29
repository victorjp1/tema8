package com.victorlopez.tema08.pilasColas.Ejercicio1;

import java.util.Arrays;

public class Pila {
    private double[] pila;
    private int nElementos;
    private int maxArray;

    /**
     * Constructor por defecto de la clase pila, por defecto el vector se crea de 10.
     */
    public Pila() {
        maxArray = 10;
        nElementos = 0;
        pila = new double[maxArray];
    }

    /**
     * Método para imprimir los elementos del array
     * @return devolvemos el String
     */
    @Override
    public String toString() {
        String aux = "";
        for (int i = 0; i < nElementos; i++){
            aux += String.format("%-10s", pila[i]);
        }
        return aux;
    }

    /**
     * Método que devuelve el último valor del array
     * @return devolvemos el último valor del array
     */
    public double top(){
        double aux = Double.MIN_VALUE;
        if(!empty()){
            aux = pila[nElementos -1];
        }
        return aux;
    }

    /**
     * Constructor de la clase pila
     * @param maxArray tamaño del vector
     */
    public Pila(int maxArray) {
        this.maxArray = maxArray;
        pila = new double[maxArray];
        nElementos = 0;
    }

    /**
     * Método para insertar un elemento en la pila
     * @param n entero a insertar
     */
    public void push(double n){
        if (nElementos == pila.length){
            pila = duplicarArray(pila);
        }
        pila[nElementos] = n;
        nElementos++;
    }

    /**
     * Método que duplica un array
     * @param pila array a duplicar
     * @return devuelve el array duplicado
     */
    private double[] duplicarArray(double[] pila){
        maxArray = maxArray * 2;
        double[] aux = new double[maxArray];
        for (int i = 0; i < pila.length; i++){
            aux[i] = pila[i];
        }
        return aux;
    }

    /**
     * Método que devuelve el número de elementos que tiene el array
     * @return
     */
    public int size(){
        return nElementos;
    }

    /**
     * Método que comprueba si la pila está vacia
     * @return si está vacía devuelve true, si está llena devuelve false
     */
    public boolean empty(){
        return nElementos == 0;
    }

    /**
     * Método para mostrar el último elemento del vector, además, lo borramos
     * @return devolvemos el último elemento
     */
    public double pop(){
        double aux = Integer.MIN_VALUE;
        if(!empty()){
            aux = pila[nElementos -1];
            nElementos--;
        }
        return aux;
    }
}
