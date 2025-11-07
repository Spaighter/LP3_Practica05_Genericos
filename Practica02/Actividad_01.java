package Practica02;

/*
 * Clase principal Coche.
 * Contiene atributos, métodos y comportamiento de un coche.
 */
public class Actividad_01 {
    private String marca;
    private int anioFabricacion;
    private double precio;

    public Actividad_01(String marca, int anioFabricacion, double precio) {
        this.marca = marca;
        this.anioFabricacion = anioFabricacion;
        this.precio = precio;
    }

    public void aplicarDescuento() {
        if (anioFabricacion < 2010) {
            precio *= 0.9;
        }
    }

    public void mostrarDatos() {
        System.out.println("Coche: " + marca + " | Año: " + anioFabricacion + " | Precio: S/ " + precio);
    }

    public void encender() { System.out.println("El coche está encendido."); }
    public void acelerar() { System.out.println("El coche está acelerando."); }
    public void frenar() { System.out.println("El coche está frenando."); }
    public void apagar() { System.out.println("El coche se ha apagado."); }
}
