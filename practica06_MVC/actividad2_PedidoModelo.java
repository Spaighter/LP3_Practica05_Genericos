package practica06_MVC;

import java.util.ArrayList;
import java.util.List;

/*
 * Modelo del patrón MVC.
 * Contiene la lista de pedidos y operaciones sobre ellos.
 */
public class actividad2_PedidoModelo {
    private List<actividad2_Pedido> pedidos;

    public actividad2_PedidoModelo() {
        pedidos = new ArrayList<>();
    }

    // Agregar un pedido nuevo
    public void agregarPedido(actividad2_Pedido pedido) {
        pedidos.add(pedido);
    }

    // Obtener todos los pedidos
    public List<actividad2_Pedido> getPedidos() {
        return pedidos;
    }

    // Eliminar un pedido por nombre
    public boolean eliminarPedido(String nombre) {
        return pedidos.removeIf(p -> p.getNombrePlato().equalsIgnoreCase(nombre));
    }

    // Actualizar nombre o tipo de un pedido existente
    public boolean actualizarPedido(String nombreActual, String nuevoNombre, String nuevoTipo) {
        for (actividad2_Pedido p : pedidos) {
            if (p.getNombrePlato().equalsIgnoreCase(nombreActual)) {
                p.setNombrePlato(nuevoNombre);
                p.setTipoPlato(nuevoTipo);
                return true;
            }
        }
        return false;
    }

    // Buscar un pedido por nombre o tipo
    public List<actividad2_Pedido> buscarPedido(String criterio) {
        List<actividad2_Pedido> resultado = new ArrayList<>();
        for (actividad2_Pedido p : pedidos) {
            if (p.getNombrePlato().equalsIgnoreCase(criterio) ||
                p.getTipoPlato().equalsIgnoreCase(criterio)) {
                resultado.add(p);
            }
        }
        return resultado;
    }

    // Contar total de pedidos
    public int contarPedidos() {
        return pedidos.size();
    }

    // Contar por tipo de plato
    public int contarPorTipo(String tipo) {
        int contador = 0;
        for (actividad2_Pedido p : pedidos) {
            if (p.getTipoPlato().equalsIgnoreCase(tipo)) {
                contador++;
            }
        }
        return contador;
    }
}
