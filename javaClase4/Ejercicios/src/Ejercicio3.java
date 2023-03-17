import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.Scanner;

public class Ejercicio3 {
    
    public static void main(String[] args) {
        
        if (args.length !=4){
            System.out.println("Reinicie el programa con los siguientes parametros:");
            System.out.println("\n \"c\" codificacion \"d\" decodificacion ");
            System.out.println("\n \"número\" de desplazamiento");
            System.out.println("\n \"ruta (path)\" de archivo de entreda");
            System.out.println("\n \"ruta (path)\" de archivo de salida");
            System.exit(1);
        }

        // asignacion de variables con valores de argumentos
        String tipo = args[0];
        int desplazamiento = Integer.parseInt(args[1]);
        String ruta1 = args[2];
        String ruta2 = args[3]; 

        // test
        /* 
        String tipo = "d"; // opcion c o d
        int desplazamiento = 1; 
        
        File file = new File(System.getProperty("user.dir") + "/Ejercicios/src/textoplano.txt");
        String ruta1 = file.getAbsolutePath();
        File file2 = new File(System.getProperty("user.dir") + "/Ejercicios/src/resultado.txt");
        String ruta2 = file2.getAbsolutePath();
        */

        if ("d".equals(tipo)){
            desplazamiento = desplazamiento * -1;
        }
        
        // lectura del archivo
        try {
            List<String> lineas = Files.readAllLines(Path.of(ruta1));
            
            for (String linea : lineas) {
                String fraseNueva = encrypt(linea, desplazamiento);
                Files.writeString(Path.of(ruta2), fraseNueva + "\n", StandardOpenOption.APPEND);
            }
            System.out.println("La tarea fué realizada con éxito...");
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("El archivo contiene caracteres no numéricos: " + e.getMessage());
        }

        
        


    }
    public static String encrypt(String frase, int movimiento) {

        String abecedario = " abcdefghijklmnñopqrstuvwxyz";
        char letra;
        String nuevaCadena = "";
        frase.toLowerCase();
        for(int i=0; i < frase.length(); i++) {
            letra = frase.charAt(i);
            int posicion = abecedario.indexOf(letra);
            if (posicion == -1){
                System.out.println("el archivo contiene caracteres no validos del abecedario...");
                System.exit(1);
            }
            if((posicion+movimiento) > (abecedario.length()-1)) {
                posicion = (posicion + movimiento) - abecedario.length();
                nuevaCadena = nuevaCadena + abecedario.charAt(posicion);
            }else if((posicion+movimiento)<0){
                posicion = (posicion + movimiento) + abecedario.length();
                nuevaCadena = nuevaCadena + abecedario.charAt(posicion);
            }else{
                posicion = (posicion + movimiento);
                nuevaCadena = nuevaCadena + abecedario.charAt(posicion);
            }
            
        }
        
        return nuevaCadena;
    }

}
