package plataforma;

public class Profesor extends Persona {
    private String especialidad;

    public Profesor(String nombre, String dni, String especialidad) {
        super(nombre, dni);
        this.especialidad = especialidad;
    }

    @Override
    public void mostrarDatos() {
        System.out.println("Profesor: " + nombre + " | DNI: " + dni + " | Especialidad: " + especialidad);
    }
}
