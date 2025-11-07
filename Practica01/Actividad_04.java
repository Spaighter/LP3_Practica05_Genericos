package Practica01;

/*
 * En esta actividad aprendo a usar bucles for y while para repetir acciones.
 */
public class Actividad_04 {
    public static void main(String[] args) {
        // Uso un bucle for para contar del 1 al 5
        System.out.println("Contando del 1 al 5:");
        for (int i = 1; i <= 5; i++) {
            System.out.println(i);
        }

        // Uso un bucle while para mostrar números pares
        System.out.println("\nNúmeros pares hasta 10:");
        int j = 2;
        while (j <= 10) {
            System.out.println(j);
            j += 2;
        }
    }
}
