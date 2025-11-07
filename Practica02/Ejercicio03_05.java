package plataforma;

import java.util.ArrayList;
import java.util.List;

public class SistemaGestion {
    private List<Curso> cursos;

    public SistemaGestion() {
        cursos = new ArrayList<>();
    }

    public void agregarCurso(Curso c) {
        cursos.add(c);
    }

    public void mostrarCursos() {
        System.out.println("=== LISTA DE CURSOS DISPONIBLES ===");
        for (Curso c : cursos) {
            c.mostrarCurso();
            System.out.println("-------------------------");
        }
        System.out.println("Total de cursos: " + Curso.getTotalCursos());
    }
}
