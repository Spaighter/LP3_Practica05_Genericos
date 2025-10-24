package practica07_ManejoArchivosJava;

import java.io.*;
import java.util.*;

/*
 * En esta clase gestiono toda la lógica:
 * - Agregar, eliminar, modificar y mostrar personajes
 * - Guardar automáticamente los cambios en el archivo
 */
public class ejercicio1_Gestor {
    private final String rutaArchivo = "D:\\eclipse-workspace\\Practicas_LP\\personajes.txt";
    private List<ejercicio1_Personaje> personajes = new ArrayList<>();

    public ejercicio1_Gestor() {
        cargarDesdeArchivo();
    }

    // Cargar personajes existentes desde el archivo
    private void cargarDesdeArchivo() {
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                ejercicio1_Personaje p = ejercicio1_Personaje.fromString(linea);
                if (p != null) personajes.add(p);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado. Se creará uno nuevo al guardar.");
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    // Guardar todos los personajes en el archivo
    private void guardarEnArchivo() {
        try (PrintWriter pw = new PrintWriter(new FileWriter(rutaArchivo))) {
            for (ejercicio1_Personaje p : personajes) {
                pw.println(p);
            }
        } catch (IOException e) {
            System.out.println("Error al guardar en archivo: " + e.getMessage());
        }
    }

    // Añadir un nuevo personaje
    public void agregarPersonaje(ejercicio1_Personaje nuevo) {
        for (ejercicio1_Personaje p : personajes) {
            if (p.getNombre().equalsIgnoreCase(nuevo.getNombre())) {
                System.out.println("El personaje ya existe, no se agregará.");
                return;
            }
        }
        personajes.add(nuevo);
        guardarEnArchivo();
        System.out.println("Personaje agregado correctamente.");
    }

    // Mostrar todos los personajes
    public void mostrarPersonajes() {
        if (personajes.isEmpty()) {
            System.out.println("No hay personajes registrados.");
        } else {
            System.out.println("\n=== LISTA DE PERSONAJES ===");
            for (ejercicio1_Personaje p : personajes) {
                System.out.println(p.getNombre() + " - Vida: " + p.getVida() + ", Ataque: " + p.getAtaque() +
                                   ", Defensa: " + p.getDefensa() + ", Alcance: " + p.getAlcance());
            }
        }
    }

    // Modificar un personaje existente
    public void modificarPersonaje(String nombre, int vida, int ataque, int defensa, int alcance) {
        for (ejercicio1_Personaje p : personajes) {
            if (p.getNombre().equalsIgnoreCase(nombre)) {
                p.setVida(vida);
                p.setAtaque(ataque);
                p.setDefensa(defensa);
                p.setAlcance(alcance);
                guardarEnArchivo();
                System.out.println("Personaje modificado correctamente.");
                return;
            }
        }
        System.out.println("No se encontró el personaje especificado.");
    }

    // Eliminar personaje por nombre
    public void eliminarPersonaje(String nombre) {
        Iterator<ejercicio1_Personaje> it = personajes.iterator();
        while (it.hasNext()) {
            if (it.next().getNombre().equalsIgnoreCase(nombre)) {
                it.remove();
                guardarEnArchivo();
                System.out.println("Personaje eliminado correctamente.");
                return;
            }
        }
        System.out.println("No se encontró el personaje para eliminar.");
    }
}
