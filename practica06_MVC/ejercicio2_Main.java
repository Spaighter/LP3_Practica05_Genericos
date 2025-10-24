package practica06_MVC;

/*
 * En esta clase inicio todo el programa.
 * Creo el modelo, la vista y el controlador, y luego inicio el flujo del sistema.
 */
public class ejercicio2_Main {
    public static void main(String[] args) {
        // Creo el modelo donde se guardan los productos
        ejercicio2_ProductoModelo modelo = new ejercicio2_ProductoModelo();

        // Creo la vista que se encarga de mostrar y pedir datos
        ejercicio2_ProductoVista vista = new ejercicio2_ProductoVista();

        // Creo el controlador que une el modelo y la vista
        ejercicio2_ProductoControlador controlador = new ejercicio2_ProductoControlador(modelo, vista);

        // Inicio el programa
        controlador.iniciar();
    }
}
