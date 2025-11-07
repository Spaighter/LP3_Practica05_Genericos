package Practica03;

// Clase base que representa un vehículo
class Vehiculo {
    // Método genérico para acelerar
    public void acelerar() {
        System.out.println("El vehículo está acelerando...");
    }
}

// Subclase Coche que hereda de Vehiculo
class Coche extends Vehiculo {
    @Override
    public void acelerar() {
        // Sobrescribe el método manteniendo el mismo contrato
        System.out.println("El coche acelera utilizando el motor.");
    }
}

// Subclase Bicicleta que también cumple el contrato de acelerar()
class Bicicleta extends Vehiculo {
    @Override
    public void acelerar() {
        // También acelera, pero con su propio comportamiento
        System.out.println("La bicicleta acelera mediante pedaleo.");
    }
}

// Clase principal
public class Ejercicio03_LSP {
    public static void main(String[] args) {
        // Se crean dos objetos de subclases pero se tratan como Vehiculo
        Vehiculo v1 = new Coche();
        Vehiculo v2 = new Bicicleta();

        // Ambas subclases pueden ser sustituidas sin romper la lógica
        v1.acelerar();
        v2.acelerar();
    }
}
