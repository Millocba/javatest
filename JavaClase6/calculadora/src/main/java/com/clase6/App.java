package com.clase6;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Hello world!
 */
public final class App {
    private App() {
    }

    public static void main(String[] args) {
        System.out.println("\n*************************************************************************\n"+
                            "Ingrese la operacion a realizar (Suma, Resta, Multiplicación o Division):\n"+
                            "(debe ser en formato horizontal, de izquierda a derecha, ej.: 3+5*20/10)\n"+
                            "*************************************************************************\n");

        Scanner lectura = new Scanner(System.in);
        String cadena = lectura.nextLine();

        char [] cadena_div = cadena.toCharArray();

        Double termino1 = (double) 0;
        Double total = 0.0;
        String numero = "";
        char operacion = '0';

        for(int i = 0 ; i < cadena_div.length;i++){

            if (Character.isDigit(cadena_div[i])){
                numero += cadena_div[i];
                System.out.println(numero);

            }else if (operacion == '0'){
                if(i==0){
                    numero += cadena_div[i];
                    operacion = '0';
                }else{
                operacion = cadena_div[i];
                termino1 = Double.parseDouble(numero);
                numero = "0";
                System.out.println(termino1);

                }
            }else{
                Double termino2 = Double.valueOf(numero);
                System.out.println(numero);
                System.out.println(termino1);
                System.out.println(termino2);
                termino1 = ejecutarOperacion(termino1,termino2,operacion);
                operacion = cadena_div[i];
                numero = "0";
            };
            if (i==(cadena_div.length-1) || cadena_div[i] == '=') {
                Double termino2 = Double.valueOf(numero);
                System.out.println(numero);
                System.out.println(termino1);
                System.out.println(termino2);
                total += ejecutarOperacion(termino1,termino2,operacion);
            }
        }
        System.out.println("El resultado es: "+ total);

    }

    private static double ejecutarOperacion(Double termino1, Double termino2, char operacion) {
        
        double resultado = 0.0;
        Calculadora calc = new Calculadora();
    switch (operacion) {
        case '+':
            resultado = calc.sumar(termino1, termino2);
            break;
        case '-':
            resultado = calc.restar(termino1, termino2);
            break;
        case '*':
            resultado = calc.multiplicar(termino1, termino2);
            break;
        case '/':
            if (termino2 == 0) {
            throw new IllegalArgumentException("No se puede dividir entre cero");
            }
            resultado = calc.dividir(termino1, termino2);
            break;
        default:
            throw new IllegalArgumentException("Operación no válida: " + operacion);
    }
    return resultado;


    }

   
}
