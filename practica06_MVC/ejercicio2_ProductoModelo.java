package practica06_MVC;

import java.util.ArrayList;
import java.util.List;

/*
 * En esta clase manejo toda la lógica del programa.
 * Aquí guardo la lista de productos y hago todas las operaciones sobre ella.
 * Es el "modelo" del patrón MVC.
 */
public class ejercicio2_ProductoModelo {
    // Creo una lista donde se guardan todos los productos registrados
    private List<ejercicio2_Producto> productos;

    // Inicializo la lista vacía al crear el modelo
    public ejercicio2_ProductoModelo() {
        productos = new ArrayList<>();
    }

    // Agrego un nuevo producto a la lista
    public void agregarProducto(ejercicio2_Producto producto) {
        productos.add(producto);
    }

    // Devuelvo la lista completa de productos
    public List<ejercicio2_Producto> getProductos() {
        return productos;
    }

    // Busco un producto por su nombre (ignoro mayúsculas/minúsculas)
    public ejercicio2_Producto buscarProducto(String nombre) {
        for (ejercicio2_Producto p : productos) {
            if (p.getNombre().equalsIgnoreCase(nombre)) {
                return p;
            }
        }
        return null; // Si no lo encuentro, retorno null
    }

    // Elimino un producto de la lista si coincide con el nombre
    public boolean eliminarProducto(String nombre) {
        return productos.removeIf(p -> p.getNombre().equalsIgnoreCase(nombre));
    }

    // Actualizo el precio y la cantidad de un producto existente
    public boolean actualizarProducto(String nombre, double nuevoPrecio, int nuevaCantidad) {
        for (ejercicio2_Producto p : productos) {
            if (p.getNombre().equalsIgnoreCase(nombre)) {
                p.setPrecio(nuevoPrecio);
                p.setCantidad(nuevaCantidad);
                return true; // Si lo encuentro y actualizo, devuelvo true
            }
        }
        return false; // Si no existe, devuelvo false
    }

    // Calculo el valor total del inventario (precio * cantidad de cada producto)
    public double calcularValorInventario() {
        double total = 0;
        for (ejercicio2_Producto p : productos) {
            total += p.getPrecio() * p.getCantidad();
        }
        return total;
    }
}

