package plataforma;

public class Main {
    public static void main(String[] args) {
        Profesor p1 = new Profesor("Maria Delgado", "1321256", "Matematicas");
        Profesor p2 = new Profesor("Sergio Barrios", "87654321", "Programacion");

        Curso c1 = new Curso("Calculo Integral", p1);
        Curso c2 = new Curso("Lenguaje de Java", p2);

        Estudiante e1 = new Estudiante("Carlitos Sambrano", "11111111", "E001");
        Estudiante e2 = new Estudiante("Angela Aguilar", "22222222", "E002");

        c1.inscribirEstudiante(e1);
        c1.inscribirEstudiante(e2);
        c2.inscribirEstudiante(e2);

        SistemaGestion sistema = new SistemaGestion();
        sistema.agregarCurso(c1);
        sistema.agregarCurso(c2);

        sistema.mostrarCursos();

        Persona persona = e1;
        persona.mostrarDatos();
    }
}

