package practica06_MVC;

import java.util.List;
import java.util.Scanner;

/*
 * Vista del patrón MVC.
 * Maneja interacción con el usuario.
 */
public class actividad3_PedidoVista {
    private Scanner scanner;

    public actividad3_PedidoVista() {
        scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        System.out.println("\n  MENÚ DE PEDIDOS  ");
        System.out.println("1. Agregar pedido");
        System.out.println("2. Mostrar todos los pedidos");
        System.out.println("3. Marcar pedido como completo");
        System.out.println("4. Mostrar pedidos pendientes");
        System.out.println("5. Mostrar pedidos completados");
        System.out.println("6. Eliminar pedido");
        System.out.println("7. Mostrar historial de pedidos");
        System.out.println("8. Contar pedidos pendientes");
        System.out.println("9. Salir");
    }

    public String solicitarOpcion() {
        System.out.print("Selecciona una opción: ");
        return scanner.nextLine();
    }

    public String solicitarNombrePlato() {
        System.out.print("Introduce el nombre del plato: ");
        return scanner.nextLine();
    }

    public String solicitarTipoPlato() {
        System.out.print("Introduce el tipo de plato: ");
        return scanner.nextLine();
    }

    public void mostrarPedidos(List<actividad3_Pedido> pedidos) {
        if (pedidos.isEmpty()) {
            System.out.println("No hay pedidos para mostrar.");
        } else {
            for (actividad3_Pedido p : pedidos) {
                System.out.println(p);
            }
        }
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public void cerrarScanner() {
        scanner.close();
    }
}
