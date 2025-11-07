package Practica03;

// Interfaz común para todas las figuras
interface Figura {
    double calcularArea(); // Método que cada figura implementará a su manera
}

// Clase para calcular el área de un círculo
class Circulo implements Figura {
    private double radio;

    // Constructor para inicializar el radio
    public Circulo(double radio) {
        this.radio = radio;
    }

    // Implementación del método para el círculo
    public double calcularArea() {
        return Math.PI * radio * radio;
    }
}

// Clase para calcular el área de un rectángulo
class Rectangulo implements Figura {
    private double ancho;
    private double alto;

    public Rectangulo(double ancho, double alto) {
        this.ancho = ancho;
        this.alto = alto;
    }

    public double calcularArea() {
        return ancho * alto;
    }
}

// Clase para calcular el área de un triángulo
class Triangulo implements Figura {
    private double base;
    private double altura;

    public Triangulo(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }

    public double calcularArea() {
        return (base * altura) / 2;
    }
}

// Clase principal que prueba el principio OCP
public class Ejercicio02_OCP {
    public static void main(String[] args) {
        // Se crean objetos de distintas figuras
        Figura f1 = new Circulo(5);    // Radio 5
        Figura f2 = new Rectangulo(4, 6); // Base 4, altura 6
        Figura f3 = new Triangulo(3, 8);  // Base 3, altura 8

        // Se imprimen los resultados sin modificar las clases existentes
        System.out.println("Área del círculo: " + f1.calcularArea());
        System.out.println("Área del rectángulo: " + f2.calcularArea());
        System.out.println("Área del triángulo: " + f3.calcularArea());
    }
}
