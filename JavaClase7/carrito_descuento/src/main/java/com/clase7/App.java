package com.clase7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;



public final class App {
    private App() {
    }

    /**
     * Says hello to the world.
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
        Carrito carrito = new Carrito();

        try {
            //C:\Users\el_mi\OneDrive\Documents\JavaProj\javaClase2\javatest\JavaClase7\carrito_descuento\src\main\java\com\clase7\datos.txt
            System.out.println(System.getProperty("user.dir") + "\\carrito_descuento\\src\\main\\java\\com\\clase7\\datos.txt");
            File file = new File(System.getProperty("user.dir") + "\\src\\main\\java\\com\\clase7\\datos.txt");
            Scanner scanner = new Scanner(file);

            double total = 0.0;
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] data = line.split(";"); // separador de ;

                int cantidad = Integer.parseInt(data[0]);
                double precio = Double.parseDouble(data[1]);
                String nombre = data[2];
                String desc = data[3];
                double descuento = 0.0;
                double tope = 0.0;

                if(desc.endsWith("%") || Double.parseDouble(desc) < 1){
                    double porcentajeNumero = Double.parseDouble(desc.replace("%", ""));
                    //System.out.println(porcentajeNumero);
                    DescuentoPorcentaje descuentoX = new DescuentoPorcentaje(porcentajeNumero);
                    DescuentoConTope descuentoT = new DescuentoConTope(porcentajeNumero,50);
                    
                    descuento = descuentoX.aplicarDescuento(precio*cantidad, cantidad);
                    tope = descuentoT.aplicarDescuento(precio*cantidad, cantidad);

                    //System.out.println(descuento);
                    if ((precio*cantidad)-descuento>tope){
                        descuento = tope;
                    }
                    
                    System.out.println("\nel descuento supera al tope de: " + tope + " para " + nombre+"\n");
                }else{
                    double numeroFijo = Double.parseDouble(desc);
                    DescuentoFijo descuentoY = new DescuentoFijo(numeroFijo);
                    descuento = descuentoY.aplicarDescuento(precio*cantidad, cantidad);
                }

               

                total += descuento;

                Producto producto = new Producto(nombre, precio);
                ItemCarrito item = new ItemCarrito(producto, cantidad, descuento);
                

                carrito.agregarItem(item);
            }
            
            for (ItemCarrito item : carrito.getItems()) {
                Producto producto = item.getProducto();
                int cantidad = item.getCantidad();
                double precio = producto.getPrecio();
                String nombre = producto.getNombre();
                Double precioConDescuento = item.getDescuento();
                
                System.out.println(nombre + " x " + cantidad + " = " + (precio * cantidad) + " c/ desc. = " + precioConDescuento);
                
            }

            scanner.close();
            
            System.out.println("El precio total del carrito es: " + carrito.calcularTotal());
            System.out.println("El precio total del carrito con descuento es: " + total);
            System.out.println("fecha de la compra: " + carrito.getFechaCompra());
        } catch (FileNotFoundException e) {
            System.out.println("No se pudo encontrar el archivo.");
        }
 


    }
}
