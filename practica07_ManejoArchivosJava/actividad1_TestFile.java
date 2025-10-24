package practica07_ManejoArchivosJava;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

/*
 * En este programa pido al usuario que ingrese el nombre de un archivo o directorio.
 * Luego analizo la ruta y muestro toda su información (si existe).
 * Si es un directorio, también muestro su contenido.
 */
public class actividad1_TestFile {

    public static void main(String[] args) throws IOException {
        // Creo el objeto Scanner para leer la entrada del usuario
        Scanner sc = new Scanner(System.in);

        System.out.print("Escriba el nombre del archivo o directorio: ");
        // Leo el nombre ingresado por el usuario y creo un objeto Path
        Path ruta = Paths.get(sc.nextLine());

        // Verifico si la ruta existe
        if (Files.exists(ruta)) {
            // Muestro información básica del archivo o directorio
            System.out.printf("%n%s existe%n", ruta.getFileName());
            System.out.printf("¿Es un directorio?: %s%n", Files.isDirectory(ruta) ? "Sí" : "No");
            System.out.printf("¿Es una ruta absoluta?: %s%n", ruta.isAbsolute() ? "Sí" : "No");
            System.out.printf("Fecha de última modificación: %s%n", Files.getLastModifiedTime(ruta));
            System.out.printf("Tamaño: %s bytes%n", Files.size(ruta));
            System.out.printf("Ruta absoluta: %s%n", ruta.toAbsolutePath());

            // Si es un directorio, muestro el contenido
            if (Files.isDirectory(ruta)) {
                System.out.println("\nContenido del directorio:");
                DirectoryStream<Path> flujoDirectorio = Files.newDirectoryStream(ruta);
                for (Path p : flujoDirectorio)
                    System.out.println(p);
            }

        } else {
            // Si no existe, muestro un mensaje de error
            System.out.printf("%s no existe.%n", ruta);
        }

        sc.close();
    }
}
