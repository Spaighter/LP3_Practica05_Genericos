package Practica04;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

// Clase encargada de generar reportes de transacciones en archivos de texto
public class ReporteTransacciones {

    // Método que genera un reporte de la cuenta en un archivo .txt
    public static void generarReporte(CuentaBancaria cuenta) throws IOException {
        // Uso de try-with-resources para asegurar el cierre del archivo
        try (PrintWriter pw = new PrintWriter(new FileWriter("reporte_transacciones.txt"))) {

            // Escribir la información de la cuenta en el archivo
            pw.println("========== REPORTE DE TRANSACCIONES ==========");
            pw.println("Titular: " + cuenta.getTitular());
            pw.println("Número de Cuenta: " + cuenta.getNumeroCuenta());
            pw.println("Saldo actual: S/ " + cuenta.getSaldo());
            pw.println("==============================================");

            // Confirmar generación exitosa
            System.out.println("Reporte generado correctamente en reporte_transacciones.txt");

        } catch (IOException e) {
            // Mostrar mensaje si ocurre un error al escribir el archivo
            System.out.println("Error al generar el reporte: " + e.getMessage());
            // Relanzar la excepción para manejo externo
            throw e;
        }
    }
}
