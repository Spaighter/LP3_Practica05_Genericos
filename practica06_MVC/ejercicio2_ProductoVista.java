package practica06_MVC;

import java.util.List;
import java.util.Scanner;

/*
 * En esta clase manejo todo lo que el usuario ve y escribe.
 * Aquí muestro los menús, pido datos por teclado y muestro los resultados.
 * No realizo cálculos ni guardo nada, solo me encargo de la interacción.
 */
public class ejercicio2_ProductoVista {
    private Scanner scanner;

    // Cuando creo la vista, inicio el Scanner para leer desde consola
    public ejercicio2_ProductoVista() {
        scanner = new Scanner(System.in);
    }

    // Muestro el menú principal del sistema
    public void mostrarMenu() {
        System.out.println("\n  MENÚ DE PRODUCTOS  ");
        System.out.println("1. Agregar producto");
        System.out.println("2. Mostrar productos");
        System.out.println("3. Buscar producto");
        System.out.println("4. Actualizar producto");
        System.out.println("5. Eliminar producto");
        System.out.println("6. Calcular valor total del inventario");
        System.out.println("7. Salir");
    }

    // Pido al usuario que elija una opción
    public String solicitarOpcion() {
        System.out.print("Selecciona una opción: ");
        return scanner.nextLine();
    }

    // Pido el nombre del producto
    public String solicitarNombre() {
        System.out.print("Introduce el nombre del producto: ");
        return scanner.nextLine();
    }

    // Pido el precio
    public double solicitarPrecio() {
        System.out.print("Introduce el precio del producto: ");
        return Double.parseDouble(scanner.nextLine());
    }

    // Pido la cantidad
    public int solicitarCantidad() {
        System.out.print("Introduce la cantidad disponible: ");
        return Integer.parseInt(scanner.nextLine());
    }

    // Muestro la lista de productos registrados
    public void mostrarProductos(List<ejercicio2_Producto> productos) {
        if (productos.isEmpty()) {
            System.out.println("No hay productos registrados.");
        } else {
            System.out.println("Lista de productos:");
            for (ejercicio2_Producto p : productos) {
                System.out.println(p);
            }
        }
    }

    // Muestro mensajes al usuario (por ejemplo, confirmaciones o errores)
    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    // Cierro el Scanner al terminar el programa
    public void cerrarScanner() {
        scanner.close();
    }
}

