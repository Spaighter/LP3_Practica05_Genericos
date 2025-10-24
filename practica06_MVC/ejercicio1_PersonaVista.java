package practica06_MVC;

import java.util.List;
import java.util.Scanner;

/*
 * En esta clase manejo todo lo que el usuario ve.
 * Aquí muestro menús, pido datos por teclado y presento resultados.
 * No hago cálculos ni guardo datos, solo interactúo con el usuario.
 */
public class ejercicio1_PersonaVista {
    private Scanner scanner;

    // Al crear la vista, inicio el Scanner para leer por consola
    public ejercicio1_PersonaVista() {
        scanner = new Scanner(System.in);
    }

    // Muestro el menú de opciones principales
    public void mostrarMenu() {
        System.out.println("\n  MENÚ DE PERSONAS  ");
        System.out.println("1. Agregar persona");
        System.out.println("2. Mostrar personas");
        System.out.println("3. Buscar persona");
        System.out.println("4. Actualizar edad");
        System.out.println("5. Eliminar persona");
        System.out.println("6. Salir");
    }

    // Pido la opción que el usuario desea ejecutar
    public String solicitarOpcion() {
        System.out.print("Selecciona una opción: ");
        return scanner.nextLine();
    }

    // Pido el nombre de la persona
    public String solicitarNombre() {
        System.out.print("Introduce el nombre: ");
        return scanner.nextLine();
    }

    // Pido la edad de la persona y convierto el texto a número
    public int solicitarEdad() {
        System.out.print("Introduce la edad: ");
        return Integer.parseInt(scanner.nextLine());
    }

    // Muestro todas las personas registradas
    public void mostrarPersonas(List<ejercicio1_Persona> personas) {
        if (personas.isEmpty()) {
            System.out.println("No hay personas registradas.");
        } else {
            System.out.println("Listado de personas:");
            for (ejercicio1_Persona p : personas) {
                System.out.println(p);
            }
        }
    }

    // Muestro mensajes informativos o de error
    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    // Cierro el Scanner cuando termina el programa
    public void cerrarScanner() {
        scanner.close();
    }
}
