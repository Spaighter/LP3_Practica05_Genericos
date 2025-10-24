package practica06_MVC;


/*
 * Clase que representa un pedido individual.
 * Modelo del patrón MVC.
 */
public class actividad1_Pedido {
    private String nombrePlato;

    public actividad1_Pedido(String nombrePlato) {
        this.nombrePlato = nombrePlato;
    }

    public String getNombrePlato() {
        return nombrePlato;
    }
}
