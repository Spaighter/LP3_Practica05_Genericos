package practica07_ManejoArchivosJava;

import java.io.*;
import java.util.*;

/*
 * En esta clase gestiono todos los personajes y agrego nuevas funciones:
 * filtrar, estadísticas, subir de nivel y carga aleatoria.
 */
public class ejercicio2_Gestor {
    private final String rutaArchivo = "D:\\eclipse-workspace\\Practicas_LP\\personajes2.txt";
    private List<ejercicio2_Personaje> personajes = new ArrayList<>();

    public ejercicio2_Gestor() {
        cargarDesdeArchivo();
        if (personajes.isEmpty()) cargarPersonajesAleatorios();
    }

    // === CARGA Y GUARDADO ===
    private void cargarDesdeArchivo() {
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                ejercicio2_Personaje p = ejercicio2_Personaje.fromString(linea);
                if (p != null) personajes.add(p);
            }
        } catch (IOException e) {
            System.out.println("Archivo no encontrado, se creará al guardar.");
        }
    }

    private void guardarEnArchivo() {
        try (PrintWriter pw = new PrintWriter(new FileWriter(rutaArchivo))) {
            for (ejercicio2_Personaje p : personajes)
                pw.println(p);
        } catch (IOException e) {
            System.out.println("Error al guardar: " + e.getMessage());
        }
    }

    // === FUNCIONES PRINCIPALES ===
    public void agregarPersonaje(ejercicio2_Personaje nuevo) {
        for (ejercicio2_Personaje p : personajes)
            if (p.getNombre().equalsIgnoreCase(nuevo.getNombre())) {
                System.out.println("El personaje ya existe.");
                return;
            }
        personajes.add(nuevo);
        guardarEnArchivo();
        System.out.println("Personaje agregado correctamente.");
    }

    public void mostrarPersonajes() {
        if (personajes.isEmpty()) {
            System.out.println("No hay personajes registrados.");
            return;
        }
        System.out.println("\n=== LISTA DE PERSONAJES ===");
        for (ejercicio2_Personaje p : personajes)
            System.out.println(p);
    }

    public void eliminarPersonaje(String nombre) {
        personajes.removeIf(p -> p.getNombre().equalsIgnoreCase(nombre));
        guardarEnArchivo();
        System.out.println("Personaje eliminado si existía.");
    }

    // === NUEVAS FUNCIONES ===
    public void filtrarPor(String atributo) {
        Comparator<ejercicio2_Personaje> comparador = switch (atributo.toLowerCase()) {
            case "vida" -> Comparator.comparingInt(ejercicio2_Personaje::getVida).reversed();
            case "ataque" -> Comparator.comparingInt(ejercicio2_Personaje::getAtaque).reversed();
            case "defensa" -> Comparator.comparingInt(ejercicio2_Personaje::getDefensa).reversed();
            case "alcance" -> Comparator.comparingInt(ejercicio2_Personaje::getAlcance).reversed();
            default -> null;
        };

        if (comparador != null) {
            personajes.stream().sorted(comparador).forEach(System.out::println);
        } else {
            System.out.println("Atributo inválido.");
        }
    }

    public void mostrarEstadisticas() {
        if (personajes.isEmpty()) return;

        double promedioVida = personajes.stream().mapToInt(ejercicio2_Personaje::getVida).average().orElse(0);
        double promedioAtaque = personajes.stream().mapToInt(ejercicio2_Personaje::getAtaque).average().orElse(0);
        double promedioDefensa = personajes.stream().mapToInt(ejercicio2_Personaje::getDefensa).average().orElse(0);
        double promedioAlcance = personajes.stream().mapToInt(ejercicio2_Personaje::getAlcance).average().orElse(0);

        System.out.println("\n=== ESTADÍSTICAS ===");
        System.out.println("Total de personajes: " + personajes.size());
        System.out.printf("Promedio Vida: %.2f | Ataque: %.2f | Defensa: %.2f | Alcance: %.2f\n",
                promedioVida, promedioAtaque, promedioDefensa, promedioAlcance);
    }

    public void subirNivel(String nombre) {
        for (ejercicio2_Personaje p : personajes)
            if (p.getNombre().equalsIgnoreCase(nombre)) {
                p.subirNivel();
                guardarEnArchivo();
                System.out.println(p.getNombre() + " ha subido al nivel " + p.getNivel());
                return;
            }
        System.out.println("Personaje no encontrado.");
    }

    public void cargarPersonajesAleatorios() {
        personajes.add(new ejercicio2_Personaje("Caballero", 4, 2, 4, 2, 1));
        personajes.add(new ejercicio2_Personaje("Guerrero", 2, 4, 2, 4, 1));
        personajes.add(new ejercicio2_Personaje("Arquero", 2, 4, 1, 8, 1));
        guardarEnArchivo();
        System.out.println("Personajes iniciales cargados automáticamente.");
    }
}
