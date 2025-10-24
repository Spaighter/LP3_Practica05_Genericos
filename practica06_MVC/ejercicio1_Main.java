package practica06_MVC;

/*
 * En esta clase inicio todo el programa.
 * Aquí creo el modelo, la vista y el controlador.
 * Luego llamo al método "iniciar()" del controlador para comenzar el flujo.
 */
public class ejercicio1_Main {
    public static void main(String[] args) {
        // Creo el modelo (donde se guardan los datos)
        ejercicio1_PersonaModelo modelo = new ejercicio1_PersonaModelo();

        // Creo la vista (donde se muestra la interfaz)
        ejercicio1_PersonaVista vista = new ejercicio1_PersonaVista();

        // Creo el controlador y le paso el modelo y la vista
        ejercicio1_PersonaControlador controlador = new ejercicio1_PersonaControlador(modelo, vista);

        // Inicio el programa
        controlador.iniciar();
    }
}
