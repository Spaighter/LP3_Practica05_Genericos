package Practica02;

/*
 * Clase Contador — demuestra uso de variables estáticas, this y constructores.
 */
public class Actividad_02 {
    private int valor;
    private static int contadorGlobal = 0;
    public static final int VALOR_INICIAL = 0;

    public Actividad_02() {
        valor = VALOR_INICIAL;
        contadorGlobal++;
    }

    public Actividad_02(int valor) {
        this.valor = valor;
        contadorGlobal++;
    }

    public void incrementar() { valor++; }
    public void decrementar() { valor--; }
    public int getValor() { return valor; }
    public static int getContadorGlobal() { return contadorGlobal; }
}
