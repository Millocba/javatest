package com.clase9;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Hello world!
 */
public final class App {
    private App() {
    }

    /**
     * Says hello to the world.
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Persona> personas = new ArrayList<>();

        while (true) {
            System.out.println("Ingrese el nombre de la persona (o escriba 'salir' para listar): ");
            String nombre = scanner.nextLine();

            if (nombre.equals("salir")) {
                scanner.close();
                break;
            }

            System.out.println("Ingrese el apellido de la persona: ");
            String apellido = scanner.nextLine();

            System.out.println("Ingrese la fecha de nacimiento de la persona (en formato AAAA-MM-DD): ");
            LocalDate fechaNacimiento = LocalDate.parse(scanner.nextLine());

            Persona persona = new Persona(nombre, apellido, fechaNacimiento);
            personas.add(persona);
            System.out.println("\nPersona agregada......'\n\n");
        }

        System.out.println("\nListado de personas:");
        for (Persona persona : personas) {
            System.out.println(persona.getNombre() + " " + persona.getApellido() + " - Fecha de nacimiento: " + persona.getFechaNacimiento());
        }
    }
}
