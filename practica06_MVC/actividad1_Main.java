package practica06_MVC;

/*
 * Clase principal del programa.
 * Crea los componentes MVC y los conecta.
 */
public class actividad1_Main {
    public static void main(String[] args) {
        actividad1_PedidoModelo modelo = new actividad1_PedidoModelo();
        actividad1_PedidoVista vista = new actividad1_PedidoVista();
        actividad1_PedidoControlador controlador = new actividad1_PedidoControlador(modelo, vista);

        controlador.iniciar();
    }
}
