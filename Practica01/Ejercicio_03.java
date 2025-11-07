package Practica01;

/*
 * En este ejercicio aprendo a crear y llamar métodos en Java.
 * Implemento métodos para sumar, restar y multiplicar dos números.
 */
public class Ejercicio_03 {
    public static void main(String[] args) {
        int a = 6;
        int b = 3;

        System.out.println("Suma: " + sumar(a, b));
        System.out.println("Resta: " + restar(a, b));
        System.out.println("Multiplicación: " + multiplicar(a, b));
    }

    // Método para sumar
    public static int sumar(int x, int y) {
        return x + y;
    }

    // Método para restar
    public static int restar(int x, int y) {
        return x - y;
    }

    // Método para multiplicar
    public static int multiplicar(int x, int y) {
        return x * y;
    }
}
