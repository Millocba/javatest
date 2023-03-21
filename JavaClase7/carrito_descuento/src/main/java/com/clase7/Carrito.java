package com.clase7;

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
    private double descuento;

    public ItemCarrito(Producto producto, int cantidad, double descuento) {
        this.producto = producto;
        this.cantidad = cantidad;
        this.descuento = descuento;
    }

    public Producto getProducto() {
        return producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getDescuento() {
        return descuento;
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

class DescuentoPorcentaje extends Descuento {

    public DescuentoPorcentaje(double porcentaje) {
        super(porcentaje);
    }

    @Override
    public double aplicarDescuento(double precio, int cantidad) {
        return Math.round(precio * (1 - (getPorcentaje() / 100)) * 100.0) / 100.0;

    }
}


class DescuentoFijo extends Descuento {
    private double valorFijo;

    public DescuentoFijo(double valorFijo) {
        super(0); // El porcentaje en este caso no se utiliza, por lo que se puede establecer en 0
        this.valorFijo = valorFijo;
    }

    @Override
    public double aplicarDescuento(double precio, int cantidad) {
        if (precio > valorFijo){
            return precio - (valorFijo*cantidad);
        }else{
            return precio;
        }
    }
}

class DescuentoConTope extends Descuento {
    private double precioTope;

    public DescuentoConTope(double porcentaje, double precioTope) {
        super(porcentaje);
        this.precioTope = precioTope;
    }

    @Override
    public double aplicarDescuento(double precio, int cantidad) {
        double descuento = Math.round(precio * (1 - (getPorcentaje() / 100)) * 100.0) / 100.0;

        if (precio - descuento < precioTope) {
            return descuento;
        } else {
            return precioTope;
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
