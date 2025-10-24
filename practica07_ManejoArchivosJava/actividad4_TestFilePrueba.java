package practica07_ManejoArchivosJava;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.JFrame;

/*
 * En este programa abro un archivo de texto y muestro su contenido dentro de una ventana (JFrame).
 * Utilizo un flujo de entrada FileInputStream para leer los bytes del archivo.
 */
public class actividad4_TestFilePrueba {

    public static void main(String[] args) throws IOException {
        FileInputStream file = null;
        byte[] buffer = new byte[1024]; // Aquí guardo los bytes leídos

        try {
            // Intento abrir el archivo de texto
        	file = new FileInputStream("D:\\\\eclipse-workspace\\\\Practicas_LP\\\\src\\\\practica07_ManejoArchivosJava\\\\actividad1_TestFile.java");

            // Leo su contenido y lo convierto en cadena
            file.read(buffer);
            String contenido = new String(buffer);

            // Creo la ventana usando la clase auxiliar ViewFile
            actividad4_ViewFile vista = new actividad4_ViewFile("Mostrando el contenido del archivo");
            vista.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            vista.setSize(400, 200);

            // Muestro el contenido leído en la ventana
            vista.mostrarTexto(contenido);
            vista.setVisible(true);

        } catch (FileNotFoundException e) {
            System.out.println("No se encontró el archivo: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        } finally {
            // Cierro el flujo de entrada
            if (file != null)
                file.close();
        }
    }
}
