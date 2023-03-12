import java.util.Scanner;

public class Ejercicio1B {
    public static void main(String[] args) throws Exception {
        if (args.length != 4) {
            System.out.println("Por favor, proporcione 3 números y una letra que indique el orden (a = ascendente, d = descendente).");
            Scanner scanner = new Scanner(System.in);
            int num1 = scanner.nextInt();
            int num2 = scanner.nextInt();
            int num3 = scanner.nextInt();
            char orden = scanner.next().charAt(0);
            ordenar(num1, num2, num3, orden);
            scanner.close();    
        }else{
      
            // Convertir los argumentos a valores numéricos
            int num1 = Integer.parseInt(args[0]);
            int num2 = Integer.parseInt(args[1]);
            int num3 = Integer.parseInt(args[2]);
            char orden = args[3].charAt(0);
            ordenar(num1, num2, num3, orden);
        }
        
        
    }
    public static void ordenar(int num1,int num2,int num3, char orden) {
        // Ordenar los números según el criterio especificado
        if (orden == 'a') {
            if (num1 > num2) {
                int temp = num1;
                num1 = num2;
                num2 = temp;
            }
            if (num2 > num3) {
                int temp = num2;
                num2 = num3;
                num3 = temp;
            }
            if (num1 > num2) {
                int temp = num1;
                num1 = num2;
                num2 = temp;
            }
        } else if (orden == 'd') {
            if (num1 < num2) {
                int temp = num1;
                num1 = num2;
                num2 = temp;
            }
            if (num2 < num3) {
                int temp = num2;
                num2 = num3;
                num3 = temp;
            }
            if (num1 < num2) {
                int temp = num1;
                num1 = num2;
                num2 = temp;
            }
        } else {
            System.out.println("La letra debe ser 'a' (ascendente) o 'd' (descendente).");
           
        }
        
        // Mostrar los números ordenados
        System.out.println(num1 + ", " + num2 + ", " + num3);
        
    }
}