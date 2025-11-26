package ejercicios.propuestos;

public class Producto {
    private String nombre;
    private double precio;
    private int cantidadStock;
    private String categoria;

    public Producto() {}

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public double getPrecio() { return precio; }
    public void setPrecio(double precio) { this.precio = precio; }
    public int getCantidadStock() { return cantidadStock; }
    public void setCantidadStock(int cantidadStock) { this.cantidadStock = cantidadStock; }
    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }

    @Override
    public String toString() {
        return "<html><b>Producto Confirmado:</b><br>" +
               "Nombre: " + nombre + " | Categoría: " + categoria + "<br>" +
               "Precio: S/. " + String.format("%.2f", precio) + "<br>" +
               "Stock Disponible: " + cantidadStock + "</html>";
    }
}