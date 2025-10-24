package practica06_MVC;

import java.util.ArrayList;
import java.util.List;

/*
 * Modelo del patrón MVC.
 * Gestiona pedidos activos y el historial.
 */
public class actividad3_PedidoModelo {
    private List<actividad3_Pedido> pedidos;
    private List<actividad3_Pedido> historial;

    public actividad3_PedidoModelo() {
        pedidos = new ArrayList<>();
        historial = new ArrayList<>();
    }

    // Agregar pedido nuevo
    public void agregarPedido(actividad3_Pedido pedido) {
        pedidos.add(pedido);
    }

    // Obtener lista actual de pedidos
    public List<actividad3_Pedido> getPedidos() {
        return pedidos;
    }

    // Marcar pedido como completo
    public boolean marcarComoCompleto(String nombre) {
        for (actividad3_Pedido p : pedidos) {
            if (p.getNombrePlato().equalsIgnoreCase(nombre) && !p.getEstado().equals("Eliminado")) {
                p.setEstado("Completo");
                historial.add(p);
                return true;
            }
        }
        return false;
    }

    // Mostrar pedidos filtrados por estado
    public List<actividad3_Pedido> obtenerPorEstado(String estado) {
        List<actividad3_Pedido> resultado = new ArrayList<>();
        for (actividad3_Pedido p : pedidos) {
            if (p.getEstado().equalsIgnoreCase(estado)) {
                resultado.add(p);
            }
        }
        return resultado;
    }

    // Contar pedidos pendientes
    public int contarPendientes() {
        int contador = 0;
        for (actividad3_Pedido p : pedidos) {
            if (p.getEstado().equalsIgnoreCase("Pendiente")) {
                contador++;
            }
        }
        return contador;
    }

    // Eliminar un pedido (cambia estado a eliminado)
    public boolean eliminarPedido(String nombre) {
        for (actividad3_Pedido p : pedidos) {
            if (p.getNombrePlato().equalsIgnoreCase(nombre)) {
                p.setEstado("Eliminado");
                historial.add(p);
                return true;
            }
        }
        return false;
    }

    // Obtener historial completo
    public List<actividad3_Pedido> getHistorial() {
        return historial;
    }
}
