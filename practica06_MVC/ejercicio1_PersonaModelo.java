package practica06_MVC;

import java.util.ArrayList;
import java.util.List;

/*
 * En esta clase manejo toda la lógica del programa.
 * Aquí guardo la lista de personas y realizo las operaciones sobre ellas:
 * agregar, eliminar, buscar y actualizar.
 */
public class ejercicio1_PersonaModelo {
    // Creo una lista donde guardo todas las personas registradas
    private List<ejercicio1_Persona> personas;

    // Inicializo la lista vacía al crear el modelo
    public ejercicio1_PersonaModelo() {
        personas = new ArrayList<>();
    }

    // Agrego una persona nueva a la lista
    public void agregarPersona(ejercicio1_Persona persona) {
        personas.add(persona);
    }

    // Devuelvo la lista completa de personas
    public List<ejercicio1_Persona> getPersonas() {
        return personas;
    }

    // Elimino una persona buscando por nombre
    public boolean eliminarPersona(String nombre) {
        // Uso removeIf: elimina si el nombre coincide sin importar mayúsculas
        return personas.removeIf(p -> p.getNombre().equalsIgnoreCase(nombre));
    }

    // Actualizo la edad de una persona buscándola por su nombre
    public boolean actualizarPersona(String nombre, int nuevaEdad) {
        for (ejercicio1_Persona p : personas) {
            if (p.getNombre().equalsIgnoreCase(nombre)) {
                p.setEdad(nuevaEdad);
                return true;
            }
        }
        return false;
    }

    // Busco una persona por su nombre y la devuelvo
    public ejercicio1_Persona buscarPersona(String nombre) {
        for (ejercicio1_Persona p : personas) {
            if (p.getNombre().equalsIgnoreCase(nombre)) {
                return p;
            }
        }
        return null; // Si no la encuentro, devuelvo null
    }
}
