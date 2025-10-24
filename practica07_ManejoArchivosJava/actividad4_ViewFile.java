package practica07_ManejoArchivosJava;

import javax.swing.*;

/*
 * Esta clase crea una interfaz gráfica para mostrar el contenido del archivo.
 * Heredo de JFrame y utilizo un JTextArea con barras de desplazamiento.
 */
public class actividad4_ViewFile extends JFrame {
    private JTextArea areaTexto;

    // Constructor: aquí configuro la ventana
    public actividad4_ViewFile(String titulo) {
        super(titulo); // Asigno el título al JFrame
        areaTexto = new JTextArea(10, 40); // Creo un área de texto con 10 filas y 40 columnas
        add(new JScrollPane(areaTexto)); // Agrego el área dentro de un panel con scroll
    }

    // Método para mostrar el texto leído del archivo
    public void mostrarTexto(String texto) {
        areaTexto.setText(texto);
    }
}
