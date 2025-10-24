package practica07_ManejoArchivosJava;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

/*
 * En este programa creo una matriz de tipo double y guardo su contenido en un archivo binario.
 * Primero pido al usuario el tamaño de la matriz y los valores,
 * luego los escribo junto con las dimensiones (filas y columnas).
 */
public class actividad3_Binarios2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        FileOutputStream fos = null;
        DataOutputStream salida = null;
        double[][] matriz;
        int filas, columnas;

        // Aquí pido al usuario cuántas filas tendrá la matriz
        do {
            System.out.print("Número de filas: ");
            filas = sc.nextInt();
        } while (filas <= 0);

        // Aquí pido al usuario cuántas columnas tendrá la matriz
        do {
            System.out.print("Número de columnas: ");
            columnas = sc.nextInt();
        } while (columnas <= 0);

        // Creo la matriz con las dimensiones ingresadas
        matriz = new double[filas][columnas];

        // Pido los valores de la matriz uno por uno
        System.out.println("\nIntroduce los valores de la matriz:");
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.printf("matriz[%d][%d]: ", i, j);
                matriz[i][j] = sc.nextDouble();
            }
        }

        // Ahora escribo los datos en un archivo binario dentro del proyecto
        try {
            // Aquí cambio la ruta para que se guarde directamente en el proyecto
            fos = new FileOutputStream("matriz.dat");
            salida = new DataOutputStream(fos);

            // Escribo primero el número de filas y columnas
            salida.writeInt(filas);
            salida.writeInt(columnas);

            // Luego escribo todos los valores de la matriz
            for (int i = 0; i < filas; i++) {
                for (int j = 0; j < columnas; j++) {
                    salida.writeDouble(matriz[i][j]);
                }
            }

            System.out.println("\nArchivo binario 'matriz.dat' creado correctamente en el proyecto.");

        } catch (FileNotFoundException e) {
            // Capturo el error si no se puede crear o abrir el archivo
            System.out.println("No se pudo crear el archivo: " + e.getMessage());
        } catch (IOException e) {
            // Capturo errores de entrada/salida
            System.out.println("Error de E/S: " + e.getMessage());
        } finally {
            // Cierro los flujos de datos al final del proceso
            try {
                if (salida != null) salida.close();
                if (fos != null) fos.close();
            } catch (IOException e) {
                System.out.println("Error al cerrar el archivo: " + e.getMessage());
            }
        }

        sc.close();
    }
}
