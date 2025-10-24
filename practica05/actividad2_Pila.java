package practica05;

public class actividad2_Pila<E> {
    private final int tamanio;
    private int superior;
    private E[] elementos;

    // Constructor por defecto
    public actividad2_Pila() {
        this(10);
    }

    // Constructor con tamaño personalizado
    @SuppressWarnings("unchecked")
    public actividad2_Pila(int s) {
        tamanio = s > 0 ? s : 10;
        superior = -1;
        elementos = (E[]) new Object[tamanio];
    }

    // Insertar (push)
    public void push(E valorAMeter) {
        if (superior == tamanio - 1)
            throw new actividad2_ExcepcionPilaLlena("La pila está llena, no se puede meter: " + valorAMeter);
        elementos[++superior] = valorAMeter;
    }

    // Retirar (pop)
    public E pop() {
        if (superior == -1)
            throw new actividad2_ExcepcionPilaVacia("La pila está vacía.");
        return elementos[superior--];
    }

    // Buscar un elemento sin alterar la pila
    public boolean contains(E elemento) {
        for (int i = superior; i >= 0; i--) {
            if (elementos[i].equals(elemento))
                return true;
        }
        return false;
    }

    // Comparar dos pilas (mismo tamaño y contenido)
    public boolean esIgual(actividad2_Pila<E> otraPila) {
        if (this.superior != otraPila.superior)
            return false;
        for (int i = 0; i <= superior; i++) {
            if (!this.elementos[i].equals(otraPila.elementos[i]))
                return false;
        }
        return true;
    }
}
