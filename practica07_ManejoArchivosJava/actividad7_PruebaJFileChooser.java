package practica07_ManejoArchivosJava;

import javax.swing.*;
/*
 * En esta clase simplemente creo un objeto de la interfaz DemoJFileChooser 
 * y lo muestro en pantalla.
 */
public class actividad7_PruebaJFileChooser {

    public static void main(String[] args) {
        // Creo la ventana principal del programa
        actividad7_DemoJFileChooser ventana = new actividad7_DemoJFileChooser();

        // Ajusto el tamaño de la ventana
        ventana.setSize(700, 500);

        // Hago visible la ventana
        ventana.setVisible(true);
    }
}
