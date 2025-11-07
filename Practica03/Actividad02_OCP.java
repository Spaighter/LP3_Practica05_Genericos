package Practica03;

// Interfaz base para definir políticas de cancelación
interface PoliticaCancelacion {
    boolean puedeCancelar(Reserva reserva);
}

// Clase principal de reserva
class Reserva {
    private String cliente;
    private PoliticaCancelacion politica; // Se usa abstracción

    // Constructor que asigna el cliente y la política
    public Reserva(String cliente, PoliticaCancelacion politica) {
        this.cliente = cliente;
        this.politica = politica;
    }

    // Método para ejecutar la cancelación
    public boolean cancelar() {
        return politica.puedeCancelar(this);
    }

    // Devuelve el nombre del cliente
    public String getCliente() {
        return cliente;
    }
}

// Políticas concretas que implementan la interfaz (extensibles sin modificar Reserva)
class PoliticaCancelacionFlexible implements PoliticaCancelacion {
    public boolean puedeCancelar(Reserva reserva) {
        System.out.println("Cancelación flexible aplicada. Sin penalización.");
        return true;
    }
}

class PoliticaCancelacionModerada implements PoliticaCancelacion {
    public boolean puedeCancelar(Reserva reserva) {
        System.out.println("Cancelación moderada. Penalización del 50%.");
        return true;
    }
}

class PoliticaCancelacionEstricta implements PoliticaCancelacion {
    public boolean puedeCancelar(Reserva reserva) {
        System.out.println("No se permite cancelar la reserva.");
        return false;
    }
}

// Clase principal que prueba las políticas
public class Actividad02_OCP {
    public static void main(String[] args) {
        // Se crean reservas con diferentes políticas
        Reserva r1 = new Reserva("Michael", new PoliticaCancelacionFlexible());
        Reserva r2 = new Reserva("Favio", new PoliticaCancelacionEstricta());

        // Se ejecutan las cancelaciones
        r1.cancelar();
        r2.cancelar();
    }
}
