package com.victorlopez.tema08.pilasColas.Ejercicio3;

public class Cola {
    private int[] cola;
    private final int INITIAL_SIZE = 10;
    private int nElementos;
    private int maxArray;

    /**
     * Constructor por defecto de la clase cola, por defecto el array será de 10
     */
    public Cola(){
        this.cola = new int[INITIAL_SIZE];
        this.nElementos = 0;
       this.maxArray = INITIAL_SIZE;
    }

    /**
     * Constructor para la clase cola en el cual podemos elegir el tamaño del array
     * @param size tamaño del array
     */
    public Cola(int size){
        this.cola = new int[size];
        this.nElementos = 0;
        this.maxArray = size;
    }
    /**
     * Método para imprimir los elementos del array
     * @return devolvemos el String
     */
    @Override
    public String toString() {
        String aux = "";
        for (int i = 0; i < nElementos; i++){
            aux += String.format("%-10s", cola[i]);
        }
        return aux;
    }

    /**
     * Método que determina si la cola está vacia
     * @return devuelve un booleano
     */
    public boolean empty(){
        if (nElementos == 0){
            return true;
        }else{
            return false;
        }
    }

    /**
     * Método para añadir un elemento a la cola
     * @param n elemento a añadir
     */
    public void add(int n){
        if (nElementos == maxArray){
            this.cola = duplicarArray(cola);
        }
        cola[nElementos] = n;
        nElementos++;
    }
    /**
     * Método que duplica un array
     * @param cola array a duplicar
     * @return devuelve el array duplicado
     */
    private int[] duplicarArray(int[] cola){
        maxArray = maxArray * 2;
        int[] aux = new int[maxArray];
        for (int i = 0; i < cola.length; i++){
            aux[i] = cola[i];
        }
        return aux;
    }

    /**
     * Método para eliminar el primer elemento de la cola
     * @return devuelve el primer valor de la cola
     */
    public int remove(){
        int aux = Integer.MIN_VALUE;
        if (!empty()){
           aux = cola[0];
           desplazarArray(cola);
           nElementos--;
        }
        return aux;
    }

    /**
     * Método para desplazar los datos del array
     * @param cola array a desplazar
     * @return devolvemos array con datos desplazados
     */
    private void desplazarArray(int[] cola){
        for (int i = 0; i < nElementos; i++){
            cola[i] = cola[i+1];
        }
    }
    /**
     * Método para saber el número de elementos que tiene el array
     * @return devuelve el número de elementos
     */
    public int size(){
        return nElementos;
    }

    /**
     * Método para leer el primer valor de la cola
     * @return devuelve el primer valor de la cola
     */
    public int peek(){
        if (!empty())
        return cola[0];
        return Integer.MIN_VALUE;
    }
}
