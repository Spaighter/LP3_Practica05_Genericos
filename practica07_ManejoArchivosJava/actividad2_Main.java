package practica07_ManejoArchivosJava;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/*
 * En este programa escribo texto en un archivo llamado datos.txt.
 * Uso "try-with-resources" para asegurar que el archivo se cierre automáticamente al finalizar.
 */
public class actividad2_Main {

    public static void main(String[] args) {
        // Creo el Scanner para leer texto del teclado
        Scanner sc = new Scanner(System.in);
        String cadena;

        // Intento abrir el archivo para escritura
        try (PrintWriter salida = new PrintWriter("datos.txt")) {
            System.out.println("Introduce texto. Para acabar escribe la palabra FIN:");

            // Leo líneas hasta que el usuario escriba "FIN"
            cadena = sc.nextLine();
            while (!cadena.equalsIgnoreCase("FIN")) {
                salida.println(cadena);
                cadena = sc.nextLine();
            }

        } catch (FileNotFoundException e) {
            // Capturo el error si el archivo no se puede crear o abrir
            System.out.println("Error: " + e.getMessage());
        }

        sc.close();
    }
}
