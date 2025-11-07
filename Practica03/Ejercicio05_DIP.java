package Practica03;

// Interfaz que define el método de salida de datos
interface DispositivoSalida {
    void enviarDatos(String datos);
}

// Implementación concreta: salida por impresora
class Impresora implements DispositivoSalida {
    public void enviarDatos(String datos) {
        System.out.println("🖨️ Imprimiendo: " + datos);
    }
}

// Implementación concreta: salida por almacenamiento en nube
class AlmacenamientoNube implements DispositivoSalida {
    public void enviarDatos(String datos) {
        System.out.println("☁️ Guardando en la nube: " + datos);
    }
}

// Clase de alto nivel que depende de la abstracción (no de una clase específica)
class GestorReporte {
    private DispositivoSalida salida;

    // Constructor que recibe la interfaz (inyección de dependencia)
    public GestorReporte(DispositivoSalida salida) {
        this.salida = salida;
    }

    // Envía un reporte usando el medio de salida elegido
    public void generarReporte(String contenido) {
        System.out.println("Generando reporte...");
        salida.enviarDatos(contenido);
    }
}

// Clase principal que prueba la inyección de dependencias
public class Ejercicio05_DIP {
    public static void main(String[] args) {
        // Se crean dos dispositivos diferentes
        DispositivoSalida impresora = new Impresora();
        DispositivoSalida nube = new AlmacenamientoNube();

        // Se inyecta la dependencia en el gestor
        GestorReporte gestor1 = new GestorReporte(impresora);
        GestorReporte gestor2 = new GestorReporte(nube);

        // Se envían reportes usando distintos canales
        gestor1.generarReporte("Reporte de ventas - Enero 2025");
        gestor2.generarReporte("Backup de datos - Enero 2025");
    }
}
