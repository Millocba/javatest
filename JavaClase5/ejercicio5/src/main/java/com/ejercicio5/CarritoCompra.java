package com.ejercicio5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CarritoCompra {
    public static void main(String[] args) {
        Carrito carrito = new Carrito();

        try {
            //C:\Users\el_mi\OneDrive\Documents\JavaProj\javaClase2\javatest\JavaClase5\ejercicio5\src\main\java\com\ejercicio5\datos.txt
            //System.out.println(System.getProperty("user.dir") + "\\ejercicio5\\src\\main\\java\\com\\ejercicio5\\datos.txt");
            File file = new File(System.getProperty("user.dir") + "\\ejercicio5\\src\\main\\java\\com\\ejercicio5\\datos.txt");
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] data = line.split(";"); // separador de tabs

                int cantidad = Integer.parseInt(data[0]);
                double precio = Double.parseDouble(data[1]);
                String nombre = data[2];

                Producto producto = new Producto(nombre, precio);
                ItemCarrito item = new ItemCarrito(producto, cantidad);

                carrito.agregarItem(item);
            }
            
            for (ItemCarrito item : carrito.getItems()) {
                Producto producto = item.getProducto();
                int cantidad = item.getCantidad();
                double precio = producto.getPrecio();
                String nombre = producto.getNombre();
                
                // Mostrar información del producto y la cantidad en el carrito
                System.out.println(nombre + " x " + cantidad + " = " + (precio * cantidad));
            }

            scanner.close();

            System.out.println("El precio total del carrito es: " + carrito.calcularTotal());
        } catch (FileNotFoundException e) {
            System.out.println("No se pudo encontrar el archivo.");
        }
    }
 
}