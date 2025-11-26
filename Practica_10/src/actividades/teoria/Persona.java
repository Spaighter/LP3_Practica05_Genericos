package actividades.teoria;

/**
 * Clase Modelo para la demostración de Binding de Datos.
 */
public class Persona {
    
    private String nombre;
    private int edad;
    private String ciudad;

    // Constructor
    public Persona(String nombre, int edad, String ciudad) {
        this.nombre = nombre;
        this.edad = edad;
        this.ciudad = ciudad;
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public String getCiudad() {
        return ciudad;
    }

    // Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
    
    @Override
    public String toString() {
        return "Modelo Actualizado: \n" +
               "Nombre: " + nombre + "\n" +
               "Edad: " + edad + "\n" +
               "Ciudad: " + ciudad;
    }
}