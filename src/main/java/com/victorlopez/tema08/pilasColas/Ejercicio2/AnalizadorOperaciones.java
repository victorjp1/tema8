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
    private static boolean isNumeric(String str){
        try {
            double d = Double.parseDouble(str);
        }catch (NumberFormatException nfe){
            return false;
        }
        return true;
    }
}
