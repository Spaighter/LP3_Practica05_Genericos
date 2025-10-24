package practica06_MVC;

import java.util.List;

/*
 * Controlador del patrón MVC.
 * Coordina las operaciones del modelo y vista.
 */
public class actividad3_PedidoControlador {
    private actividad3_PedidoModelo modelo;
    private actividad3_PedidoVista vista;

    public actividad3_PedidoControlador(actividad3_PedidoModelo modelo, actividad3_PedidoVista vista) {
        this.modelo = modelo;
        this.vista = vista;
    }

    public void iniciar() {
        String opcion;
        do {
            vista.mostrarMenu();
            opcion = vista.solicitarOpcion();
            switch (opcion) {
                case "1": agregarPedido(); break;
                case "2": mostrarPedidos(); break;
                case "3": marcarCompleto(); break;
                case "4": mostrarPendientes(); break;
                case "5": mostrarCompletos(); break;
                case "6": eliminarPedido(); break;
                case "7": mostrarHistorial(); break;
                case "8": contarPendientes(); break;
                case "9": vista.mostrarMensaje("Saliendo del sistema..."); break;
                default: vista.mostrarMensaje("Opción no válida. Inténtalo nuevamente.");
            }
        } while (!opcion.equals("9"));
        vista.cerrarScanner();
    }

    private void agregarPedido() {
        String nombre = vista.solicitarNombrePlato();
        String tipo = vista.solicitarTipoPlato();
        modelo.agregarPedido(new actividad3_Pedido(nombre, tipo));
        vista.mostrarMensaje("Pedido agregado correctamente.");
    }

    private void mostrarPedidos() {
        vista.mostrarPedidos(modelo.getPedidos());
    }

    private void marcarCompleto() {
        String nombre = vista.solicitarNombrePlato();
        if (modelo.marcarComoCompleto(nombre)) {
            vista.mostrarMensaje("Pedido marcado como completo.");
        } else {
            vista.mostrarMensaje("No se encontró el pedido o ya fue eliminado.");
        }
    }

    private void mostrarPendientes() {
        vista.mostrarPedidos(modelo.obtenerPorEstado("Pendiente"));
    }

    private void mostrarCompletos() {
        vista.mostrarPedidos(modelo.obtenerPorEstado("Completo"));
    }

    private void eliminarPedido() {
        String nombre = vista.solicitarNombrePlato();
        if (modelo.eliminarPedido(nombre)) {
            vista.mostrarMensaje("Pedido eliminado correctamente.");
        } else {
            vista.mostrarMensaje("No se encontró el pedido.");
        }
    }

    private void mostrarHistorial() {
        vista.mostrarPedidos(modelo.getHistorial());
    }

    private void contarPendientes() {
        int cantidad = modelo.contarPendientes();
        vista.mostrarMensaje("Pedidos pendientes: " + cantidad);
    }
}
