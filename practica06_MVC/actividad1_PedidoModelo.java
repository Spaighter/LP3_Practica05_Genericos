package practica06_MVC;


import java.util.ArrayList;
import java.util.List;

/*
 * Modelo del patrón MVC.
 * Contiene la lógica y datos de los pedidos.
 */
public class actividad1_PedidoModelo {
    private List<actividad1_Pedido> pedidos;

    public actividad1_PedidoModelo() {
        pedidos = new ArrayList<>();
    }

    // Agrega un pedido a la lista
    public void agregarPedido(actividad1_Pedido pedido) {
        pedidos.add(pedido);
    }

    // Devuelve la lista completa de pedidos
    public List<actividad1_Pedido> getPedidos() {
        return pedidos;
    }
}
