import java.util.Scanner;

public class Ejercicio2 {
    
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese la frase: ");
        String frase = scanner.next();
        System.out.println("Ingrese posiciones de desplazamiento: ");
        int movimiento = scanner.nextInt();
        String fraseNueva = encrypt(frase, movimiento);
        System.out.println("La nueva frase es: " + fraseNueva);

        scanner.close();  

    }
    public static String encrypt(String frase, int movimiento) {

        String abecedario = " abcdefghijklmnñopqrstuvwxyz";
        char letra;
        String nuevaCadena = "";
        frase.toLowerCase();
        for(int i=0; i < frase.length(); i++) {
            letra = frase.charAt(i);
            int posicion = abecedario.indexOf(letra);
            if((posicion+movimiento) > (abecedario.length()-1)) {
                posicion = (posicion + movimiento) - abecedario.length();
                nuevaCadena = nuevaCadena + abecedario.charAt(posicion);
            }else{
                posicion = (posicion + movimiento);
                nuevaCadena = nuevaCadena + abecedario.charAt(posicion);
            }
            
        }
        
        return nuevaCadena;
        /* String nuevaCadena = "";
        int ascii = 0;
        char ch = 0;
        for(int i = 0; i < frase.length(); i++) {
            System.out.println(frase.charAt(i));
            
            ascii = frase.charAt(i);
            
            System.out.println("El código ASCII de '" + frase.charAt(i) + "' es: " + ascii);
            
            ascii = ascii + movimiento;
            
            ch = (char) ascii;
            System.out.println("El código ASCII de '" + ch + "' es: " + ascii);
            
            nuevaCadena = nuevaCadena + ch;
        }
        return nuevaCadena; */
    }

}
