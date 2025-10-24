package practica07_ManejoArchivosJava;

/*
 * Esta clase extiende de Persona y añade un atributo tipo Fecha.
 * Representa la composición entre clases: Alumno contiene un objeto Fecha.
 */
public class actividad6_Alumno extends actividad6_Persona {

    private actividad6_Fecha fechaMatricula;

    // Constructor completo
    public actividad6_Alumno(String nif, String nombre, int edad, actividad6_Fecha fechaMatricula) {
        super(nif, nombre, edad);
        this.fechaMatricula = fechaMatricula;
    }

    // Constructor vacío
    public actividad6_Alumno() {
        super();
    }

    // Métodos get y set
    public actividad6_Fecha getFechaMatricula() {
        return fechaMatricula;
    }

    public void setFechaMatricula(actividad6_Fecha fechaMatricula) {
        this.fechaMatricula = fechaMatricula;
    }

    // Sobrescribo toString para mostrar también la fecha
    @Override
    public String toString() {
        return super.toString() + ", Fecha de Matrícula: " + fechaMatricula;
    }
}
