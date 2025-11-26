package actividades.teoria;

import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class AppAudio extends JFrame {

    private Clip clipActual; // Mantiene referencia al audio que suena actualmente

    public AppAudio() {
        super("Botonera de Efectos de Sonido");
        
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        // Layout principal
        JPanel panelPrincipal = new JPanel(new GridLayout(2, 2, 10, 10)); // Rejilla 2x2
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        // --- CREACIÓN DE BOTONES ---
        // Asegúrate de tener estos archivos en recursos/audio/
        JButton btnCampana = crearBotonSonido("🔔 Campana", "recursos/audio/campana.wav", new Color(241, 196, 15));
        JButton btnAplausos = crearBotonSonido("👏 Aplausos", "recursos/audio/aplausos.wav", new Color(46, 204, 113));
        JButton btnExplosion = crearBotonSonido("💥 Explosión", "recursos/audio/explosion.wav", new Color(231, 76, 60));
        JButton btnCancion = crearBotonSonido("🎵 Canción", "recursos/audio/cancion.wav", new Color(52, 152, 219));

        panelPrincipal.add(btnCampana);
        panelPrincipal.add(btnAplausos);
        panelPrincipal.add(btnExplosion);
        panelPrincipal.add(btnCancion);

        // Panel inferior para el botón de detener
        JPanel panelInferior = new JPanel();
        JButton btnStop = new JButton("⏹ DETENER TODO");
        btnStop.setBackground(Color.DARK_GRAY);
        btnStop.setForeground(Color.WHITE);
        btnStop.addActionListener(e -> detenerSonido());
        panelInferior.add(btnStop);

        add(panelPrincipal, BorderLayout.CENTER);
        add(panelInferior, BorderLayout.SOUTH);
    }

    /**
     * Crea un botón configurado para reproducir un archivo específico.
     */
    private JButton crearBotonSonido(String texto, String rutaArchivo, Color colorFondo) {
        JButton btn = new JButton(texto);
        btn.setFont(new Font("Segoe UI Emoji", Font.BOLD, 16));
        btn.setBackground(colorFondo);
        btn.setForeground(Color.WHITE);
        btn.setFocusPainted(false);
        
        btn.addActionListener(e -> reproducirArchivo(rutaArchivo));
        
        return btn;
    }

    /**
     * Lógica central para reproducir sonido.
     * Detiene el anterior antes de iniciar el nuevo.
     */
    private void reproducirArchivo(String ruta) {
        detenerSonido(); // Detiene si hay algo sonando

        try {
            File archivo = new File(ruta);
            if (!archivo.exists()) {
                JOptionPane.showMessageDialog(this, "No se encuentra: " + ruta);
                return;
            }

            AudioInputStream audioStream = AudioSystem.getAudioInputStream(archivo);
            clipActual = AudioSystem.getClip();
            clipActual.open(audioStream);
            clipActual.start();

        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al reproducir audio.");
        }
    }

    private void detenerSonido() {
        if (clipActual != null && clipActual.isRunning()) {
            clipActual.stop();
            clipActual.close(); // Libera recursos
        }
    }

    public static void main(String[] args) {
        // Estilo visual moderno
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {}

        SwingUtilities.invokeLater(() -> new AppAudio().setVisible(true));
    }
}