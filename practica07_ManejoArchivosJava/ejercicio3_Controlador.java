package practica07_ManejoArchivosJava;

/*
 * En esta clase conecto la vista con el modelo (patrón MVC).
 * Manejo toda la lógica del menú principal.
 */
public class ejercicio3_Controlador {
    private ejercicio3_Modelo modelo;
    private ejercicio3_Vista vista;

    public ejercicio3_Controlador(ejercicio3_Modelo modelo, ejercicio3_Vista vista) {
        this.modelo = modelo;
        this.vista = vista;
    }

    public void iniciar() {
        int opcion;
        do {
            vista.mostrarMenu();
            opcion = vista.leerOpcion();
            switch (opcion) {
                case 1 -> vista.mostrarEmpleados(modelo.getEmpleados());
                case 2 -> {
                    ejercicio3_Empleado nuevo = vista.leerEmpleado();
                    modelo.agregarEmpleado(nuevo);
                }
                case 3 -> {
                    int num = vista.leerNumeroEmpleado();
                    vista.mostrarEmpleado(modelo.buscarEmpleado(num));
                }
                case 4 -> {
                    int num = vista.leerNumeroEmpleado();
                    modelo.eliminarEmpleado(num);
                }
                case 5 -> vista.mostrarMensaje("Saliendo del programa...");
                default -> vista.mostrarMensaje("Opción inválida.");
            }
        } while (opcion != 5);
    }
}
