package com.clase6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

/**
 * Unit test for simple App.
 */
class AppTest {
    /**
     * Rigorous Test.
     */
    @Test
    public void testSuma() {
        Calculadora calc = new Calculadora();
        double resultado = calc.sumar(150, 180);
        assertEquals(330, resultado, 0.001);
    }

    @Test
    public void testResta() {
        Calculadora calc = new Calculadora();
        double resultado = calc.restar(90, 50);
        assertEquals(40, resultado, 0.001);
    }

    @Test
    public void testMultiplicacion() {
        Calculadora calc = new Calculadora();
        double resultado = calc.multiplicar(80, 3);
        assertEquals(240, resultado, 0.001);
    }

    @Test
    public void testDivision() {
        Calculadora calc = new Calculadora();
        double resultado = calc.dividir(330, 3);
        assertEquals(110, resultado, 0.001);
    }

    @Test
    public void testOperacionIncorrecta() {
        Calculadora calc = new Calculadora();
        double resultado = calc.restar(90, 40);
        resultado = calc.multiplicar(resultado, 15);
        assertNotEquals(605,resultado,0.001);
    }

    @Test
    public void testResultadoIncorrecto() {
        Calculadora calc = new Calculadora();
        double resultado = calc.sumar(70, 40);
        resultado = calc.multiplicar(resultado, 25);
        assertNotEquals(2700, resultado, 0.001);
    }

}
