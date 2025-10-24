package practica06_MVC;

/*
 * Clase principal del programa (Actividad 2).
 * Crea y conecta los componentes MVC.
 */
public class actividad2_Main {
    public static void main(String[] args) {
        actividad2_PedidoModelo modelo = new actividad2_PedidoModelo();
        actividad2_PedidoVista vista = new actividad2_PedidoVista();
        actividad2_PedidoControlador controlador = new actividad2_PedidoControlador(modelo, vista);
        controlador.iniciar();
    }
}
