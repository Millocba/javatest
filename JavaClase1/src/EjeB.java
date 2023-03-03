import java.util.Scanner;
public class EjeB {
    public static void main(String[] args) throws Exception {

    Scanner scanner = new Scanner(System.in);

    System.out.print("Ingresa sus datos para indicar la categoria que pertenece:\n");

    System.out.print("**********************************************************\n");

    System.out.print("Ingresos totales del grupo familiar:");

    float ingresos = scanner.nextInt();

    System.out.print("Cantidad de inmuebles:");

    int viviendas = scanner.nextInt();

    System.out.print("Cantidad de vehículos con menos de 3 años de antiguedad:");

    int vehiculos = scanner.nextInt();

    if (ingresos>= 572386.5 && viviendas >=3 && vehiculos >= 3){
        System.out.println("\npertenece al segmento de ingresos altos");
    } else if (ingresos < 163539 && viviendas <=1 && vehiculos < 1){
        System.out.println("\npertenece al segmento de menores ingresos");
    } else{
        System.out.println("\npertenece al segmento de ingresos medios");
    }

    scanner.close();
    }
}
