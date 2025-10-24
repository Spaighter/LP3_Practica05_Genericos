package practica06_MVC;

import java.util.List;
import java.util.Scanner;

/*
 * Vista del patrón MVC.
 * Se encarga de la interacción con el usuario.
 */
public class actividad1_PedidoVista {
    private Scanner scanner;

    public actividad1_PedidoVista() {
        scanner = new Scanner(System.in);
    }

    // Solicita el nombre del plato
    public String solicitarNombrePlato() {
        System.out.print("Introduce el nombre del plato: ");
        return scanner.nextLine();
    }

    // Muestra todos los pedidos
    public void mostrarPedidos(List<actividad1_Pedido> pedidos) {
        if (pedidos.isEmpty()) {
            System.out.println("No hay pedidos en la lista.");
        } else {
            System.out.println("Lista de Pedidos:");
            for (actividad1_Pedido pedido : pedidos) {
                System.out.println("- " + pedido.getNombrePlato());
            }
        }
    }

    // Muestra el menú de opciones
    public void mostrarMenu() {
        System.out.println("\nOpciones:");
        System.out.println("1. Agregar Pedido");
        System.out.println("2. Mostrar Pedidos");
        System.out.println("3. Salir");
    }

    // Solicita una opción del menú
    public String solicitarOpcion() {
        System.out.print("Selecciona una opción: ");
        return scanner.nextLine();
    }

    // Muestra mensajes generales
    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    // Cierra el scanner
    public void cerrarScanner() {
        scanner.close();
    }
}
