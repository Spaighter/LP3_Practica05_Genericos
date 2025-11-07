package Practica01;

/*
 * En este ejercicio práctico implemento fórmulas matemáticas usando variables y operaciones.
 * Calculo el área y el perímetro de un rectángulo a partir de su base y altura.
 */
public class Ejercicio_01 {
    public static void main(String[] args) {
        double base = 8.0;
        double altura = 5.0;

        double area = base * altura;
        double perimetro = 2 * (base + altura);

        System.out.println("Área del rectángulo: " + area);
        System.out.println("Perímetro del rectángulo: " + perimetro);
    }
}
