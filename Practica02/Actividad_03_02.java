package Practica02;

/*
 * Clase Automóvil: demuestra relación de agregación con la clase Motor.
 */
public class Actividad_03_02 {
    private String modelo;
    private Actividad_03_01 motor; // Agregación

    public Actividad_03_02(String modelo, Actividad_03_01 motor) {
        this.modelo = modelo;
        this.motor = motor;
    }

    public void mostrarInfo() {
        System.out.println("Automóvil: " + modelo);
        System.out.println(motor.toString());
    }
}
