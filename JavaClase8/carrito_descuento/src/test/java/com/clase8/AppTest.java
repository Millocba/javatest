package com.clase8;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit test for simple App.
 */
class AppTest {
    /**
     * Rigorous Test.
     * @throws PrecioCero
     * @throws DescuentoNegativo
     */
    @Test
    void testPrecioCero() throws DescuentoNegativo, PrecioCero {

        try{

            new ItemCarrito(new Producto("Test", 0), 10, 0.0);
        }catch(PrecioCero e){

        assertEquals(" el precio no puede ser 0.0", e.getMensaje());
        }
    }

    @Test
    void testDescuentoNegativo() throws DescuentoNegativo, PrecioCero {

        try{

            new ItemCarrito(new Producto("Test", 30), 10, 50);
        }catch(PrecioCero e){

        assertEquals(" el descuento no puede ser negativo -80.0", e.getMensaje());
        }
    }
}
