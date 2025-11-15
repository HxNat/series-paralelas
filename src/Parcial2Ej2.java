import java.util.Scanner;

public class Parcial2Ej2 {
    
    public static int[] LeerArreglo (int n) {
        int[] arr = new int[n];
        Scanner sc = new Scanner (System.in);
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        return arr;
    }

//Suma elemento a elemento

    public static int[] sumaElementoElemento(int[] a, int[] b) {
        int n = a.length;

        int[] c = new int[n];
        for (int i = 0; i < n; i++) {
            c[i] = a[i] + b[i];
        }
        return c;
    }

//Producto escalar

    public static int productoEscalar(int[] a, int[] b) {
        int n = a.length;
        if (b.length != n) return 0;

        int suma = 0;
        for (int i = 0; i < n; i++) {
            suma += a[i] * b[i];
        }
        return suma;

    }

//Detección de rotación a la derecha.

    public static int rotacionDerechaDeAParaObtenerB(int[] a, int[] b) {
        int n = a.length;
        if (b.length != n) return -1;

        for (int k = 0; k < n; k++) {
            boolean iguales = true;
            for (int i = 0; i < n; i++) {
                int rot = (i - k + n) % n;
                if (a[rot] != b[i]) {
                    iguales = false;
                    break;
                }
            }
            if (iguales) return k;
        }
        return -1;
    }

//
    //Pa que funcione
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese N (5-50): ");
        int n = sc.nextInt();

        if (n < 5 || n > 50) {
            System.out.println("N fuera de rango.");
            return;
        }

        System.out.println("Ingrese los " + n + " elementos del arreglo A:");
        int[] A = LeerArreglo(n);

        System.out.println("Ingrese los " + n + " elementos del arreglo B:");
        int[] B = LeerArreglo(n);

        // Suma
        int[] suma = sumaElementoElemento(A, B);
        System.out.print("Suma elemento a elemento: ");
        for (int x : suma) System.out.print(x + " ");
        System.out.println();

        // Producto escalar
        int prod = productoEscalar(A, B);
        System.out.println("Producto escalar: " + prod);

        // Rotación
        int k = rotacionDerechaDeAParaObtenerB(A, B);
        System.out.println("Rotación derecha para obtener B: " + k);
    }
}