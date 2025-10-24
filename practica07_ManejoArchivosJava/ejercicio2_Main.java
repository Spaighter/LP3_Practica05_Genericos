package practica07_ManejoArchivosJava;

import java.util.Scanner;

public class ejercicio2_Main {
    public static void main(String[] args) {
        ejercicio2_Gestor gestor = new ejercicio2_Gestor();
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n  MENÚ MEJORADO DE PERSONAJES  ");
            System.out.println("1. Mostrar personajes");
            System.out.println("2. Agregar personaje");
            System.out.println("3. Eliminar personaje");
            System.out.println("4. Filtrar por atributo");
            System.out.println("5. Subir nivel de personaje");
            System.out.println("6. Mostrar estadísticas");
            System.out.println("7. Salir");
            System.out.print("Selecciona una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1 -> gestor.mostrarPersonajes();
                case 2 -> {
                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();
                    System.out.print("Vida: "); int vida = sc.nextInt();
                    System.out.print("Ataque: "); int ataque = sc.nextInt();
                    System.out.print("Defensa: "); int defensa = sc.nextInt();
                    System.out.print("Alcance: "); int alcance = sc.nextInt();
                    gestor.agregarPersonaje(new ejercicio2_Personaje(nombre, vida, ataque, defensa, alcance, 1));
                }
                case 3 -> {
                    System.out.print("Nombre a eliminar: ");
                    String nombre = sc.nextLine();
                    gestor.eliminarPersonaje(nombre);
                }
                case 4 -> {
                    System.out.print("Atributo a filtrar (vida, ataque, defensa, alcance): ");
                    String atributo = sc.nextLine();
                    gestor.filtrarPor(atributo);
                }
                case 5 -> {
                    System.out.print("Nombre del personaje que sube de nivel: ");
                    String nombre = sc.nextLine();
                    gestor.subirNivel(nombre);
                }
                case 6 -> gestor.mostrarEstadisticas();
                case 7 -> System.out.println("Saliendo del gestor mejorado...");
                default -> System.out.println("Opción inválida.");
            }

        } while (opcion != 7);

        sc.close();
    }
}
