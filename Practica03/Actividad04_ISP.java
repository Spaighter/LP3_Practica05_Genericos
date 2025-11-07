package Practica03;

// Interfaces específicas y pequeñas
interface ServicioLimpieza {
    void solicitarLimpieza();
}

interface ServicioComida {
    void solicitarComida(String plato);
}

interface ServicioLavanderia {
    void solicitarLavanderia();
}

// Clase económica que solo implementa limpieza
class HabitacionEconomica implements ServicioLimpieza {
    public void solicitarLimpieza() {
        System.out.println("Limpieza básica programada para habitación económica.");
    }
}

// Clase premium que ofrece todos los servicios
class HabitacionPremium implements ServicioLimpieza, ServicioComida, ServicioLavanderia {
    public void solicitarLimpieza() {
        System.out.println("Limpieza completa programada para habitación premium.");
    }

    public void solicitarComida(String plato) {
        System.out.println("Pedido recibido: " + plato);
    }

    public void solicitarLavanderia() {
        System.out.println("Servicio de lavandería solicitado.");
    }
}

// Clase principal que realiza las pruebas
public class Actividad04_ISP {
    public static void main(String[] args) {
        HabitacionEconomica he = new HabitacionEconomica();
        HabitacionPremium hp = new HabitacionPremium();

        // Solo limpieza para económica
        he.solicitarLimpieza();

        // Todos los servicios para premium
        hp.solicitarComida("Filete con ensalada");
        hp.solicitarLavanderia();
    }
}
