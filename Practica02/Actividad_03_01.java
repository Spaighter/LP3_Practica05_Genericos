package Practica02;

/*
 * Clase Motor: representa el motor que se asocia a un automóvil (agregación).
 */
public class Actividad_03_01 {
    private String tipo;
    private int potencia;

    public Actividad_03_01(String tipo, int potencia) {
        this.tipo = tipo;
        this.potencia = potencia;
    }

    @Override
    public String toString() {
        return "Motor tipo: " + tipo + " | Potencia: " + potencia + " HP";
    }
}
