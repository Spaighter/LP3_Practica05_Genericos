package practica07_ManejoArchivosJava;

/*
 * Esta es la clase principal. 
 * Aquí creo un objeto Agenda y llamo al método bucle() para permitir la búsqueda de contactos.
 */
public class actividad5_AppContactos {

    public static void main(String[] args) {
        // Creo el objeto Agenda (esto carga automáticamente los contactos desde el archivo)
        actividad5_Agenda agenda = new actividad5_Agenda();

        // Inicio el ciclo de búsqueda
        agenda.bucle();
    }
}
