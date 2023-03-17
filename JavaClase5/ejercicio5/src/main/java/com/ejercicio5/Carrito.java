package com.ejercicio5;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Carrito {
    private List<ItemCarrito> items;
    private LocalDate fechaCompra;

    public Carrito() {
        this.items = new ArrayList<>();
        this.fechaCompra = LocalDate.now();
    }

    public void agregarItem(ItemCarrito item) {
        items.add(item);
    }

    public void eliminarItem(ItemCarrito item) {
        items.remove(item);
    }

    public double calcularTotal() {
        double total = 0;
        for (ItemCarrito item : items) {
            total += item.getProducto().getPrecio() * item.getCantidad();
        }
        return total;
    }

    public LocalDate getFechaCompra() {
        return fechaCompra;
    }

    public List<ItemCarrito> getItems() {
        return items;
    }
}

class Producto {
    private String nombre;
    private double precio;

    public Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }
}

class ItemCarrito {
    private Producto producto;
    private int cantidad;

    public ItemCarrito(Producto producto, int cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public Producto getProducto() {
        return producto;
    }

    public int getCantidad() {
        return cantidad;
    }
}

abstract class Descuento {
    private double porcentaje;

    public Descuento(double porcentaje) {
        this.porcentaje = porcentaje;
    }

    public double getPorcentaje() {
        return porcentaje;
    }

    public abstract double aplicarDescuento(double precio, int cantidad);
}

class DescuentoPorCantidad extends Descuento {
    private int cantidadMinima;

    public DescuentoPorCantidad(double porcentaje, int cantidadMinima) {
        super(porcentaje);
        this.cantidadMinima = cantidadMinima;
    }

    @Override
    public double aplicarDescuento(double precio, int cantidad) {
        if (cantidad >= cantidadMinima) {
            return precio * (1 - getPorcentaje() / 100);
        } else {
            return precio;
        }
    }
}

class DescuentoPorPrecio extends Descuento {
    private double precioMinimo;

    public DescuentoPorPrecio(double porcentaje, double precioMinimo) {
        super(porcentaje);
        this.precioMinimo = precioMinimo;
    }

    @Override
    public double aplicarDescuento(double precio, int cantidad) {
        if (precio >= precioMinimo) {
            return precio * (1 - getPorcentaje() / 100);
        } else {
            return precio;
        }
    }
}

class Persona {
    private String nombre;
    private String apellido;
    private LocalDate fechaNacimiento;

    public Persona(String nombre, String apellido, LocalDate fechaNacimiento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public int calcularEdad() {
        LocalDate now = LocalDate.now();
        return Period.between(fechaNacimiento, now).getYears();
    }
}



