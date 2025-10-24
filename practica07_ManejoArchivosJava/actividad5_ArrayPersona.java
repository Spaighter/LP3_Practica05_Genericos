package practica07_ManejoArchivosJava;

/*
 * En esta clase guardo un conjunto de personas dentro de un arreglo.
 * También implemento métodos para agregar y buscar contactos.
 */
public class actividad5_ArrayPersona {
    private actividad5_Persona[] arreglo;
    private final int max = 128; // Tamaño máximo de la agenda
    private int tamano = 0;

    // Constructor: creo un arreglo vacío del tamaño máximo
    public actividad5_ArrayPersona() {
        arreglo = new actividad5_Persona[max];
    }

    // Agrego una nueva persona al arreglo
    public void addPersona(actividad5_Persona persona) {
        if (tamano == max) {
            System.out.println("Agenda llena, no se pueden agregar más contactos.");
            System.exit(1);
        }
        arreglo[tamano++] = persona;
    }

    // Busco una persona por nombre y la imprimo si existe
    public void printPersona(String nombre) {
        boolean encontrada = false;
        for (int i = 0; i < tamano; i++) {
            if (arreglo[i].getNombre().equalsIgnoreCase(nombre)) {
                System.out.println("Contacto encontrado:");
                System.out.print(arreglo[i]);
                encontrada = true;
            }
        }
        if (!encontrada)
            System.out.println("El contacto no existe en la agenda.");
    }
}
