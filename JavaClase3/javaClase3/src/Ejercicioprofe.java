import java.util.Scanner;
import java.util.Random;

public class Ejercicioprofe {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("ingrese el tamaño del array: ");
        int tamaño = scanner.nextInt();

        int[] array = generarCadena(tamaño);
        int[] definitivo = comprobar(array);
        imprimir(definitivo);

    }
    public static void imprimir(int[] array) {
        for(int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
    public static int[] generarCadena(int tamaño) {
        Random rand = new Random();
        int[] arr = new int[tamaño];
        for(int i=0; i<tamaño; i++) {
            arr[i] = rand.nextInt(10);
            System.out.print(arr[i]+ " ");
        }
        return arr;
    }

    public static int[] comprobar(int[] arr) {
        for(int i=0;i<arr.length-1;i++) {
            for(int j=i+1;j<arr.length;j++) {
                //System.out.println(arr[i] + " VS " + arr[j]);
                if(arr[j]==arr[i]) {
                    System.out.println("Duplicado encontrado...");
                    int[] nuevo = generarCadena(1);
                    arr[j] = nuevo[0];
                    comprobar(arr);
                }
            }
        }
        return arr;
    }
}
