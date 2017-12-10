package ordenacion;

import java.util.Scanner;

public class Ord{

    public static void main(String[] args) {
        int a[];
        int n, opcion;
        System.out.print("Entrada de los elementos: ");
        Scanner teclado;
        teclado = new Scanner(System.in);
        n = teclado.nextInt();
        a = new int[n];

        omplirArray(a);
        System.out.print("Array desordenado: ");
        imprimirArray(a);

        System.out.println(" ");
        System.out.println("¿Que ordenacion quieres usar?");
        System.out.println("1. Intercambio");
        System.out.println("2. Seleccion");
        System.out.println("3. Insercion");
        System.out.println("4. Burbuja2");
        System.out.println("5. Salir");

        System.out.print("Escribe una de las opciones: ");
        teclado = new Scanner(System.in);
        opcion = teclado.nextInt();

        switch (opcion) {
            case 1:
                System.out.println("Ordenacion por Intercambio");
                ordIntercambio(a);
                break;
            case 2:
                System.out.println("Ordenacion por Seleccion");
                ordSeleccion(a);
                break;
            case 3:
                System.out.println("Ordenacion por Insercion");
                ordInsercion(a);
                break;
            case 4:
                System.out.println("Ordenacion por Burbuja2");
                ordBurbuja2(a);
                break;
            default:
                System.out.println("Solo números entre 1 y 5");
                break;
        }

        System.out.print("Array ordenado: ");
        imprimirArray(a);
        System.out.println(" ");
    }

    private static void omplirArray(int a[]) {
        for (int i = 0; i < a.length; i++) {
            a[i] = (int) (Math.random() * 1000);
        }
    }

    private static void imprimirArray(int a[]) {
        for (int i = 0; i < a.length;
                i++) {
            System.out.print(a[i] + "  ");
        }
    }

    private static void ordIntercambio(int a[]) {
        // Controlar el nomnbre de passades a realitzar 
        for (int passadaActual = 0; passadaActual <= a.length - 2; passadaActual++) {

            // Fer una passada
            for (int elementActual = passadaActual + 1; elementActual <= a.length - 1; elementActual++) {

                if (a[passadaActual] > a[elementActual]) {
                    // Realitzar un intercanvi
                    int aux = a[passadaActual];
                    a[passadaActual] = a[elementActual];
                    a[elementActual] = aux;
                }
            }
        }
    }

    private static void ordSeleccion(int a[]) {
        int indiceMenor;
        for (int passadaActual = 0; passadaActual < a.length - 1; passadaActual++) {
            indiceMenor = passadaActual;
            for (int elementActual = passadaActual + 1; elementActual < a.length; elementActual++) {
                if (a[elementActual] < a[indiceMenor]) {
                    indiceMenor = elementActual;
                }
            }
            if (passadaActual != indiceMenor) {
                int aux = a[passadaActual];
                a[passadaActual] = a[indiceMenor];
                a[indiceMenor] = aux;
            }

        }
    }

    private static void ordInsercion(int a[]) {
        int aux;
        for (int passadaActual = 1; passadaActual < a.length; passadaActual++) {
            int elementActual;
            elementActual = passadaActual;
            aux = a[passadaActual];
            while (elementActual > 0 && aux < a[elementActual - 1]) {
                a[elementActual] = a[elementActual - 1];
                elementActual--;
            }
            a[elementActual] = aux;
        }
    }

    /*private static void ordBurbuja(int a[], int n) {
        int interruptor = 1;
        int pasada, j;
        for (pasada = 0; pasada < a.length - 1 && interruptor; pasada++) {
            if (a.length = interruptor;){
                for (j = 0; j < n - pasada - 1; j++) {
                    if (a[j] > a[j + 1]) {
                        int aux;
                        interruptor = 1;
                        aux = a[j];
                        a[j] = a[j + 1];
                        a[j + 1] = aux;
                    }
                }
            }    
        }
    }*/
    private static void ordBurbuja2(int a[]) {
        int passadaActual;
        int indiceIntercambio;
        passadaActual = a.length - 1;
        while (passadaActual > 0) {
            indiceIntercambio = 0;
            for (int elementActual = 0; elementActual < passadaActual; elementActual++) {
                if (a[elementActual + 1] < a[elementActual]) {
                    int aux = a[elementActual];
                    a[elementActual] = a[elementActual + 1];
                    a[elementActual + 1] = aux;
                    indiceIntercambio = elementActual;
                }
            }
            passadaActual = indiceIntercambio;
        }
    }
}
