package practica07_ManejoArchivosJava;

import java.io.Serializable;

/*
 * En esta clase defino a una persona base con atributos comunes.
 * La marco como Serializable porque será la clase padre de Alumno.
 */
public class actividad6_Persona implements Serializable {
    protected String nif;
    protected String nombre;
    protected int edad;

    // Constructor con parámetros
    public actividad6_Persona(String nif, String nombre, int edad) {
        this.nif = nif;
        this.nombre = nombre;
        this.edad = edad;
    }

    // Constructor vacío
    public actividad6_Persona() {
    }

    // Métodos get y set
    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    // Muestro los datos de la persona
    @Override
    public String toString() {
        return "NIF: " + nif + ", Nombre: " + nombre + ", Edad: " + edad;
    }
}
