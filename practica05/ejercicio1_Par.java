package practica05;

/*
 * Clase genérica ejercicio1_Par<F, S>
 * Representa un par de elementos con tipo genérico.
 * Permite obtener, modificar y comparar dos valores de tipos distintos.
 */
public class ejercicio1_Par<F, S> {
    private F primero;
    private S segundo;

    // Constructor que inicializa los dos valores del par
    public ejercicio1_Par(F primero, S segundo) {
        this.primero = primero;
        this.segundo = segundo;
    }

    // Retorna el primer valor del par
    public F getPrimero() {
        return primero;
    }

    // Retorna el segundo valor del par
    public S getSegundo() {
        return segundo;
    }

    // Permite cambiar el primer valor
    public void setPrimero(F primero) {
        this.primero = primero;
    }

    // Permite cambiar el segundo valor
    public void setSegundo(S segundo) {
        this.segundo = segundo;
    }

    // Compara dos pares verificando si ambos valores son iguales
    public boolean esIgual(ejercicio1_Par<F, S> otroPar) {
        return this.primero.equals(otroPar.primero) && this.segundo.equals(otroPar.segundo);
    }

    // Devuelve el par en formato de texto legible
    @Override
    public String toString() {
        return "• " + primero + ": " + segundo;
    }
}
