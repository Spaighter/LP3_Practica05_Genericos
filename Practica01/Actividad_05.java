package Practica01;

/*
 * En esta actividad trabajo con arreglos (vectores) en Java.
 * Aprendo a almacenar varios valores del mismo tipo en una sola variable.
 */
public class Actividad_05 {
    public static void main(String[] args) {
        int[] numeros = {10, 20, 30, 40, 50};

        System.out.println("Elementos del arreglo:");
        for (int i = 0; i < numeros.length; i++) {
            System.out.println("Posición " + i + ": " + numeros[i]);
        }

        // Calculo el promedio de los elementos
        int suma = 0;
        for (int n : numeros) {
            suma += n;
        }
        double promedio = (double) suma / numeros.length;
        System.out.println("Promedio del arreglo: " + promedio);
    }
}
