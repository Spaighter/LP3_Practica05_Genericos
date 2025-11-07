package plataforma;

import java.util.ArrayList;
import java.util.List;

public class Curso {
    private String nombreCurso;
    private Profesor profesor;  // Agregación: curso tiene profesor
    private List<Estudiante> estudiantes; // Composición: curso contiene estudiantes

    // Variable de clase (estática)
    private static int totalCursos = 0;

    public Curso(String nombreCurso, Profesor profesor) {
        this.nombreCurso = nombreCurso;
        this.profesor = profesor;
        this.estudiantes = new ArrayList<>();
        totalCursos++;
    }

    public void inscribirEstudiante(Estudiante e) {
        estudiantes.add(e);
    }

    public void mostrarCurso() {
        System.out.println("Curso: " + nombreCurso);
        profesor.mostrarDatos();
        System.out.println("Estudiantes matriculados: " + estudiantes.size());
        for (Estudiante e : estudiantes) {
            e.mostrarDatos();
        }
    }

    public static int getTotalCursos() {
        return totalCursos;
    }
}

