package Practica02;

/*
 * Clase base Cuenta: define comportamiento común de las cuentas bancarias.
 */
public class Actividad_05_01 {
    protected String numeroCuenta;
    protected double saldo;

    public Actividad_05_01(String numeroCuenta, double saldoInicial) {
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldoInicial;
    }

    public void depositar(double monto) {
        saldo += monto;
        System.out.println("Se ha depositado S/ " + monto);
    }

    public void retirar(double monto) {
        if (monto <= saldo) saldo -= monto;
        else System.out.println("Saldo insuficiente.");
    }

    public void consultar() {
        System.out.println("Saldo actual: S/ " + saldo);
    }
}
