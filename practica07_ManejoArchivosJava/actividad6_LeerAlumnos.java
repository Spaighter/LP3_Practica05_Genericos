package practica07_ManejoArchivosJava;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/*
 * En este programa abro el archivo 'alumnos.dat' que contiene objetos Alumno serializados.
 * Leo cada objeto usando ObjectInputStream y muestro su información por pantalla.
 */
public class actividad6_LeerAlumnos {

    public static void main(String[] args) {
        // Intento abrir el archivo binario donde guardé los alumnos
        try (ObjectInputStream entrada = new ObjectInputStream(
                new FileInputStream("D:\\eclipse-workspace\\Practicas_LP\\alumnos.dat"))) {

            System.out.println("=== Lista de alumnos leídos del archivo ===");

            // Leo los objetos hasta que se alcance el final del archivo
            while (true) {
                try {
                    // Leo un objeto y lo convierto a tipo Alumno
                    actividad6_Alumno alumno = (actividad6_Alumno) entrada.readObject();
                    System.out.println(alumno); // Muestro la información del alumno
                } catch (ClassNotFoundException e) {
                    System.out.println("Clase no encontrada: " + e.getMessage());
                } catch (IOException e) {
                    // Cuando llego al final del archivo, salgo del bucle
                    System.out.println("\n--- Fin del archivo ---");
                    break;
                }
            }

        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}
