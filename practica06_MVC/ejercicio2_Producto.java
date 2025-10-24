package practica06_MVC;

/*
 * En esta clase defino mi modelo "Producto".
 * Aquí guardo la información principal de cada producto: nombre, precio y cantidad.
 * También agrego los métodos que me permiten acceder y modificar esos datos.
 */
public class ejercicio2_Producto {
    // Atributos del producto
    private String nombre;
    private double precio;
    private int cantidad;

    // Constructor: cuando creo un nuevo producto, le asigno su nombre, precio y cantidad
    public ejercicio2_Producto(String nombre, double precio, int cantidad) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    // Devuelvo el nombre del producto
    public String getNombre() {
        return nombre;
    }

    // Devuelvo el precio actual
    public double getPrecio() {
        return precio;
    }

    // Devuelvo la cantidad en stock
    public int getCantidad() {
        return cantidad;
    }

    // Permito modificar el precio
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    // Permito modificar la cantidad disponible
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    // Cuando muestro el producto, aparece en formato legible
    @Override
    public String toString() {
        return "- " + nombre + " | Precio: S/." + precio + " | Stock: " + cantidad;
    }
}
