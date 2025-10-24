package practica07_ManejoArchivosJava;

import java.util.Scanner;

/*
 * En esta clase ejecuto el programa principal.
 * Desde aquí interactúo con el Gestor y el usuario.
 */
public class ejercicio1_Main {

    public static void main(String[] args) {
        ejercicio1_Gestor gestor = new ejercicio1_Gestor();
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n  MENÚ GESTOR DE PERSONAJES  ");
            System.out.println("1. Mostrar personajes");
            System.out.println("2. Agregar personaje");
            System.out.println("3. Modificar personaje");
            System.out.println("4. Eliminar personaje");
            System.out.println("5. Salir");
            System.out.print("Selecciona una opción: ");
            opcion = sc.nextInt();
            sc.nextLine(); // limpiar buffer

            switch (opcion) {
                case 1 -> gestor.mostrarPersonajes();
                case 2 -> {
                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();
                    System.out.print("Vida: ");
                    int vida = sc.nextInt();
                    System.out.print("Ataque: ");
                    int ataque = sc.nextInt();
                    System.out.print("Defensa: ");
                    int defensa = sc.nextInt();
                    System.out.print("Alcance: ");
                    int alcance = sc.nextInt();
                    gestor.agregarPersonaje(new ejercicio1_Personaje(nombre, vida, ataque, defensa, alcance));
                }
                case 3 -> {
                    System.out.print("Nombre del personaje a modificar: ");
                    String nombre = sc.nextLine();
                    System.out.print("Nueva vida: ");
                    int vida = sc.nextInt();
                    System.out.print("Nuevo ataque: ");
                    int ataque = sc.nextInt();
                    System.out.print("Nueva defensa: ");
                    int defensa = sc.nextInt();
                    System.out.print("Nuevo alcance: ");
                    int alcance = sc.nextInt();
                    gestor.modificarPersonaje(nombre, vida, ataque, defensa, alcance);
                }
                case 4 -> {
                    System.out.print("Nombre del personaje a eliminar: ");
                    String nombre = sc.nextLine();
                    gestor.eliminarPersonaje(nombre);
                }
                case 5 -> System.out.println("Saliendo del gestor...");
                default -> System.out.println("Opción no válida, intenta de nuevo.");
            }
        } while (opcion != 5);

        sc.close();
    }
}
