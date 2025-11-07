package Practica02;

/*
 * Clase Persona: compone una Cuenta.
 * Si la persona deja de existir, su cuenta también.
 */
public class Actividad_04_02 {
    private String nombre;
    private String dni;
    private Actividad_04_01 cuenta;

    public Actividad_04_02(String nombre, String dni, String numeroCuenta, double saldoInicial) {
        this.nombre = nombre;
        this.dni = dni;
        this.cuenta = new Actividad_04_01(numeroCuenta, saldoInicial);
    }

    public void mostrarInformacion() {
        System.out.println("Persona: " + nombre + " | DNI: " + dni);
        cuenta.mostrarCuenta();
    }
}
