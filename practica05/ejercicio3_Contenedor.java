package practica05;

import java.util.ArrayList;

/*
 * Clase genérica ejercicio3_Contenedor<F, S>
 * Almacena múltiples objetos de tipo ejercicio1_Par<F, S>.
 * Permite agregar, obtener y mostrar pares.
 */
public class ejercicio3_Contenedor<F, S> {
    private ArrayList<ejercicio1_Par<F, S>> pares;

    // Constructor que inicializa la lista de pares
    public ejercicio3_Contenedor() {
        pares = new ArrayList<>();
    }

    // Agrega un nuevo par al contenedor
    public void agregarPar(F primero, S segundo) {
        pares.add(new ejercicio1_Par<>(primero, segundo));
    }

    // Devuelve el par ubicado en un índice específico
    public ejercicio1_Par<F, S> obtenerPar(int indice) {
        return pares.get(indice);
    }

    // Devuelve la lista completa de pares
    public ArrayList<ejercicio1_Par<F, S>> obtenerTodosLosPares() {
        return pares;
    }

    // Muestra todos los pares almacenados en la lista
    public void mostrarPares() {
        System.out.println("Listado de pares almacenados:");
        for (ejercicio1_Par<F, S> par : pares) {
            System.out.println(par);
        }
    }
}
