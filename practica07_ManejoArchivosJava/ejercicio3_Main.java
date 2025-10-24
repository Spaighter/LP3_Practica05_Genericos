package practica07_ManejoArchivosJava;

/*
 * En esta clase inicio el programa y conecto el Modelo, Vista y Controlador.
 */
public class ejercicio3_Main {
    public static void main(String[] args) {
        ejercicio3_Modelo modelo = new ejercicio3_Modelo();
        ejercicio3_Vista vista = new ejercicio3_Vista();
        ejercicio3_Controlador controlador = new ejercicio3_Controlador(modelo, vista);
        controlador.iniciar();
    }
}
