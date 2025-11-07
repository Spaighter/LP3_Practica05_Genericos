package Practica03;

import java.util.ArrayList;
import java.util.List;

// Clase que representa una habitación del hotel
class Habitacion {
    private String tipo;
    private boolean disponible;
    private GestorDisponibilidadHabitacion gestor;

    // Constructor que inicializa número y tipo de habitación
    public Habitacion(int numero, String tipo) {
        this.tipo = tipo;
        this.disponible = true; // Por defecto, la habitación está disponible
        this.gestor = new GestorDisponibilidadHabitacion(); // Se crea el gestor para verificar disponibilidad
    }

    // Método que consulta la disponibilidad usando el gestor
    public boolean verificarDisponibilidad() {
        return gestor.verificarDisponibilidad(this);
    }

    // Cambia el estado de disponibilidad
    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    // Retorna si la habitación está libre o no
    public boolean isDisponible() {
        return disponible;
    }

    // Retorna el tipo de habitación
    public String getTipo() {
        return tipo;
    }
}

// Clase que se encarga únicamente de gestionar la disponibilidad (cumpliendo SRP)
class GestorDisponibilidadHabitacion {
    private List<Habitacion> listaHabitaciones = new ArrayList<>();

    // Registra una nueva habitación en la lista interna
    public void registrarHabitacion(Habitacion h) {
        listaHabitaciones.add(h);
    }

    // Verifica si una habitación está disponible
    public boolean verificarDisponibilidad(Habitacion h) {
        return h.isDisponible();
    }
}

// Clase principal que realiza las pruebas del sistema
public class Actividad01_SRP {
    public static void main(String[] args) {
        // Se crean dos habitaciones
        Habitacion h1 = new Habitacion(101, "Simple");
        Habitacion h2 = new Habitacion(102, "Doble");

        // Se instancia el gestor para registrar las habitaciones
        GestorDisponibilidadHabitacion gestor = new GestorDisponibilidadHabitacion();
        gestor.registrarHabitacion(h1);
        gestor.registrarHabitacion(h2);

        // Se consulta disponibilidad antes y después de ocupar la habitación
        System.out.println("Habitación 101 disponible: " + h1.verificarDisponibilidad());
        h1.setDisponible(false); // Cambia el estado de la habitación
        System.out.println("Habitación 101 disponible: " + h1.verificarDisponibilidad());
    }
}
