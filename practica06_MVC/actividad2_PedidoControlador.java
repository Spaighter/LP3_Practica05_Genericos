package practica06_MVC;

import java.util.List;

/*
 * Controlador del patrón MVC.
 * Gestiona las acciones del usuario y coordina modelo y vista.
 */
public class actividad2_PedidoControlador {
    private actividad2_PedidoModelo modelo;
    private actividad2_PedidoVista vista;

    public actividad2_PedidoControlador(actividad2_PedidoModelo modelo, actividad2_PedidoVista vista) {
        this.modelo = modelo;
        this.vista = vista;
    }

    public void iniciar() {
        String opcion;
        do {
            vista.mostrarMenu();
            opcion = vista.solicitarOpcion();
            switch (opcion) {
                case "1":
                    agregarPedido();
                    break;
                case "2":
                    eliminarPedido();
                    break;
                case "3":
                    actualizarPedido();
                    break;
                case "4":
                    buscarPedido();
                    break;
                case "5":
                    mostrarPedidos();
                    break;
                case "6":
                    contarPedidos();
                    break;
                case "7":
                    vista.mostrarMensaje("Saliendo...");
                    break;
                default:
                    vista.mostrarMensaje("Opción no válida. Intenta de nuevo.");
            }
        } while (!opcion.equals("7"));
        vista.cerrarScanner();
    }

    private void agregarPedido() {
        String nombre = vista.solicitarNombrePlato();
        String tipo = vista.solicitarTipoPlato();
        modelo.agregarPedido(new actividad2_Pedido(nombre, tipo));
        vista.mostrarMensaje("Pedido agregado correctamente.");
    }

    private void eliminarPedido() {
        String nombre = vista.solicitarNombrePlato();
        if (modelo.eliminarPedido(nombre)) {
            vista.mostrarMensaje("Pedido eliminado: " + nombre);
        } else {
            vista.mostrarMensaje("No se encontró el pedido: " + nombre);
        }
    }

    private void actualizarPedido() {
        String nombreActual = vista.solicitarNombrePlato();
        String nuevoNombre = vista.solicitarNombrePlato();
        String nuevoTipo = vista.solicitarTipoPlato();
        if (modelo.actualizarPedido(nombreActual, nuevoNombre, nuevoTipo)) {
            vista.mostrarMensaje("Pedido actualizado correctamente.");
        } else {
            vista.mostrarMensaje("No se encontró el pedido a actualizar.");
        }
    }

    private void buscarPedido() {
        String criterio = vista.solicitarNombrePlato();
        List<actividad2_Pedido> encontrados = modelo.buscarPedido(criterio);
        vista.mostrarPedidos(encontrados);
    }

    private void mostrarPedidos() {
        vista.mostrarPedidos(modelo.getPedidos());
    }

    private void contarPedidos() {
        int total = modelo.contarPedidos();
        vista.mostrarMensaje("Total de pedidos: " + total);
        String tipo = vista.solicitarTipoPlato();
        int porTipo = modelo.contarPorTipo(tipo);
        vista.mostrarMensaje("Pedidos de tipo '" + tipo + "': " + porTipo);
    }
}
