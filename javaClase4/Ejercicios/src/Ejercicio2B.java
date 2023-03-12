import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Ejercicio2B {
    public static void main(String[] args) {
        if(args.length == 0) {
            System.out.println("Por favor, ingrese la ruta del archivo como parámetro.");
            return;
        }
        String rutaArchivo = args[0];
        String operacion = args[1];
        int suma = 0;
        try {
            List<String> lineas = Files.readAllLines(Path.of(rutaArchivo));
            System.out.println(lineas.size());
            System.out.println(Path.of(rutaArchivo));
            System.out.println(Files.readAllLines(Path.of(rutaArchivo)));


            if (operacion.equals("suma")) {
                for (String line : lineas) {
                    System.out.println(line);
                    suma += Integer.parseInt(line.trim());
                }
            } else if (operacion.equals("multiplicacion")) {
                System.out.println(operacion);
                if (lineas.size()>0) {suma = 1;}
                for (String line : lineas) {
                    System.out.println(line);
                    
                    suma *= Integer.parseInt(line.trim());
                }
            } else {
                System.err.println("Operación no válida");
                System.exit(1);
            }
            
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("El archivo contiene caracteres no numéricos: " + e.getMessage());
        }
        System.out.println("La " + operacion + " de los números en el archivo es: " + suma);
    }
}
