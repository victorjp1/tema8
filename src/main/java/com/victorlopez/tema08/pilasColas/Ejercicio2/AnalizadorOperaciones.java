package com.victorlopez.tema08.pilasColas.Ejercicio2;

import com.victorlopez.tema08.pilasColas.Ejercicio1.Pila;

public class AnalizadorOperaciones {
    private String[] expresion;
    private Pila p1;

    /**
     * Constructor de la clase Expresion
     * @param expresion array con la expresion matemática en notacion polaca inversa
     */
    public AnalizadorOperaciones(String[] expresion) {
        this.expresion = expresion;
        p1 = new Pila();
    }

    /**
     * Ejecuta la operacion matematica en notacion polaca inversa
     * @return devuelve el resultado
     */
    public double valorar(){
        double resultado = 0;
        for (int i = 0; i < expresion.length; i++){
            if (isNumeric(expresion[i])){
                double n = Double.parseDouble(expresion[i]);
                p1.push(n);
            }else{
                double operando2 = p1.pop();
                double operando1 = p1.pop();
                char operacion = expresion[i].charAt(0);
                resultado = operacion(operando1, operando2, operacion);
                p1.push(resultado);
            }
        }

        return p1.pop();
    }

    /**
     * Método que pertenece a la clase que calcula una operacion sin necesidad de crear un
     * objeto de la clase, pasándole la expresión
     * @param expresion expresión a valorar
     * @return devolvemos el resultado
     */
    public static double valorar(String[] expresion){
        Pila p1 = new Pila();
        double resultado = 0;
        for (int i = 0; i < expresion.length; i++){
            if (isNumeric(expresion[i])){
                double n = Double.parseDouble(expresion[i]);
                p1.push(n);
            }else{
                double operando2 = p1.pop();
                double operando1 = p1.pop();
                char operacion = expresion[i].charAt(0);
                resultado = operacion(operando1, operando2, operacion);
                p1.push(resultado);
            }
        }

        return p1.pop();
    }

    /**
     * Método que hace operaciones dependiendo del signo
     * @param op1 operando 1
     * @param op2 operando 2
     * @param operacion signo de la operacion
     * @return
     */
    private static double operacion(double op1, double op2, char operacion){
        if (operacion == '+'){
            return op1 + op2;
        }else if(operacion == '-'){
            return op1 - op2;
        }else if(operacion == '/'){
            return op1 / op2;
        }else if(operacion == '*'){
            return op1 * op2;
        }else if(operacion == '%'){
            return op1 % op2;
        }
        return Integer.MIN_VALUE;
    }

    /**
     * ;étodo que valora si un String se puede convertir en un número o no
     * @param str String a valorar
     * @return devolvemos si es numérico o no
     */
    private static boolean isNumeric(String str){
        try {
            double d = Double.parseDouble(str);
        }catch (NumberFormatException nfe){
            return false;
        }
        return true;
    }
}
