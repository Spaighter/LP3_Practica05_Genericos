package Practica01;

/*
 * En este ejercicio uso arreglos y condiciones para calcular el promedio de notas
 * e indicar si el alumno aprueba o desaprueba.
 */
public class Ejercicio_02 {
    public static void main(String[] args) {
        double[] notas = {15.5, 12.0, 18.0, 14.5, 16.0};
        double suma = 0;

        for (double nota : notas) {
            suma += nota;
        }

        double promedio = suma / notas.length;

        System.out.println("Promedio del alumno: " + promedio);
        if (promedio >= 13) {
            System.out.println("Estado: Aprobado");
        } else {
            System.out.println("Estado: Desaprobado");
        }
    }
}
