package Practica03;

// Interfaz que define el canal de notificación
interface CanalNotificacion {
    void enviarNotificacion(String mensaje);
}

// Implementación 1: Correo
class EnviadorCorreo implements CanalNotificacion {
    public void enviarNotificacion(String mensaje) {
        System.out.println("📧 Enviando correo: " + mensaje);
    }
}

// Implementación 2: SMS
class EnviadorSMS implements CanalNotificacion {
    public void enviarNotificacion(String mensaje) {
        System.out.println("📱 Enviando SMS: " + mensaje);
    }
}

// Clase de alto nivel que depende de la abstracción
class NotificadorReserva {
    private CanalNotificacion canal; // Dependencia inyectada

    // Constructor recibe la interfaz (no una clase concreta)
    public NotificadorReserva(CanalNotificacion canal) {
        this.canal = canal;
    }

    // Envía una notificación usando el canal configurado
    public void notificar(String mensaje) {
        canal.enviarNotificacion(mensaje);
    }
}

// Clase principal que realiza las pruebas
public class Actividad05_DIP {
    public static void main(String[] args) {
        // Se crean canales distintos
        CanalNotificacion correo = new EnviadorCorreo();
        CanalNotificacion sms = new EnviadorSMS();

        // Se inyectan en el notificador
        NotificadorReserva notificadorCorreo = new NotificadorReserva(correo);
        NotificadorReserva notificadorSMS = new NotificadorReserva(sms);

        // Se envían mensajes usando distintos medios
        notificadorCorreo.notificar("Reserva confirmada para el cliente Michael.");
        notificadorSMS.notificar("Tu reserva fue cancelada exitosamente.");
    }
}

