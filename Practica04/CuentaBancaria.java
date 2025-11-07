package Practica04;

// Clase que representa una cuenta bancaria básica
public class CuentaBancaria {
    private String numeroCuenta;
    private String titular;
    private double saldo;

    // Constructor con validación del saldo inicial
    public CuentaBancaria(String numeroCuenta, String titular, double saldoInicial) {
        // Validar que el saldo inicial no sea negativo
        if (saldoInicial < 0) {
            throw new IllegalArgumentException("El saldo inicial no puede ser negativo.");
        }
        // Asignar valores a los atributos
        this.numeroCuenta = numeroCuenta;
        this.titular = titular;
        this.saldo = saldoInicial;
    }

    // Método para depositar dinero en la cuenta
    public void depositar(double monto) {
        // Validar que el monto sea positivo
        if (monto <= 0) {
            throw new IllegalArgumentException("El monto a depositar debe ser mayor que cero.");
        }
        // Sumar el monto al saldo actual
        saldo += monto;
        System.out.println("Depósito exitoso. Nuevo saldo: S/ " + saldo);
    }

    // Método para retirar dinero de la cuenta
    public void retirar(double monto) throws SaldoInsuficienteException {
        // Validar que el monto sea positivo
        if (monto <= 0) {
            throw new IllegalArgumentException("El monto a retirar debe ser mayor que cero.");
        }
        // Si el monto excede el saldo, lanzar excepción personalizada
        if (monto > saldo) {
            throw new SaldoInsuficienteException("Saldo insuficiente. No se puede retirar S/ " + monto);
        }
        // Restar el monto del saldo actual
        saldo -= monto;
        System.out.println("Retiro exitoso. Saldo restante: S/ " + saldo);
    }

    // Obtener el saldo actual
    public double getSaldo() {
        return saldo;
    }

    // Obtener el nombre del titular
    public String getTitular() {
        return titular;
    }

    // Obtener el número de cuenta
    public String getNumeroCuenta() {
        return numeroCuenta;
    }
}
