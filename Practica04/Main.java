package Practica04;

// Clase principal para probar el funcionamiento del sistema de cuentas
public class Main {
    public static void main(String[] args) {

        try {
            // Crear una cuenta bancaria con saldo válido
            CuentaBancaria cuenta1 = new CuentaBancaria("001", "Michael Arroyo", 500.0);

            // Depositar un monto válido
            cuenta1.depositar(300.0);

            // Retirar un monto permitido
            cuenta1.retirar(200.0);

            // Intentar retirar un monto mayor al saldo disponible
            cuenta1.retirar(800.0);

        } catch (SaldoInsuficienteException e) {
            // Capturar excepción personalizada si no hay suficiente saldo
            System.out.println("Error: " + e.getMessage());

        } catch (IllegalArgumentException e) {
            // Capturar errores de validación de argumentos
            System.out.println("Error de argumento: " + e.getMessage());
        }

        try {
            // Crear una cuenta de crédito con límite
            CuentaCredito cuentaCredito = new CuentaCredito("002", "Piero Herrera", 100.0, 400.0);

            // Realizar retiro dentro del límite de crédito
            cuentaCredito.retirar(350.0);

            // Intentar retiro que exceda el límite de crédito
            cuentaCredito.retirar(700.0);

        } catch (LimiteCreditoExcedidoException e) {
            // Capturar excepción cuando el retiro supera el límite permitido
            System.out.println("Error: " + e.getMessage());
        }

        try {
            // Crear una cuenta adicional para generar un reporte
            CuentaBancaria cuenta2 = new CuentaBancaria("003", "Favio Bravo", 1200.0);

            // Generar el reporte de la cuenta
            ReporteTransacciones.generarReporte(cuenta2);

        } catch (IOException e) {
            // Capturar error al generar el archivo
            System.out.println("Error al generar reporte: " + e.getMessage());
        }
    }
}
