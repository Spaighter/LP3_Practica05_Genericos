package Practica02;

/*
 * Subclase CuentaCorriente: permite sobregiro hasta un límite.
 */
public class Actividad_05_03 extends Actividad_05_01 {
    private double limite = 500;

    public Actividad_05_03(String numeroCuenta, double saldoInicial) {
        super(numeroCuenta, saldoInicial);
    }

    @Override
    public void retirar(double monto) {
        if (monto <= saldo + limite) saldo -= monto;
        else System.out.println("Excede el límite de sobregiro.");
    }
}
