package practica07_ManejoArchivosJava;

/*
 * En esta clase defino el objeto Persona, que representa un contacto con nombre, teléfono y dirección.
 * Cada contacto se guarda como un objeto de esta clase.
 */
public class actividad5_Persona {
    protected String nombre;
    protected String telefono;
    protected String direccion;

    // Constructor: inicializo los valores del contacto
    public actividad5_Persona(String nombre, String telefono, String direccion) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    // Devuelvo el nombre (lo uso al buscar contactos)
    public String getNombre() {
        return nombre;
    }

    // Cuando convierto el objeto a texto, muestro sus datos formateados
    @Override
    public String toString() {
        return nombre + "\t" + telefono + "\t" + direccion + "\n";
    }
}
