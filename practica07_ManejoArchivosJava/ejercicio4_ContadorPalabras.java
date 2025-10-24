package practica07_ManejoArchivosJava;

import javax.swing.*;
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

/*
 * En este programa abro un archivo de texto usando JFileChooser.
 * Luego cuento líneas, palabras, caracteres y muestro estadísticas.
 */
public class ejercicio4_ContadorPalabras {

    public static void main(String[] args) {
        new ejercicio4_ContadorPalabras().iniciar();
    }

    // Método principal del programa
    public void iniciar() {
        // Abro una ventana para que el usuario elija un archivo
        JFileChooser selector = new JFileChooser();
        selector.setDialogTitle("Selecciona un archivo de texto (.txt)");

        int resultado = selector.showOpenDialog(null);
        if (resultado != JFileChooser.APPROVE_OPTION) {
            System.out.println("No se seleccionó ningún archivo. Terminando programa.");
            return;
        }

        File archivo = selector.getSelectedFile();
        if (!archivo.exists() || !archivo.isFile()) {
            System.out.println("Archivo inválido o no encontrado.");
            return;
        }

        // Ahora analizo el archivo seleccionado
        analizarArchivo(archivo);
    }

    // Método que analiza el archivo y muestra las estadísticas
    private void analizarArchivo(File archivo) {
        int lineas = 0;
        int caracteres = 0;
        int palabrasTotales = 0;
        Map<String, Integer> frecuencia = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                lineas++;
                caracteres += linea.length();

                // Divido las palabras usando un delimitador
                String[] palabras = linea.split("\\s+");
                for (String palabra : palabras) {
                    if (!palabra.isEmpty() && palabra.chars().anyMatch(Character::isLetterOrDigit)) {
                        palabrasTotales++;
                        palabra = palabra.toLowerCase().replaceAll("[^a-z0-9áéíóúüñ]", "");
                        frecuencia.put(palabra, frecuencia.getOrDefault(palabra, 0) + 1);
                    }
                }
            }

            double promedio = (lineas > 0) ? (double) palabrasTotales / lineas : 0.0;

            // Muestro resultados
            System.out.println("\n   RESULTADOS DEL ANÁLISIS   ");
            System.out.println("Archivo: " + archivo.getName());
            System.out.println("Total de líneas: " + lineas);
            System.out.println("Total de palabras: " + palabrasTotales);
            System.out.println("Total de caracteres: " + caracteres);
            System.out.printf("Promedio de palabras por línea: %.2f\n", promedio);

            // Ordeno las palabras más frecuentes
            System.out.println("\n=== PALABRAS MÁS FRECUENTES ===");
            frecuencia.entrySet().stream()
                    .sorted(Map.Entry.<String, Integer>comparingByValue(Comparator.reverseOrder()))
                    .limit(10)
                    .forEach(e -> System.out.println(e.getKey() + " → " + e.getValue() + " veces"));

        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}
