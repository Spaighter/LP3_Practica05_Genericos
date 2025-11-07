package Practica01;

/*
 * En esta actividad uso estructuras condicionales para tomar decisiones.
 * Comparo dos números e indico cuál es mayor.
 */
public class Actividad_03 {
    public static void main(String[] args) {
        int a = 8;
        int b = 12;

        if (a > b) {
            System.out.println(a + " es mayor que " + b);
        } else if (a < b) {
            System.out.println(b + " es mayor que " + a);
        } else {
            System.out.println("Ambos números son iguales.");
        }
    }
}
