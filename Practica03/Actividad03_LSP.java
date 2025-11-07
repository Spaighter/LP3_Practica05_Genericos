package Practica03;

// Clase base genérica
class HabitacionBase {
    public void asignarCliente(String cliente) {
        System.out.println("Cliente " + cliente + " asignado a habitación estándar.");
    }
}

// Subclase 1: cumple el contrato del método base
class HabitacionDoble extends HabitacionBase {
    @Override
    public void asignarCliente(String cliente) {
        System.out.println("Cliente " + cliente + " asignado a habitación doble.");
    }
}

// Subclase 2: también cumple el contrato
class HabitacionSuite extends HabitacionBase {
    @Override
    public void asignarCliente(String cliente) {
        System.out.println("Cliente " + cliente + " asignado a habitación suite con jacuzzi.");
    }
}

// Clase principal que prueba la sustitución
public class Actividad03_LSP {
    public static void main(String[] args) {
        // Las subclases pueden reemplazar la superclase sin errores
        HabitacionBase h1 = new HabitacionDoble();
        HabitacionBase h2 = new HabitacionSuite();

        // Ambas instancias pueden usarse como HabitacionBase
        h1.asignarCliente("Piero");
        h2.asignarCliente("Michael");
    }
}
