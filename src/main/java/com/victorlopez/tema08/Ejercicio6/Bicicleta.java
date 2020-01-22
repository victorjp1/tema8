package com.victorlopez.tema08.Ejercicio6;

import java.util.GregorianCalendar;

public class Bicicleta {
    private int referencia;//Referencia de la bici
    private String marca;//Marca de la bici
    private String modelo;//Modelo de la bici
    private double pesoKg;//Peso de la bici
    private double tamanyoRuedas; //Tamaño en pulgadas de las ruedas
    private boolean motor;//Si consta de motor o no.
    private GregorianCalendar fechaFabricacion; //Fecha de fabricacion de la bici
    private double precio;//Precio de la bici
    private static int nBicicletas = 0;//Número de bicicletas creadas
    private int nExistencias = 0;

    /**
     * Constructor para crear un objeto de tipo bicicleta
     * @param referencia referencia de la bici dentro de la tienda
     * @param marca marca de la bici
     * @param modelo modelo de la bici
     * @param pesoKg peso en kg de la bici
     * @param tamanyoRuedas tamaño en pulgadas de las ruedas.
     * @param motor motor de la bici
     * @param fechaFabricacion fecha de fabricacion de la bici
     * @param precio precio de la bici
     */
    public Bicicleta(int referencia, String marca, String modelo, double pesoKg, double tamanyoRuedas, boolean motor, GregorianCalendar fechaFabricacion, double precio) {
        this.referencia = referencia;
        this.marca = marca;
        this.modelo = modelo;
        this.pesoKg = pesoKg;
        this.tamanyoRuedas = tamanyoRuedas;
        this.motor = motor;
        this.fechaFabricacion = fechaFabricacion;
        this.precio = precio;
        nBicicletas++;
        nExistencias++;
    }

    /**
     * Decrementa el número de bicicletas
     */
    public static void decrementoBicicletas(){
        nBicicletas--;
    }

    /**
     * Devuelve le número de bicicletas
     * @return
     */
    public static int getnBicicletas() {
        return nBicicletas;
    }

    /**
     * devuelve la marca de la bicicleta
     * @return
     */
    public String getMarca() {
        return marca;
    }

    /**
     * Devuelve el modelo de la bicicleta
     * @return
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * Método que devuelve el peso en kg de la bicicleta
     * @return
     */
    public double getPesoKg() {
        return pesoKg;
    }

    /**
     * Método que devuelve el tamaño en pulgadas de las ruedas.
     * @return
     */
    public double getTamanyoRuedas() {
        return tamanyoRuedas;
    }

    /**
     * Devuelve una boolean que determina si tiene motor o no
     * @return
     */
    public boolean isMotor() {
        return motor;
    }

    /**
     * Método que devuelve la fecha de fabricacion
     * @return
     */
    public GregorianCalendar getFechaFabricacion() {
        return fechaFabricacion;
    }

    /**
     * Método que devuelve el precio de la bici
     * @return
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * Método que devuelve la referencia de la bici
     * @return
     */
    public int getReferencia() {
        return referencia;
    }

    /**
     * Método que genera un String con todos los atributos de la bici.
     * @return
     */
    @Override
    public String toString() {
        return "Bicicleta{" +
                "referencia=" + referencia +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", pesoKg=" + pesoKg +
                ", tamanyoRuedas=" + tamanyoRuedas +
                ", motor=" + motor +
                ", fechaFabricacion=" + fechaFabricacion +
                ", precio=" + precio +
                '}';
    }
}
