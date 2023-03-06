import java.util.Scanner;

public class Ejercicio1 {
    public static void main(String[] args) throws Exception {
        
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;

        do {
            System.out.println("\n\n***************MENU*******************");
            
            System.out.println("*   1. Contar letras                 *");
            System.out.println("*   2. Ordenar tres números          *");
            System.out.println("*   3. Sumar números mayores que X   *");
            System.out.println("*   4. Salir                         *");
            System.out.println("**************************************");
            System.out.print("Elija una opción: ");

            opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
        
                    System.out.println("ingrese la palabra: ");
                    String palabra = scanner.next();
                    System.out.println("ingrese la letra: ");
                    String letra = scanner.next();
                    int cantidad = contarLetra(palabra, letra.charAt((letra.length()-1)));
                    System.out.println("Cantidad: " + cantidad);
                    
                break;
                case 2:
                    int[] nume = new int[3];

                    System.out.println("ingrese 3 números: ");
                    for (int i = 0;i < 3;i++){
                        nume[i] = scanner.nextInt();
                    }
                    
                    System.out.println("ingrese el orden ascendente/descendente: ");
                    String orden = scanner.next();
                    int[] ordenado = ordenarNumeros(nume, orden);
                    for (int i = 0; i < ordenado.length; i++) {
                        System.out.println("Elemento en la posición " + i + ": " + ordenado[i]);
                      }
                break;
                case 3:

                    System.out.println("ingrese tamaño del vector: ");
                    int tamaño = scanner.nextInt();
                    System.out.println("ingrese números: ");
                    int[] numeros = new int[(tamaño)];
                    for (int i = 0;i < tamaño;i++){
                        numeros[i] = scanner.nextInt();
                    }
                    System.out.println("ingrese valor de X: ");
                    int x = scanner.nextInt();

                    int suma = sumarNumerosMayoresQueX(numeros, x);
                    System.out.println("la suma de los mayores a X es : " + suma);
                break;
                default:
            }
        } while (opcion != 4);
        scanner.close();  

    }    
    public static int contarLetra(String palabra, char letra) {
        int contador = 0;
        for (int i = 0; i < palabra.length(); i++) {
            if (palabra.charAt(i) == letra) {
                contador++;
            }
        }
        return contador;
    }

    public static int[] ordenarNumeros(int[] nume, String orden) {
        int[] numeros = nume;
        if (orden.equals("ascendente")) {
            for (int i = 0; i < numeros.length - 1; i++) {
                for (int j = i + 1; j < numeros.length; j++) {
                    if (numeros[i] > numeros[j]) {
                        int aux = numeros[i];
                        numeros[i] = numeros[j];
                        numeros[j] = aux;
                    }
                }
            }
        } else if (orden.equals("descendente")) {
            for (int i = 0; i < numeros.length - 1; i++) {
                for (int j = i + 1; j < numeros.length; j++) {
                    if (numeros[i] < numeros[j]) {
                        int aux = numeros[i];
                        numeros[i] = numeros[j];
                        numeros[j] = aux;
                    }
                }
            }
        }
        return numeros;
    }

    public static int sumarNumerosMayoresQueX(int[] numeros, int x) {
        int resultado = 0;
        for (int i = 0; i < numeros.length; i++) {
            if (numeros[i] > x) {
                resultado += numeros[i];
            }
        }
        return resultado;
    }
    

    
}
