package practica06_MVC;

/*
 * En esta clase defino el modelo "Persona".
 * Aquí guardo los datos básicos: nombre y edad.
 * También agrego sus métodos para obtener y modificar esos datos.
 */
public class ejercicio1_Persona {
    // Atributos que representan a cada persona
    private String nombre;
    private int edad;

    // Constructor: cuando creo una persona, le asigno su nombre y edad
    public ejercicio1_Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    // Devuelvo el nombre
    public String getNombre() {
        return nombre;
    }

    // Devuelvo la edad
    public int getEdad() {
        return edad;
    }

    // Permito cambiar el nombre
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Permito cambiar la edad
    public void setEdad(int edad) {
        this.edad = edad;
    }

    // Cuando muestro el objeto, lo presento con este formato
    @Override
    public String toString() {
        return "- " + nombre + " (" + edad + " años)";
    }
}
