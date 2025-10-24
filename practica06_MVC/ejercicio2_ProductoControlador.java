package practica06_MVC;

/*
 * En esta clase uno todo el sistema: la vista y el modelo.
 * Aquí controlo el flujo del programa según la opción que elija el usuario.
 */
public class ejercicio2_ProductoControlador {
    private ejercicio2_ProductoModelo modelo;
    private ejercicio2_ProductoVista vista;

    // En el constructor conecto el modelo con la vista
    public ejercicio2_ProductoControlador(ejercicio2_ProductoModelo modelo, ejercicio2_ProductoVista vista) {
        this.modelo = modelo;
        this.vista = vista;
    }

    // Este método es el corazón del programa: mantiene el menú funcionando
    public void iniciar() {
        String opcion;
        do {
            vista.mostrarMenu(); // Muestro las opciones
            opcion = vista.solicitarOpcion(); // Leo la opción elegida

            // Según la opción, llamo al método correspondiente
            switch (opcion) {
                case "1": agregarProducto(); break;
                case "2": vista.mostrarProductos(modelo.getProductos()); break;
                case "3": buscarProducto(); break;
                case "4": actualizarProducto(); break;
                case "5": eliminarProducto(); break;
                case "6": calcularInventario(); break;
                case "7": vista.mostrarMensaje("Saliendo del sistema..."); break;
                default: vista.mostrarMensaje("Opción no válida. Inténtalo nuevamente.");
            }
        } while (!opcion.equals("7")); // El programa termina solo si elige 7
        vista.cerrarScanner();
    }

    // Opción 1: agrego un nuevo producto
    private void agregarProducto() {
        String nombre = vista.solicitarNombre();
        double precio = vista.solicitarPrecio();
        int cantidad = vista.solicitarCantidad();
        modelo.agregarProducto(new ejercicio2_Producto(nombre, precio, cantidad));
        vista.mostrarMensaje("Producto agregado correctamente.");
    }

    // Opción 3: busco un producto por su nombre
    private void buscarProducto() {
        String nombre = vista.solicitarNombre();
        ejercicio2_Producto producto = modelo.buscarProducto(nombre);
        if (producto != null) {
            vista.mostrarMensaje("Producto encontrado: " + producto);
        } else {
            vista.mostrarMensaje("No se encontró el producto.");
        }
    }

    // Opción 4: actualizo los datos de un producto existente
    private void actualizarProducto() {
        String nombre = vista.solicitarNombre();
        double nuevoPrecio = vista.solicitarPrecio();
        int nuevaCantidad = vista.solicitarCantidad();
        if (modelo.actualizarProducto(nombre, nuevoPrecio, nuevaCantidad)) {
            vista.mostrarMensaje("Producto actualizado correctamente.");
        } else {
            vista.mostrarMensaje("No se encontró el producto para actualizar.");
        }
    }

    // Opción 5: elimino un producto del inventario
    private void eliminarProducto() {
        String nombre = vista.solicitarNombre();
        if (modelo.eliminarProducto(nombre)) {
            vista.mostrarMensaje("Producto eliminado correctamente.");
        } else {
            vista.mostrarMensaje("No se encontró el producto.");
        }
    }

    // Opción 6: calculo el valor total del inventario
    private void calcularInventario() {
        double total = modelo.calcularValorInventario();
        vista.mostrarMensaje("Valor total del inventario: S/." + total);
    }
}
