package practica06_MVC;

import java.util.List;
import java.util.Scanner;

/*
 * Vista del patrón MVC.
 * Se encarga de las interacciones con el usuario.
 */
public class actividad2_PedidoVista {
    private Scanner scanner;

    public actividad2_PedidoVista() {
        scanner = new Scanner(System.in);
    }

    // Menú principal
    public void mostrarMenu() {
        System.out.println("\n  MENÚ DE PEDIDOS  ");
        System.out.println("1. Agregar pedido");
        System.out.println("2. Eliminar pedido");
        System.out.println("3. Actualizar pedido");
        System.out.println("4. Buscar pedido");
        System.out.println("5. Mostrar todos los pedidos");
        System.out.println("6. Contar pedidos");
        System.out.println("7. Salir");
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

    public void mostrarPedidos(List<actividad2_Pedido> pedidos) {
        if (pedidos.isEmpty()) {
            System.out.println("No hay pedidos en la lista.");
        } else {
            System.out.println("Lista de pedidos:");
            for (actividad2_Pedido p : pedidos) {
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
