package plataforma;

public class Estudiante extends Persona {
    private String codigoEstudiante;

    public Estudiante(String nombre, String dni, String codigoEstudiante) {
        super(nombre, dni);
        this.codigoEstudiante = codigoEstudiante;
    }

    @Override
    public void mostrarDatos() {
        System.out.println("Estudiante: " + nombre + " | DNI: " + dni + " | Código: " + codigoEstudiante);
    }
}
