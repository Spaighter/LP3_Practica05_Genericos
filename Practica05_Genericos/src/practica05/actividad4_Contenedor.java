package practica05;

import java.util.ArrayList;

public class actividad4_Contenedor<F, S> {
    private ArrayList<actividad4_Par<F, S>> pares;

    public actividad4_Contenedor() {
        pares = new ArrayList<>();
    }

    public void agregarPar(F primero, S segundo) {
        pares.add(new actividad4_Par<>(primero, segundo));
    }

    public actividad4_Par<F, S> obtenerPar(int indice) {
        return pares.get(indice);
    }

    public ArrayList<actividad4_Par<F, S>> obtenerTodosLosPares() {
        return pares;
    }

    public void mostrarPares() {
        for (actividad4_Par<F, S> par : pares) {
            System.out.println(par);
        }
    }
}
