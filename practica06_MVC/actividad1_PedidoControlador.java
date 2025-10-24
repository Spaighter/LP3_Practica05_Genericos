package practica06_MVC;


import java.util.List;

/*
 * Controlador del patrón MVC.
 * Coordina la comunicación entre Modelo y Vista.
 */
public class actividad1_PedidoControlador {
    private actividad1_PedidoModelo modelo;
    private actividad1_PedidoVista vista;

    public actividad1_PedidoControlador(actividad1_PedidoModelo modelo, actividad1_PedidoVista vista) {
        this.modelo = modelo;
        this.vista = vista;
    }

    // Agrega un pedido al modelo
    public void agregarPedido(String nombrePlato) {
        if (!nombrePlato.isEmpty()) {
            modelo.agregarPedido(new actividad1_Pedido(nombrePlato));
            vista.mostrarMensaje("Pedido agregado: " + nombrePlato);
        } else {
            vista.mostrarMensaje("El nombre del plato no puede estar vacío.");
        }
    }

    // Muestra todos los pedidos
    public void mostrarPedidos() {
        List<actividad1_Pedido> pedidos = modelo.getPedidos();
        vista.mostrarPedidos(pedidos);
    }

    // Bucle principal del programa
    public void iniciar() {
        String opcion;
        do {
            vista.mostrarMenu();
            opcion = vista.solicitarOpcion();
            switch (opcion) {
                case "1":
                    String nombrePlato = vista.solicitarNombrePlato();
                    agregarPedido(nombrePlato);
                    break;
                case "2":
                    mostrarPedidos();
                    break;
                case "3":
                    vista.mostrarMensaje("Saliendo...");
                    break;
                default:
                    vista.mostrarMensaje("Opción no válida. Inténtalo de nuevo.");
            }
        } while (!opcion.equals("3"));
        vista.cerrarScanner();
    }
}
