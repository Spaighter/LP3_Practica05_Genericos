package Practica01;

/*
 * En esta actividad practico el uso de variables, operadores y tipos de datos básicos.
 */
public class Actividad_02 {
    public static void main(String[] args) {
        // Declaro variables de distintos tipos
        int numero1 = 10;
        int numero2 = 5;
        double resultado;

        // Realizo operaciones aritméticas
        resultado = numero1 + numero2;
        System.out.println("Suma: " + resultado);

        resultado = numero1 - numero2;
        System.out.println("Resta: " + resultado);

        resultado = numero1 * numero2;
        System.out.println("Multiplicación: " + resultado);

        resultado = (double) numero1 / numero2;
        System.out.println("División: " + resultado);
    }
}
