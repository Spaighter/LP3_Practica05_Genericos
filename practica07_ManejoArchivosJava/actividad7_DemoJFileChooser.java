package practica07_ManejoArchivosJava;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/*
 * En esta clase diseño una interfaz gráfica que me permite seleccionar un archivo o carpeta
 * mediante un cuadro de diálogo JFileChooser. 
 * Luego muestro toda la información del archivo seleccionado (tamaño, fecha, tipo, etc.).
 */
public class actividad7_DemoJFileChooser extends JFrame implements ActionListener {

    private JTextArea areaTexto; // Aquí muestro la información
    private JButton botonAbrir;  // Botón para abrir el explorador de archivos
    private JFileChooser selectorArchivos; // Cuadro de diálogo para seleccionar archivos

    public actividad7_DemoJFileChooser() {
        super("Explorador de archivos con JFileChooser");

        // Configuro el área de texto
        areaTexto = new JTextArea(15, 50);
        areaTexto.setEditable(false);

        // Configuro el botón
        botonAbrir = new JButton("Seleccionar archivo o carpeta");
        botonAbrir.addActionListener(this);

        // Creo el selector de archivos
        selectorArchivos = new JFileChooser();
        selectorArchivos.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

        // Agrego los componentes al JFrame
        add(botonAbrir, BorderLayout.NORTH);
        add(new JScrollPane(areaTexto), BorderLayout.CENTER);

        // Configuro la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
    }

    // Este método se ejecuta cuando presiono el botón
    @Override
    public void actionPerformed(ActionEvent e) {
        // Abro el cuadro de diálogo
        int resultado = selectorArchivos.showOpenDialog(this);

        // Si el usuario elige un archivo y presiona "Abrir"
        if (resultado == JFileChooser.APPROVE_OPTION) {
            Path rutaSeleccionada = selectorArchivos.getSelectedFile().toPath();
            mostrarInformacionArchivo(rutaSeleccionada);
        }
    }

    // En este método obtengo y muestro la información del archivo o directorio
    private void mostrarInformacionArchivo(Path ruta) {
        try {
            StringBuilder info = new StringBuilder();

            info.append("Nombre: ").append(ruta.getFileName()).append("\n");
            info.append("Ruta absoluta: ").append(ruta.toAbsolutePath()).append("\n");
            info.append("¿Es directorio?: ").append(Files.isDirectory(ruta) ? "Sí" : "No").append("\n");
            info.append("¿Es archivo?: ").append(Files.isRegularFile(ruta) ? "Sí" : "No").append("\n");
            info.append("¿Ruta absoluta?: ").append(ruta.isAbsolute() ? "Sí" : "No").append("\n");
            info.append("Tamaño: ").append(Files.size(ruta)).append(" bytes\n");

            BasicFileAttributes atributos = Files.readAttributes(ruta, BasicFileAttributes.class);
            info.append("Última modificación: ").append(atributos.lastModifiedTime()).append("\n");

            // Si es un directorio, muestro su contenido
            if (Files.isDirectory(ruta)) {
                info.append("\nContenido del directorio:\n");
                try (DirectoryStream<Path> flujo = Files.newDirectoryStream(ruta)) {
                    for (Path archivo : flujo) {
                        info.append("   - ").append(archivo.getFileName()).append("\n");
                    }
                }
            }

            // Muestro toda la información en el área de texto
            areaTexto.setText(info.toString());

        } catch (IOException e) {
            areaTexto.setText("Error al obtener la información: " + e.getMessage());
        }
    }
}
