package practica06_MVC;

/*
 * Clase principal que ejecuta la aplicación MVC (Actividad 3).
 */
public class actividad3_Main {
    public static void main(String[] args) {
        actividad3_PedidoModelo modelo = new actividad3_PedidoModelo();
        actividad3_PedidoVista vista = new actividad3_PedidoVista();
        actividad3_PedidoControlador controlador = new actividad3_PedidoControlador(modelo, vista);
        controlador.iniciar();
    }
}
