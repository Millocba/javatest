import java.util.Scanner;
public class EjeA {
    public static void main(String[] args) throws Exception {
        
        // menu 
        int numeroInicio;
        int numeroFin;
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;
        do {
            System.out.println("\n\n***************MENU*******************");
            System.out.println("1. Números entre 5 y 14");
            System.out.println("2. Números pares entre 5 y 14");
            System.out.println("3. Números pares o impares entre 5 y 14");
            System.out.println("4. Números pares entre 14 y 5");
            System.out.println("5. Salir");
            System.out.print("Elija una opción: ");

            opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    System.out.println("Ejercicio A:");
                        // ejercicio 1 A
                        System.out.println("Números entre 5 y 14");
                        numeroInicio = 5;
                        numeroFin = 14;
                        while (numeroInicio < numeroFin+1) {
                            System.out.println(numeroInicio);
                            numeroInicio ++;
                        }
                        pausar(3000);
                    break;
                case 2:
                    System.out.println("Ejercicio B:");
                        // ejercicio 1 B
                        numeroInicio = 5;
                        numeroFin = 14;
                        System.out.println("Números pares entre 5 y 14");
                        while (numeroInicio < numeroFin+1) {
                            if (numeroInicio%2==0) {
                                System.out.println(numeroInicio);
                            }    
                            numeroInicio ++;

                        }
                        pausar(3000);
                    break;
                case 3:
                    System.out.println("Ejercicio C:");
                        // ejercicio 1 C
                        numeroInicio = 5;
                        numeroFin = 14;
                        
                        System.out.println("Números pares o impares entre 5 y 14");
                        System.out.print("Ingresa un número 1 para mostrar pares y 2 impares: ");
                        int numero = scanner.nextInt();
                        if (numero == 1 || numero ==2){
                            while (numeroInicio < numeroFin+1) {
                                if (numeroInicio%2==0) {
                                    if (numero==1){
                                        System.out.println(numeroInicio);
                                    }
                                } else {
                                    if (numero==2){
                                        System.out.println(numeroInicio);
                                    }
                                }
                                
                                numeroInicio ++;
                            }
                        } else {
                            System.out.println("no ha ingresado ninguna opción válida");
                        }
                        pausar(3000);
                    break;
                case 4:
                    System.out.println("Ejercicio D:");
                        // ejercicio 1 D
                        numeroInicio = 5;
                        numeroFin = 14;
                        System.out.println("Números pares entre 14 y 5");
                        for(int i=numeroFin; i>numeroInicio; i--) {
                            if (i%2==0) {
                                System.out.println(i);
                            }
                        } 
                        pausar(3000);   
                    break;
                default:
                    System.out.println("****Salir****");
                
            }
        } while (opcion != 5);
        scanner.close();      
    }
    public static void pausar(int milisegundos) {
        System.out.println("Pausa de 3 segundos");
        try {
            Thread.sleep(milisegundos); // Pausa de milisegundos
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
