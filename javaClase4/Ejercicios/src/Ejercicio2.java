import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Ejercicio2 {
    public static void main(String[] args) {
        if(args.length == 0) {
            System.out.println("Por favor, ingrese la ruta del archivo como parámetro.");
            return;
        }
        String rutaArchivo = args[0];
        int suma = 0;
        try {
            List<String> lineas = Files.readAllLines(Path.of(rutaArchivo));
            System.out.println(lineas.size());
            System.out.println(Path.of(rutaArchivo));
            System.out.println(Files.readAllLines(Path.of(rutaArchivo)));

            for (String line : lineas) {
                System.out.println(line);
                suma += Integer.parseInt(line.trim());
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("El archivo contiene caracteres no numéricos: " + e.getMessage());
        }
        System.out.println("La suma de los números en el archivo es: " + suma);
    }
}
