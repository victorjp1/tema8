package com.victorlopez.tema08.Ejercicio1;

public class Coche {
    public enum Tipo{MINI,UTILITARIO, FAMILIAR, DEPORTIVO, NULL }
    private String modelo;
    private String color;
    private boolean metalizada;
    private String matricula;
    private Tipo tipo;
    private int anyoFabricacion;
    private boolean todoRiesgo;
    private static int cochesRegistrados;

    /**
     * Constructor para crear un objeto de tipo coche
     * @param anyoFabricacion Año de fabricación del coche.
     */
    public Coche(int anyoFabricacion){
        this.anyoFabricacion = anyoFabricacion;
        cochesRegistrados++;
        todoRiesgo = true;
        tipo = Tipo.NULL;
        metalizada = true;
        color = "NULL";
        matricula = "NULL";
    }

    /**
     * Constructor sin parámetros para crear un coche.
     */
    public Coche(){
        cochesRegistrados++;
        anyoFabricacion = 0;
        todoRiesgo = true;
        tipo = Tipo.NULL;
        metalizada = true;
        color = "NULL";
        matricula = "NULL";
    }

    /**
     * Método que devuelve el número de coches registrados que hay.
     * @return
     */
    public static int getCochesRegistrados() {
        return cochesRegistrados;
    }

    /**
     * Método que imprime las características del coche.
     */
    public void imprimirCoche(){
        System.out.println("Tu coche tiene estas características:");
        System.out.printf("%-25s %-10s %n","Modelo: ", getModelo());
        System.out.printf("%-25s %-10s %n","Tipo: ", getTipo());
        System.out.printf("%-25s %-10s %n","Color: ", getColor());
        System.out.printf("%-25s %-10s %n","Matrícula: ", getMatricula());
        System.out.printf("%-25s %-10s %n","Año Fabricacion: ", getAnyoFabricacion());
        System.out.printf("%-25s ","Todo Riesgo: ");
        if (isTodoRiesgo()){
            System.out.printf("%-10s %n","SI");
        }else{
            System.out.printf("%-10s %n", "NO");
        }
        System.out.printf("%-26s","Metalizada: ");
        if (isMetalizada()){
            System.out.printf("%-10s %n","SI");
        }else{
            System.out.printf("%-10s %n", "NO");
        }
    }

    /**
     * Método que imprime el modelo y el color.
     */
    public void imprimirModeloColor(){
        System.out.printf("El modelo es: %s %n", modelo);
        System.out.printf("El color es: %s %n", color);
    }

    /**
     * Método que devuelve el modelo del coche.
     * @return
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * Método que devuelve el color del coche.
     * @return
     */
    public String getColor() {
        return color;
    }

    /**
     * Método que devuelve si es metalizada o no.
     * @return boolean que determina si es metalizada o no.
     */
    public boolean isMetalizada() {
        return metalizada;
    }

    /**
     * Método que devuelve la matrícula del coche.
     * @return
     */
    public String getMatricula() {
        return matricula;
    }

    /**
     * Método que devuelve el tipo del coche.
     * @return
     */
    public Tipo getTipo() {
        return tipo;
    }

    /**
     * Método que devuelve el año de fabricacion del coche.
     * @return
     */
    public int getAnyoFabricacion() {
        return anyoFabricacion;
    }

    /**
     * Método para asignar el año de fabricacion del coche.
     * @param anyoFabricacion
     */
    public void setAnyoFabricacion(int anyoFabricacion) {
        this.anyoFabricacion = anyoFabricacion;
    }

    /**
     * Método que determina si el seguro es a todo riesgo o a terceros.
     * @return boolean que determina si es a todo riesgo o no.
     */
    public boolean isTodoRiesgo() {
        return todoRiesgo;
    }

    /**
     * Método que asigna si es metalizada o no.
     * @param metalizada boolean que determina si es metalizada o no
     */
    public void setMetalizada(boolean metalizada) {
        this.metalizada = metalizada;
    }

    /**
     * Método que asigna si es a todo a riesgo o no
     * @param todoRiesgo boolean que determina si es a todo riesgo o no.
     */
    public void setTodoRiesgo(boolean todoRiesgo) {
        this.todoRiesgo = todoRiesgo;
    }

    /**
     * Método para asignar el color del coche
     * @param color String que asigna el colo
     */
    public void setColor(String color){
        this.color = color;
    }

    /**
     * Método para asignar el modelo del coche.
     * @param modelo variable que contiene el modelo.
     */
    public void setModelo(String modelo){
        this.modelo = modelo;
    }

    /**
     * Método que asigna la matrícula del coche.
     * @param matricula variable que contiene la matricula del coche.
     */
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    /**
     * Método que asigna el tipo de coche que es, puede ser mini, utilitario, familiar o deportivo.
     * @param tipo número entero, el número 1 es mini, el número 2 es utilitario,
     * el número 3 es familiar y el número 4 es deportivo.
     */
    public void setTipo(int tipo) {
        switch (tipo){
            case 1:
                this.tipo = Tipo.MINI;
                break;
            case 2:
                this.tipo = Tipo.UTILITARIO;
                break;
            case 3:
                this.tipo = Tipo.FAMILIAR;
                break;
            case 4:
                this.tipo = Tipo.DEPORTIVO;
                break;
            default:
                System.out.println("Error!!");
                this.tipo = Tipo.NULL;
        }
    }
}
