package practica07_ManejoArchivosJava;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/*
 * En esta clase manejo toda la lógica para leer los contactos desde un archivo.
 * Luego permito al usuario buscar un contacto por su nombre.
 */
public class actividad5_Agenda {
    private actividad5_ArrayPersona lista;
    private FileInputStream archivoAgenda;
    private final int longLinea = 32; // Longitud máxima de línea a leer

    // Constructor: al crear la agenda, cargo los contactos del archivo
    public actividad5_Agenda() {
        this.lista = cargarContactos();
    }

    // Método que mantiene el ciclo de búsqueda interactiva
    public void bucle() {
        String nombre;
        System.out.println("Introduce un nombre o <Enter> para salir:");
        try {
            while ((nombre = leerEntrada(System.in)) != null && !nombre.equals("")) {
                lista.printPersona(nombre);
                System.out.println("\nIntroduce otro nombre o <Enter> para salir:");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Leo una línea de texto del flujo de entrada
    private String leerEntrada(java.io.InputStream entrada) throws IOException {
        byte[] chars = new byte[longLinea];
        int contador = 0;
        while (contador < longLinea && (chars[contador++] = (byte) entrada.read()) != '\n' && chars[contador - 1] != -1)
            ;
        return new String(chars, 0, contador - 1).trim();
    }

    // Cargo una persona del archivo agenda.txt
    private actividad5_Persona cargarPersona() throws IOException {
        String nombre = leerEntrada(archivoAgenda);
        if (nombre == null || nombre.isEmpty()) return null;

        String telefono = leerEntrada(archivoAgenda);
        String direccion = leerEntrada(archivoAgenda);
        return new actividad5_Persona(nombre, telefono, direccion);
    }

    // Cargo todos los contactos y los guardo en un arreglo
    private actividad5_ArrayPersona cargarContactos() {
        actividad5_ArrayPersona directorio = new actividad5_ArrayPersona();
        actividad5_Persona persona;

        try {
            // Aquí cambio la ruta para que lea directamente desde el proyecto
            archivoAgenda = new FileInputStream("D:\\eclipse-workspace\\Practicas_LP\\agenda.txt");

            // Leo las personas una a una hasta que se termine el archivo
            while ((persona = cargarPersona()) != null) {
                directorio.addPersona(persona);
            }
        } catch (FileNotFoundException e) {
            System.out.println("No se encontró el archivo de agenda en la ruta especificada.");
            System.exit(1);
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }

        return directorio;
    }
}
