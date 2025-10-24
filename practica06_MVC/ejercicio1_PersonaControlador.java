package practica06_MVC;

/*
 * En esta clase uno todo: el modelo y la vista.
 * Aquí controlo el flujo del programa, según las opciones del menú.
 */
public class ejercicio1_PersonaControlador {
    private ejercicio1_PersonaModelo modelo;
    private ejercicio1_PersonaVista vista;

    // Cuando creo el controlador, le paso el modelo y la vista
    public ejercicio1_PersonaControlador(ejercicio1_PersonaModelo modelo, ejercicio1_PersonaVista vista) {
        this.modelo = modelo;
        this.vista = vista;
    }

    // Método principal que mantiene activo el menú
    public void iniciar() {
        String opcion;
        do {
            vista.mostrarMenu(); // Muestro las opciones
            opcion = vista.solicitarOpcion(); // Leo la opción del usuario

            // Dependiendo de la opción, llamo a un método
            switch (opcion) {
                case "1": agregarPersona(); break;
                case "2": vista.mostrarPersonas(modelo.getPersonas()); break;
                case "3": buscarPersona(); break;
                case "4": actualizarEdad(); break;
                case "5": eliminarPersona(); break;
                case "6": vista.mostrarMensaje("Saliendo del programa..."); break;
                default: vista.mostrarMensaje("Opción no válida. Inténtalo nuevamente.");
            }
        } while (!opcion.equals("6")); // Mientras no elija salir, el programa sigue
        vista.cerrarScanner();
    }

    // Opción 1: agrego una nueva persona
    private void agregarPersona() {
        String nombre = vista.solicitarNombre();
        int edad = vista.solicitarEdad();
        modelo.agregarPersona(new ejercicio1_Persona(nombre, edad));
        vista.mostrarMensaje("Persona agregada correctamente.");
    }

    // Opción 3: busco una persona por su nombre
    private void buscarPersona() {
        String nombre = vista.solicitarNombre();
        ejercicio1_Persona persona = modelo.buscarPersona(nombre);
        if (persona != null) {
            vista.mostrarMensaje("Persona encontrada: " + persona);
        } else {
            vista.mostrarMensaje("No se encontró la persona.");
        }
    }

    // Opción 4: actualizo la edad de una persona existente
    private void actualizarEdad() {
        String nombre = vista.solicitarNombre();
        int nuevaEdad = vista.solicitarEdad();
        if (modelo.actualizarPersona(nombre, nuevaEdad)) {
            vista.mostrarMensaje("Edad actualizada correctamente.");
        } else {
            vista.mostrarMensaje("No se encontró la persona para actualizar.");
        }
    }

    // Opción 5: elimino una persona de la lista
    private void eliminarPersona() {
        String nombre = vista.solicitarNombre();
        if (modelo.eliminarPersona(nombre)) {
            vista.mostrarMensaje("Persona eliminada correctamente.");
        } else {
            vista.mostrarMensaje("No se encontró la persona para eliminar.");
        }
    }
}
