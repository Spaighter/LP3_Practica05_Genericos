package practica07_ManejoArchivosJava;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/*
 * En este programa creo varios objetos Alumno (que incluyen una Fecha),
 * y los guardo en un archivo binario usando serialización.
 */
public class actividad6_Serial5 {

    public static void main(String[] args) {
        FileOutputStream fos = null;
        ObjectOutputStream salida = null;

        try {
            // Creo el flujo para guardar los objetos en un archivo
            fos = new FileOutputStream("D:\\\\eclipse-workspace\\\\Practicas_LP\\\\alumnos.dat");
            salida = new ObjectOutputStream(fos);

            // Creo algunos objetos Alumno con su Fecha
            actividad6_Alumno a1 = new actividad6_Alumno("24567069", "Mario Gonzales", 20, new actividad6_Fecha(5, 9, 2021));
            actividad6_Alumno a2 = new actividad6_Alumno("25067890", "Lucas Alario", 19, new actividad6_Fecha(7, 9, 2021));
            actividad6_Alumno a3 = new actividad6_Alumno("21045636", "Lucia Apaza", 21, new actividad6_Fecha(8, 9, 2021));

            // Escribo los objetos en el archivo binario
            salida.writeObject(a1);
            salida.writeObject(a2);
            salida.writeObject(a3);

            System.out.println("Objetos Alumno guardados correctamente en el archivo.");

        } catch (FileNotFoundException e) {
            System.out.println("No se encontró el archivo: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error al escribir los objetos: " + e.getMessage());
        } finally {
            // Cierro los flujos de salida
            try {
                if (salida != null) salida.close();
                if (fos != null) fos.close();
            } catch (IOException e) {
                System.out.println("Error al cerrar el archivo: " + e.getMessage());
            }
        }
    }
}
