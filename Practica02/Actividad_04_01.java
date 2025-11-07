package Practica02;

/*
 * Clase Cuenta: parte interna de Persona, usada en relación de composición.
 */
public class Actividad_04_01 {
    private String numeroCuenta;
    private double saldo;

    public Actividad_04_01(String numeroCuenta, double saldo) {
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldo;
    }

    public void depositar(double monto) { saldo += monto; }

    public void retirar(double monto) {
        if (monto <= saldo) saldo -= monto;
        else System.out.println("Fondos insuficientes.");
    }

    public void mostrarCuenta() {
        System.out.println("Cuenta N°: " + numeroCuenta + " | Saldo: S/ " + saldo);
    }
}
