package Practica02;

/*
 * Subclase CuentaAhorro: aplica restricciones de retiro.
 */
public class Actividad_05_02 extends Actividad_05_01 {
    public Actividad_05_02(String numeroCuenta, double saldoInicial) {
        super(numeroCuenta, saldoInicial);
    }

    @Override
    public void retirar(double monto) {
        if (monto <= saldo * 0.8) saldo -= monto;
        else System.out.println("Solo puede retirar hasta el 80% del saldo.");
    }
}
